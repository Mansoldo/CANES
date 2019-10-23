# we are extending everything from tomcat:8.0 image ...
FROM tomcat:8-jdk8
MAINTAINER preichmann
#envs
ENV CATALINA_HOME /usr/local/tomcat
ENV PATH $CATALINA_HOME/bin:$PATH
ENV MY_CONTEXT=livraria
RUN mkdir -p "$CATALINA_HOME"
WORKDIR $CATALINA_HOME
# COPY path-to-your-application-war path-to-webapps-in-docker-tomcat
#COPY NetBeansProjects/PI3/target/PI3-1.1.0-SNAPSHOT.war /usr/local/tomcat/webapps/
#teste
ADD ./NetBeansProjects/PI3/target/*.war $CATALINA_HOME/webapps/${MY_CONTEXT}.war
ADD ./index.jsp $CATALINA_HOME/webapps/ROOT/index.jsp
