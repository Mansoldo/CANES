# we are extending everything from tomcat:8.0 image ...
FROM tomcat:8.0
MAINTAINER preichmann
# COPY path-to-your-application-war path-to-webapps-in-docker-tomcat
COPY NetBeansProjects/PI3/target/PI3-1.1.0-SNAPSHOT.war /usr/local/tomcat/webapps/
#teste
