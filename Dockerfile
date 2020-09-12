FROM openjdk:8-jdk-alpine
VOLUME /tmp
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} /opt/ams-server/app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/opt/ams-server/app.jar"]