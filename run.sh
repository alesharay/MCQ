#!/usr/bin/env bash

# script was required because make doesn't 'cleanly' allow the resetting of variables from other variables

if [ -z $1 ]; then 
read -p "
AVAILABLE QUZZES:
  A. AWS Certified Cloud Practitioner (CLF-C01)
  B. HashiCorp: Terraform Associate (002)

OPTIONS
  H. Help
  Q. Quit

Please make a selection: " RESPONSE 

ANSWER=$(echo $RESPONSE | tr '[:lower:]' '[:upper:]')
else
ANSWER=$(echo $CHOICE | tr '[:lower:]' '[:upper:]')
fi

echo
case $ANSWER in
  A|AWS)
    clear ; echo "Chosen Quiz: AWS Certified Cloud Practitioner (CLF-C01)"
    make generating AWS
    echo ; echo
    echo results file created at aws-results.text
    echo
    ;;
  B|TERRAFORM)
    clear ; echo "Chosen Quiz: HashiCorp: Terraform Associate (002)"
    make generating TERRAFORM
    echo ; echo
    echo results file created at terraform-results.text
    echo
    ;;
  H|HELP)
    clear
    make usage
    echo
    ;;
  Q|Quit)
    echo "Goodbye!"
    echo
    ;;
  *)
    make usage
    ;;
esac