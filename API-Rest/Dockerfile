FROM openjdk:17
RUN apt-get update &&/
    apt-get install -y postgresql-17

ARG JAR_FILE=./tgt/api-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} app.jar

ENTRYPOINT ["java","-jar","/app.jar"]



