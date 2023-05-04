FROM openjdk:17

RUN apt-get update && \
    apt-get install -y postgresql-17

ARG JAR_FILE=target/test-classes/*.jar
COPY ${JAR_FILE} app.jar

COPY startup.sh /usr/local/bin/
RUN chmod +x /usr/local/bin/startup.sh

ENTRYPOINT ["/usr/local/bin/startup.sh"]
