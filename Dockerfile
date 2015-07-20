FROM centos:7
MAINTAINER Francois Breton <francois.breton@dti.ulaval.ca>
EXPOSE 8080

# make sure the system is up to date
RUN yum update -y

# install openJava
RUN yum install java wget tar top -y

# move to /opt and download the tomcat package
RUN cd /opt && wget "http://mirror.vorboss.net/apache/tomcat/tomcat-7/v7.0.63/bin/apache-tomcat-7.0.63.tar.gz" 
RUN cd /opt && tar -zxvf apache-tomcat-7.0.63.tar.gz 
RUN cd /opt && ln -sf apache-tomcat-7.0.63 tomcat

# set environment variables
RUN echo '#!/bin/bash' > /etc/profile.d/script.sh 
RUN echo 'CATALINA_HOME=/opt/tomcat' >> /etc/profile.d/script.sh
RUN echo 'PATH=$CATALINA_HOME/bin:$PATH' >> /etc/profile.d/script.sh
RUN echo 'export PATH CATALINA_HOME' >> /etc/profile.d/script.sh
RUN echo 'export CLASSPATH=.' >> /etc/profile.d/script.sh
RUN chmod +x /etc/profile.d/script.sh

# make env variables permenant
RUN source /etc/profile.d/script.sh

# make tomcat scripts executable
RUN chmod +x /opt/tomcat/bin/startup.sh
RUN chmod +x /opt/tomcat/bin/shutdown.sh
RUN chmod +x /opt/tomcat/bin/catalina.sh
RUN chmod -R ugo+w /opt/tomcat

# Cleanup webapps directory
RUN cd /opt/apache-tomcat-7.0.63/webapps && rm -rf *

ADD target/cinema-1.0.0 /opt/apache-tomcat-7.0.63/webapps/cinema

#Fire up tomcat
CMD /opt/apache-tomcat-7.0.63/bin/startup.sh && tail -F /opt/apache-tomcat-7.0.63/logs/catalina.out


