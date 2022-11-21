# MCQ

Multiple Choice Quizzes (MCQ) is a collection of tech certification practice exams of the multiple choice type.

The collection currently consists of the following exams:
* AWS
* Azure
* Terraform

More exams to come
<br><br>
## REQUIREMENTS
- [tar][7]
- [git][6]
- [gradle][9]
- [Docker][1]
- [Docker Compose][2]
- [jq][3]
- [yq][4]
- [.env][8]
<br><br>
## Install
*So far, this project on builds on Unix systems. (Windows coming soon)*

<u>mac</u>
```mac
brew install git wget tar jq yq gradle docker docker-compose docker-desktop

# start docker desktop

git clone https://github.com/alesharay/MCQ.git
cd MCQ/
```

<u>linux (ubuntu 22.04)</u>

*Use the **config-install.sh** script to configure linux*
<br><br>
## Build
### <u>*maclinux*</u>
Use the package manager [dnf](https://fedoraproject.org/wiki/DNF) to install foobar.

```bash
# use sample.env to create .env file

# if linux, run sudo with the following command

./build.sh
```
<br><br>
## Usage

```bash
usage  ./build [OPTION]


QUIZZES:
A	AWS                     Start the AWS Certified Cloud Practioner Quiz
B	TERRAFORM               Start the HashiCorp: Terraform Associate Quiz
C	AZURE                   Start the HashiCorp: Azure Fundamentals Quiz

MONGO OPTIONS:
dc	drop_collection        Show collections for the MCQ database
dcl	drop_collection_local  Show collections for the local MCQ database
dd	drop_db                Drop the MCQ database
ddl	drop_db_local 	       Drop the local MCQ database
ld	load_db                Load specified quiz questions into running DB; takes a collection and db file located in the mongo-seed direction (e.g. COLLECTION=... DB_FILE=...)
ldl	load_db_local 	       Load specified quiz questions into running local DB; takes a collection and db file located in the mongo-seed direction (e.g. COLLECTION=... DB_FILE=...)
mg	mongosh                Run mongosh commands; takes a command parameter (e.g. COMMAND=... )
mgl	mongosh_local 	       Run local mongosh commands; takes a command parameter (e.g. COMMAND=... )
sc	show_collections       Show collections for the MCQ database
scl	show_collections_local Show collections for the local MCQ database

CONFIGURATIONS:
cr	config-rhel            Configure RHEL8 server/container
cu	config-ubuntu          Configure Ubuntu server/container
dr	install-docker-rhel    Install Docker on RedHat Linux
du	install-docker-ubuntu  Install Docker on Ubuntu

ADDITIONAL OPTIONS
cm	config-menu   	        List config options
h	help                    Show the help (OPTIONS) menu
mo 	mongo-options	        List config options
q	quizzes                 List all available quizzes
r	run                     Run the app
u	usage                   Show usage message
```
<br><br>
## Contributing
Pull requests are welcome. For major changes, please open an issue first to discuss what you would like to change.

Please make sure to update tests as appropriate.
<br><br>
## License
[MIT](https://choosealicense.com/licenses/mit/)














<!-- Links -->
[1]: https://docs.docker.com/engine/install/
[2]: https://docs.docker.com/compose/install/
[3]: https://stedolan.github.io/jq/
[4]: https://github.com/mikefarah/yq
[5]: https://github.com/kward/shunit2
[6]: https://git-scm.com
[7]: https://www.gnu.org/software/tar/
[8]: sample.env
[9]: https://gradle.org/