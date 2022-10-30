FROM ubuntu:20.04
RUN apt update -y ; apt upgrade -y
RUN DEBIAN_FRONTEND=noninteractive apt install -y vim wget vim gradle curl libmongodb-java software-properties-common gnupg apt-transport-https ca-certificates

# install java 
RUN mkdir -p /usr/java/openjdk
RUN cd /usr/java/openjdk
RUN wget https://download.java.net/java/GA/jdk18.0.2.1/db379da656dc47308e138f21b33976fa/1/GPL/openjdk-18.0.2.1_linux-x64_bin.tar.gz
# RUN cp ../openjdk-18.0.2.1_linux-x64_bin.tar.gz openjdk-18.0.2.1_linux-x64_bin.tar.gz
RUN tar -xzvf openjdk-18.0.2.1_linux-x64_bin.tar.gz
RUN cd jdk-18.0.2.1/
RUN JAVA_HOME=$(pwd) ; echo "JAVA_HOME=$(pwd)" >> /etc/profile
RUN export JAVA_HOME; echo "export JAVA_HOME" >> /etc/profile
RUN PATH=$PATH:$HOME/bin:${JAVA_HOME}/bin ; echo "PATH=$PATH:$HOME/bin:${JAVA_HOME}/bin" >> /etc/profile
RUN export PATH ; echo "export PATH" >> /etc/profile
RUN source ~/.bashrc
RUN update-alternatives --install "/usr/bin/java" "java" "$JAVA_HOME/bin/java" 1
RUN ln -s "$JAVA_HOME/bin/javac" "/usr/bin/javac"
RUN update-alternatives --install "/usr/bin/javac" "javac" "$JAVA_HOME/bin/javac" 1
RUN echo 1 | update-alternatives --config java
RUN cd ~

ADD . /quiz
WORKDIR /quiz
RUN chmod +x quiz.sh
ENTRYPOINT ["./quiz.sh"]