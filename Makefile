.PHONY:
.ONESHELL:
.DEFAULT_GOAL	:=	usage

RED 		:= \033[31m
GREEN		:= \033[32m
YELLOW	:= \033[33m
BLUE		:= \033[36m
BOLD 		:= \033[1m
RESET 	:= \033[0m

A	AWS:	## Start the AWS Certified Cloud Practioner Quiz

	@$(MAKE) --no-print-directory load_db COLLECTION=Questions DB_FILE=awsQuestions.json
	@clear
	@./exam.sh q
	@mv results.txt aws-results.txt
	@$(MAKE) --no-print-directory drop_db 1>/dev/null 2>&1
	@echo
	@echo
	@echo "Results file created at ${GREEN}${BOLD}aws-results.txt${RESET}"
	@echo
	@$(MAKE) --no-print-directory drop_db 1>/dev/null 2>&1
	@exit 0

B	TERRAFORM:	## Start the HashiCorp: Terraform Associate Quiz

	@$(MAKE) --no-print-directory load_db COLLECTION=Questions DB_FILE=terraformQuestions.json
	@clear
	@./exam.sh q
	@mv results.txt terraform-results.txt
	@echo
	@echo
	@echo "Results file created at ${GREEN}${BOLD}terraform-results.txt${RESET}"
	@echo
	@$(MAKE) --no-print-directory drop_db 1>/dev/null 2>&1
	@exit 0

C	AZURE:	## Start the HashiCorp: Azure Fundamentals Quiz

	@$(MAKE) --no-print-directory load_db COLLECTION=Questions DB_FILE=azureQuestions.json
	@clear
	@./exam.sh q
	@mv results.txt azure-results.txt
	@echo
	@echo
	@echo "Results file created at ${GREEN}${BOLD}azure-results.txt${RESET}"
	@echo
	@$(MAKE) --no-print-directory drop_db 1>/dev/null 2>&1
	@exit 0

#----

cu	config-ubuntu:	#- Configure Ubuntu server/container
	@apt update -y ; apt upgrade -y

du	install-docker-ubuntu: config-ubuntu #- Install Docker on Ubuntu
	@curl -fsSL https://get.docker.com -o get-docker.sh
	@sh get-docker.sh
	@docker --version
	@rm -f get-docker.sh

cr	config-rhel:	#- Configure RHEL8 server/container
#	dnf group install -y "Development Tools" 1>/dev/null
	@sudo dnf update -y ; dnf upgrade -y
	@sudo dnf clean all
	@sudo dnf repolist
	@sudo dnf install -y git wget go make yum-utils device-mapper-persistent-date lvm2 1>/dev/null

dr	install-docker-rhel: config-rhel 	#- Install Docker on RedHat Linux
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

#----

ld	load_db:	#M Load specified quiz questions into running DB; takes a collection and db file located in the mongo-seed direction (e.g. COLLECTION=... DB_FILE=...)
	@docker exec -it quiz-mongodb mongoimport --username admin --password admin --uri mongodb://@quiz-mongodb:27017/MCQ?authSource=admin --collection $(COLLECTION) --drop --file mongo-seed/$(DB_FILE) --jsonArray

ldl	load_db_local 	:	#M Load specified quiz questions into running local DB; takes a collection and db file located in the mongo-seed direction (e.g. COLLECTION=... DB_FILE=...)
	@mongoimport --uri mongodb://localhost:27017/MCQ --collection $(COLLECTION) --drop --file mongo-seed/$(DB_FILE) --jsonArray

#----

sc	show_collections:		#M Show collections for the MCQ database
	@docker exec quiz-mongodb mongosh quiz-mongodb:27017/MCQ --authenticationDatabase admin --username admin --password admin --eval "show collections"

scl	show_collections_local:	#M Show collections for the local MCQ database
	@mongosh localhost:27017/MCQ --eval "show collections"

#----

mg	mongosh :	#M Run mongosh commands; takes a command parameter (e.g. COMMAND=... )
	@docker exec quiz-mongodb mongosh quiz-mongodb:27017/MCQ --authenticationDatabase admin --username admin --password admin --eval "${COMMAND}"

mgl	mongosh_local 	:	#M Run local mongosh commands; takes a command parameter (e.g. COMMAND=... )
	@mongosh localhost:27017/MCQ --eval "${COMMAND}"

#----

dc	drop_collection:	#M Show collections for the MCQ database
	@docker exec quiz-mongodb mongosh quiz-mongodb:27017/MCQ --authenticationDatabase admin --username admin --password admin --eval "db.${COLLECTION}.drop()"

dcl	drop_collection_local :	#M Show collections for the local MCQ database
	@mongosh localhost:27017/MCQ --eval "db.${COLLECTION}.drop()"

#----

dd	drop_db :	#M Drop the MCQ database
	@docker exec quiz-mongodb mongosh quiz-mongodb:27017/MCQ --authenticationDatabase admin --username admin --password admin --eval "db.dropDatabase()"

ddl	drop_db_local 	:	#M Drop the local MCQ database
	@mongosh localhost:27017/MCQ --eval "db.dropDatabase()"

#----

generating:

	@echo generating quiz ...

r	run:		# Run the app

	@clear
	@./run.sh $$CHOICE

u	usage:		# Show usage message
	@$(MAKE) --no-print-directory mg COMMAND="db.disableFreeMonitoring()" 1>/dev/null
	@echo
	@echo usage: ./build [OPTION] | awk -F: '{printf "${RED}${BOLD}%s${RESET} %s\n", $$1, $$2}'
	@echo
	@echo
	@echo QUIZZES:
	@$(MAKE) --no-print-directory quizzes
	@echo
	@echo MONGO OPTIONS:
	@$(MAKE) --no-print-directory mongo-options
	@echo
	@echo CONFIGURATIONS:
	@$(MAKE) --no-print-directory config-menu
	@echo
	@echo ADDITIONAL OPTIONS
	@$(MAKE) --no-print-directory  help

q	quizzes:			# List all available quizzes
	@egrep -h '\s##\s' $(MAKEFILE_LIST) | sort | awk 'BEGIN {FS = ":.*?## "}; {printf "${BLUE}%-25s${RESET} %s\n", $$1, $$2}'

cm	config-menu   	:		# List config options
	@egrep -h '\s#-\s' $(MAKEFILE_LIST) | sort | awk 'BEGIN {FS = ":.*?#- "}; {printf "${BLUE}%-25s${RESET} %s\n", $$1, $$2}'

mo 	mongo-options	:		# List config options
	@egrep -h '\s#M\s' $(MAKEFILE_LIST) | sort | awk 'BEGIN {FS = ":.*?#M "}; {printf "${BLUE}%-25s${RESET} %s\n", $$1, $$2}'

h	help:			# Show the help (OPTIONS) menu
	@egrep -h '\s#\s' $(MAKEFILE_LIST) | sort | awk 'BEGIN {FS = ":.*?# "}; {printf "${BLUE}%-25s${RESET} %s\n", $$1, $$2}'
