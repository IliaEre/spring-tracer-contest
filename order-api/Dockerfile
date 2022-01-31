FROM openjdk:8-jdk-alpine
MAINTAINER ere.samples
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java", "-jar", "-Dspring.profiles.active=docker" ,"/app.jar"]