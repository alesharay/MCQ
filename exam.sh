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


function joinArray() {
  local result=`IFS="$1"; shift; echo "$*";`
  echo "$result"
}


function stringToArray() {
  local myvar=$1
  echo "$1" | grep -o .
}


function sortArray() {
  string="$1"
  sorted=`printf "%s\n" $string | sort`
  echo -n $sorted
}


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


LIST_OF_NUMS=`getNums`
function getRandomNumber() {
  numbers="$LIST_OF_NUMS"
  local index=$(( $RANDOM % ${SIZE} ))
  numbers=`echo $numbers | sed "s/\'$index\ '//"`
  echo $index
}


function getAllQuestions() {

  echo -e "${YELLOW}$SIZE Questions Total${RESET}" ; echo
  CORRECT=0

  TOTAL=0
  while [[ $INDEX -ne $SIZE ]];
  do
    element=`getRandomNumber`
    TOTAL=$(($INDEX+1))

    echo -en "$TOTAL. " ;
    echo "$DOCUMENTS" | \
      jq --argjson index $element '.[$index].question' | \
      sed 's/\\n/\n/g' | \
      sed 's/\\"/"/g' | \
      sed 's/\\t/\t/g' | \
      awk -F\\n -v blue=${BLUE} -v reset=${RESET} '{ print blue$1 $2reset; }'

    echo "$DOCUMENTS" | \
      jq --argjson index $element '.[$index].options' | \
      sed 's/\\n/\n/g' | \
      sed 's/\"//g' | \
      sed 's/\\t/\t/g'

    echo

    echo -ne "\n(examples: d | bcd | q) (q to quit)\nSelection (letter(s) only): "
    read -e SELECTION
    SELECTION=`echo $SELECTION | xargs | tr '[:lower:]' '[:upper:']`

    echo

    ANSWER=`echo "$DOCUMENTS" | jq --argjson index $element '.[$index].answer' | \
    sed 's/\"//g' | xargs`

    if [[ "$SELECTION" == "Q" ]];
    then
      echo -e "${BRED}Goodbye!${RESET}"
      break
    fi

    echo

    TYPE=`echo "$DOCUMENTS" | jq --argjson index $element '.[$index].type' | \
    sed 's/\"//g' | xargs | tr ''[:lower:] '[:upper:]'`

    if [[ "$TYPE" == "MULTIPLE ANSWER" ]]; then
      string_array=(`stringToArray "$SELECTION"`)
      answer=`echo ${string_array[@]}`
      SELECTION=`sortArray  "${answer}" | sed 's/ //g'`
    fi

    echo

    if [[ "$SELECTION" == "$ANSWER" ]]; then
      CORRECT=$((CORRECT + 1))
      echo -e "${BGREEN}Correct!${RESET}"
    else
      echo -e "${BRED}Incorrect!${RESET} Correct answer is ${GREEN}$ANSWER${RESET}"
    fi


    EXPLANATION=`echo "$DOCUMENTS" | jq --argjson index $element '.[$index].explanation' | sed 's/\"//g'`
    echo -e "$EXPLANATION"

    echo

    INDEX=$(($INDEX+1))
  done


  if [[ $CORRECT -eq 0 ]]; then
    percentScore=0
  else
      percentScore=`awk -v correct=$CORRECT -v total=$INDEX 'BEGIN{printf "%d",correct/total*100}'`
  fi

  echo -e "${BPURPLE}\n\nFinal Score${RESET}: $CORRECT correct / $INDEX answered - ${BPURPLE}$percentScore%${RESET}) "
}

getAllQuestions