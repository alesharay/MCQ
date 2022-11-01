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

	@$(MAKE) load_db COLLECTION=Questions DB_FILE=awsQuestions.json
	@clear
	@./exam.sh
	@exit 0

B  TERRAFORM: ## Start the HashiCorp: Terraform Associate Quiz

	@$(MAKE) load_db COLLECTION=Questions DB_FILE=terraformQuestions.json
	@clear
	@./exam.sh

C  AZURE: ## Start the HashiCorp: Azure Fundamentals Quiz

	@$(MAKE) load_db COLLECTION=Questions DB_FILE=azureQuestions.json
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


# Shell Help:
#
#     use                                        Set current database
#     show                                       'show databases'/'show dbs': Print a list of all available databases.
#                                                'show collections'/'show tables': Print a list of all collections for current database.
#                                                'show profile': Prints system.profile information.
#                                                'show users': Print a list of all users for current database.
#                                                'show roles': Print a list of all roles for current database.
#                                                'show log <type>': log for current connection, if type is not set uses 'global'
#                                                'show logs': Print all logs.
#
#     exit                                       Quit the MongoDB shell with exit/exit()/.exit
#     quit                                       Quit the MongoDB shell with quit/quit()
#     Mongo                                      Create a new connection and return the Mongo object. Usage: new Mongo(URI, options [optional])
#     connect                                    Create a new connection and return the Database object. Usage: connect(URI, username [optional], password [optional])
#     it                                         result of the last line evaluated; use to further iterate
#     version                                    Shell version
#     load                                       Loads and runs a JavaScript file into the current shell environment
#     enableTelemetry                            Enables collection of anonymous usage data to improve the mongosh CLI
#     disableTelemetry                           Disables collection of anonymous usage data to improve the mongosh CLI
#     passwordPrompt                             Prompts the user for a password
#     sleep                                      Sleep for the specified number of milliseconds
#     print                                      Prints the contents of an object to the output
#     printjson                                  Alias for print()
#     cls                                        Clears the screen like console.clear()
#     isInteractive                              Returns whether the shell will enter or has entered interactive mode
#
#   For more information on usage: https://docs.mongodb.com/manual/reference/method


load_db: # Load specified quiz questions into running DB; takes a collection and db file located in the mongo-seed direction (e.g. COLLECTION=<> DB_FILE=<>)
	@docker exec -it quiz-mongodb mongoimport --username admin --password admin --uri mongodb://@quiz-mongodb:27017/MCQ?authSource=admin --collection $(COLLECTION) --drop --file mongo-seed/$(DB_FILE) --jsonArray

load_db_local: # Load specified quiz questions into running local DB; takes a collection and db file located in the mongo-seed direction (e.g. COLLECTION=<> DB_FILE=<>)
	@mongoimport --uri mongodb://localhost:27017/MCQ --collection $(COLLECTION) --drop --file mongo-seed/$(DB_FILE) --jsonArray


show_collections: # Show collections for the MCQ database
	@docker exec quiz-mongodb mongosh quiz-mongodb:27017/MCQ --username admin --password admin --eval "show collections"

show_collections_local: # Show collections for the MCQ database
	@mongosh localhost:27017/MCQ --eval "show collections"


drop_collection: # Show collections for the MCQ database
	@docker exec quiz-mongodb mongosh quiz-mongodb:27017/MCQ --username admin --password admin --eval "db.${COLLECTION}.drop()"

drop_collection_local: # Show collections for the MCQ database
	@mongosh localhost:27017/MCQ --eval "db.${COLLECTION}.drop()"


drop_db: # Drop the MCQ database
	@docker exec quiz-mongodb mongosh quiz-mongodb:27017/MCQ --username admin --password admin --eval "db.dropDatabase()"

drop_db_local: # Drop the MCQ database
	@mongosh localhost:27017/MCQ --eval "db.dropDatabase()"


c config-menu: # List config options
	@egrep -h '\s#-\s' $(MAKEFILE_LIST) | sort | awk 'BEGIN {FS = ":.*?#- "}; {printf "${BLUE}%-25s${RESET} %s\n", $$1, $$2}'

help: # Show the help (OPTIONS) menu
	@egrep -h '\s#\s' $(MAKEFILE_LIST) | sort | awk 'BEGIN {FS = ":.*?# "}; {printf "${BLUE}%-25s${RESET} %s\n", $$1, $$2}'
