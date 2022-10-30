.PHONY:
.ONESHELL:
.DEFAULT_GOAL=usage

RED 		:= \033[31m
YELLOW	:= \033[33m
BLUE		:= \033[36m
BOLD 		:= \033[1m
RESET 	:= \033[0m


generating:

	@echo generating quiz ...

run: # Run the app

	@clear
	@./run.sh $$CHOICE

A  AWS: ## Start the AWS Certified Cloud Practioner Quiz

	@$(MAKE) load_db COLLECTION=awsQuestions DB_FILE=awsQuestion.json
	@clear
	@./exam.sh
#	@. aws_cp_mcq/quiz.sh
	@exit 0

B  TERRAFORM: ## Start the HashiCorp: Terraform Associate Quiz

	@$(MAKE) load_db COLLECTION=terraformQuestions DB_FILE=terraformQuestion.json
	@clear
	@./exam.sh

C  AZURE: ## Start the HashiCorp: Azure Fundamentals Quiz

	@$(MAKE) load_db COLLECTION=azureQuestions DB_FILE=azureQuestion.json
	@clear
	@./exam.sh

u usage: # Show usage message

	@echo
	@echo usage: ./build [OPTION] | awk -F: '{printf "${RED}${BOLD}%s${RESET} %s\n", $$1, $$2}'
	@echo
	@echo
	@echo AVAILABLE QUIZZES:
	@$(MAKE) --no-print-directory quizzes
	@echo
	@echo OPTIONS
	@$(MAKE) --no-print-directory  help



cu config-ubuntu: #- Configure Ubuntu server/container
	@apt update -y ; apt upgrade -y

du install-docker-ubuntu: config-ubuntu #- Install Docker on Ubuntu
	@curl -fsSL https://get.docker.com -o get-docker.sh
	@sh get-docker.sh
	@docker --version
	@rm -f get-docker.sh

cr config-rhel: #- Configure RHEL8 server/container
#	dnf group install -y "Development Tools" 1>/dev/null
	@sudo dnf update -y ; dnf upgrade -y
	@sudo dnf clean all
	@sudo dnf repolist
	@sudo dnf install -y git wget go make yum-utils device-mapper-persistent-date lvm2 1>/dev/null

dr install-docker-rhel: config-rhel #- Install Docker on RedHat Linux
	@sudo dnf remove docker \
		docker-client \
		docker-client-latest \
		docker-common \
		docker-latest \
		docker-latest-logrotate \
		docker-logrotate \
		docker-engine

	@sudo yum-config-manager \
		--add-repo \
		https://download.docker.com/linux/centos/docker-ce.repo

	@sudo yum install -y docker-ce docker-ce-cli containerd.io docker-compose-plugin

	@sudo systemctl start docker

quizzes: # List all available quizzes
	@egrep -h '\s##\s' $(MAKEFILE_LIST) | sort | awk 'BEGIN {FS = ":.*?## "}; {printf "${BLUE}%-25s${RESET} %s\n", $$1, $$2}'


load_db: # Load specified quiz questions into running DB; takes a collection and db file located in the mongo-seed direction (e.g. COLLECTION=<> DB_FILE=<>)
	@docker exec -it quiz-mongodb mongoimport --username admin --password admin --uri mongodb://@quiz-mongodb:27017/MCQ?authSource=admin --collection $(COLLECTION) --drop --file mongo-seed/$(DB_FILE) --jsonArray

c config-menu: # List config options
	@egrep -h '\s#-\s' $(MAKEFILE_LIST) | sort | awk 'BEGIN {FS = ":.*?#- "}; {printf "${BLUE}%-25s${RESET} %s\n", $$1, $$2}'

help: # Show the help (OPTIONS) menu
	@egrep -h '\s#\s' $(MAKEFILE_LIST) | sort | awk 'BEGIN {FS = ":.*?# "}; {printf "${BLUE}%-25s${RESET} %s\n", $$1, $$2}'
