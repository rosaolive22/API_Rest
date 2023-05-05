FROM openjdk:17
ARG JAR_FILE=target\api-0.0.1-SNAPSHOT.jarout/artifacts/api_jar/api.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
