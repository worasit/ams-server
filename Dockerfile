FROM openjdk:8-jdk-alpine
VOLUME /tmp
ARG JAR_FILE
COPY ${JAR_FILE} /opt/ams-server/app.jar
ENTRYPOINT ["java","-jar","/opt/ams-server/app.jar"]