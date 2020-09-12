FROM openjdk:8-jdk-alpine
WORKDIR /app
COPY target/*.jar /app/ams-server.jar
EXPOSE 80
ENTRYPOINT ["java","-jar","/app/ams-server.jar"]