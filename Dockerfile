FROM openjdk:8-jdk-alpine
WORKDIR /app
COPY target/*.jar /app/ams-server.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/app/ams-server.jar"]