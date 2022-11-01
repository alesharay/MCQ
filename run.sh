#!/usr/bin/env bash

# script was required because make doesn't 'cleanly' allow the resetting of variables from other variables

RED='\033[0;31m'
BRED='\033[1;31m'
#---
YELLOW='\033[0;33m'
BYELLOW='\033[1;33m'
#---
GREEN='\033[0;32m'
BGREEN='\033[1;32m'
#---
BLUE='\033[0;36m'
BBLUE='\033[1;36m'
#---
BOLD='\033[1m'
#---
RESET='\033[0m'
BRESET='\033[1m'



if [ -z $1 ]; then 
read -p $'
\e[36mAVAILABLE QUZZES:\e[0m
  A. AWS Certified Cloud Practitioner (CLF-C01)
  B. HashiCorp: Terraform Associate (002)
  C. Microsoft Certified: Azure Fundamentals (AZ-900)
  D. Template
\e[36mOPTIONS\e[0m
  H. Help
  Q. Quit

\e[36mPlease make a selection: \e[0m' RESPONSE 

ANSWER=$(echo $RESPONSE | tr '[:lower:]' '[:upper:]')
else
ANSWER=$(echo $CHOICE | tr '[:lower:]' '[:upper:]')
fi

echo
case $ANSWER in
  A|AWS)
    clear ; echo -e "Chosen Quiz: ${BYELLOW}AWS Certified Cloud Practitioner (CLF-C01)${RESET}"
    make generating AWS
    mv results.txt aws-results.txt
    echo ; echo
    echo -e "Results file created at ${BGREEN}aws-results.txt${RESET}"
    echo
    ;;
  B|TERRAFORM)
    clear ; echo -e "Chosen Quiz: ${BYELLOW}HashiCorp: Terraform Associate (002)${RESET}"
    make generating TERRAFORM
    mv results.txt terraform-results.txt
    echo ; echo
    echo -e "Results file created at ${BGREEN}terraform-results.txt${RESET}"
    echo
    ;;
  C|AZURE)
    clear ; echo -e "Chosen Quiz: ${BYELLOW}Microsoft Certified: Azure Fundamentals (AZ-900)${RESET}"
    make generating AZURE
    mv results.txt azure-results.txt
    echo ; echo
    echo -e "Results file created at ${BGREEN}azure-results.txt${RESET}"
    echo
    ;;
  H|HELP)
    clear
    make usage
    echo
    ;;
  Q|Quit)
    echo -e ${BRED}"Goodbye!"${RESET}
    echo
    ;;
  *)
    make usage
    ;;
esac