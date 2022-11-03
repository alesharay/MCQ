#!/usr/bin/env bash

# mongosh --username admin --password admin --authenticationDatabase=admin
RESET='\033[0m'           # Text Reset

# Regular Colors
BLACK='\033[0;30m'        # Black
RED='\033[0;31m'          # Red
GREEN='\033[0;32m'        # Green
YELLOW='\033[0;33m'       # Yellow
BLUE='\033[0;34m'         # Blue
PURPLE='\033[0;35m'       # Purple
CYAN='\033[0;36m'         # Cyan
WHITE='\033[0;37m'        # White

# Bold
BBLACK='\033[1;30m'       # Black
BRED='\033[1;31m'         # Red
BGREEN='\033[1;32m'       # Green
BYELLOW='\033[1;33m'      # Yellow
BBLUE='\033[1;34m'        # Blue
BPURPLE='\033[1;35m'      # Purple
BCYAN='\033[1;36m'        # Cyan
BWHITE='\033[1;37m'       # White


INDEX="0"
DOCUMENTS=`curl -s http://localhost:8102/questions/api/v1/`
SIZE=`echo $DOCUMENTS |  jq length`

## Joins arrays for multiple answer questions
# Aids in allowing the answers to be entered in any order
#
# param $1: Delimiter to join string on (including the empty delimiter)
#
function joinArray() {
  local result=`IFS="$1"; shift; echo "$*";`
  echo "$result"
}

## Takes the string of answers (for multiple answer questions) and turns them into an array
#
# param $1: String to be converted into array
#
function stringToArray() {
  local myvar=$1
  echo "$1" | grep -o .
}

## Sorts the array of answers (for multiple answer questions)
#
# param $1: String to be sorted
#
function sortArray() {
  string="$1"
  sorted=`printf "%s\n" $string | sort`
  echo -n $sorted
}

## Creates a string containing the list of available question numbers
#
function getNums() {
  local nums=""
  num=0
  while [[ ${num} -lt ${SIZE} ]]
  do
    nums+=`echo "'$num '"`
    num=$((num + 1))
  done
  echo "$nums"
}

## Gets a random number from the list of available numbers
#
LIST_OF_NUMS=`getNums`
function getRandomNumber() {
  numbers="$LIST_OF_NUMS"
  while [[ ${#numbers} -gt 0 ]]
  do
    local index=$(( $RANDOM % ${SIZE} ))
    formattedIndex="'$index '"
    if [[ $numbers =~ "$formattedIndex" ]]; then
      numbers=`echo $numbers | sed "s/$formattedIndex//"`
      LIST_OF_NUMS="$numbers"
      echo $index
      break;
    fi
  done
}

## Run quiz
#
function getAllQuestions() {

  FILENAME="results.txt"


  # Display total number of questions based on size of json list
  echo -e "${YELLOW}$SIZE Questions Total${RESET}" | tee -a ${FILENAME}
  echo | tee -a ${FILENAME}
  CORRECT=0

  TOTAL=0
  while [[ $INDEX -ne $SIZE ]];
  do

    # Make sure the random element hadn't been seen yet
    element=`getRandomNumber`
    formattedElement="'$element '"
    while [[ $seenElements =~ "$formattedElement" ]]
    do
      element=`getRandomNumber`
      formattedElement="'$element '"
    done
    seenElements+=`echo "$formattedElement"`
    echo | tee -a ${FILENAME}
    echo | tee -a ${FILENAME}


    TOTAL=$(($INDEX+1))
    echo -en "$TOTAL. " | tee -a ${FILENAME}

    # Display the current question (formatted)
    echo "$DOCUMENTS" | \
      jq --argjson index $element '.[$index].question' | \
      sed 's/\\n/\n/g' | \
      sed 's/\\"/"/g' | \
      sed 's/\\N/\N/g' | \
      sed 's/\\t/\t/g' | \
      awk -F\\n -v blue=${BLUE} -v reset=${RESET} '{ print blue$1 $2reset; }' | tee -a ${FILENAME}


    # Display the options (formatted) for current question
    echo "$DOCUMENTS" | \
      jq --argjson index $element '.[$index].options' | \
      sed 's/\\n/\n/g' | \
      sed 's/\"//g' | \
      sed 's/\\N/\N/g' | \
      sed 's/\\t/\t/g' | tee -a ${FILENAME}
    echo | tee -a ${FILENAME}


    # Take in input from user
    echo -ne "\n(examples: d | bcd | q) (q to quit)\nSelection (letter(s) only): "
    read -e SELECTION
    SELECTION=`echo $SELECTION | xargs | tr '[:lower:]' '[:upper:']`
    echo | tee -a ${FILENAME}


    # Get correct answer for current question
    ANSWER=`echo "$DOCUMENTS" | jq --argjson index $element '.[$index].answer' | \
    sed 's/\"//g' | xargs`


    # Check if user chooses to quit
    if [[ "$SELECTION" == "Q" ]];
    then
      echo -e "${BRED}Goodbye!${RESET}"
      break
    fi
    echo | tee -a ${FILENAME}


    # Get answer type for current question
    TYPE=`echo "$DOCUMENTS" | jq --argjson index $element '.[$index].type' | \
    sed 's/\"//g' | xargs | tr ''[:lower:] '[:upper:]'`


    # If the current question type is multiple answer, sort it to match it against the correct answer
    # This allows user to enter multiple answer responses in any order
    if [[ "$TYPE" == "MULTIPLE ANSWER" ]]; then
      string_array=(`stringToArray "$SELECTION"`)
      answer=`echo ${string_array[@]}`
      SELECTION=`sortArray  "${answer}" | sed 's/ //g'`
    fi

    # Grade the user response to the current question as correct or incorrect
    if [[ "$SELECTION" == "$ANSWER" ]]; then
      CORRECT=$((CORRECT + 1))
      echo -e "${BGREEN}Correct!${RESET}" | tee -a ${FILENAME}
    else
      echo -e "${BRED}Incorrect!${RESET} Correct answer is ${GREEN}$ANSWER${RESET}" | tee -a ${FILENAME}
    fi


    # Display the explanation of the answer to the current question
    EXPLANATION=`echo "$DOCUMENTS" | jq --argjson index $element '.[$index].explanation' | sed 's/\"//g'`
    echo -e "$EXPLANATION" | tee -a ${FILENAME}
    echo | tee -a ${FILENAME}

    INDEX=$(($INDEX+1))
  done


  # Get the percentage of correct answers (avoiding 'divide-by-zero' errors)
  if [[ $CORRECT -eq 0 ]]; then
    percentScore=0
  else
    percentScore=`awk -v correct=$CORRECT -v total=$INDEX 'BEGIN{printf "%d",correct/total*100}'`
  fi

  # Display the score
  echo -e "${BPURPLE}\n\nFinal Score${RESET}: $CORRECT correct / $INDEX answered - ${BPURPLE}$percentScore%${RESET}) " | tee -a ${FILENAME}
}

getAllQuestions