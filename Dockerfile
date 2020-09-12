FROM openjdk:8-jdk-alpine
VOLUME /tmp
COPY target/*.jar /opt/ams-server/app.jar
ENTRYPOINT ["java","-jar","/opt/ams-server/app.jar"]