FROM openjdk:17
ARG JAR_FILE=out/artifacts/api_jar/api.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
