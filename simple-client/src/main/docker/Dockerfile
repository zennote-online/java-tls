FROM openjdk:21-slim-buster

COPY simple-client/target/simple-client-1.0.0-SNAPSHOT-runner.jar /deployments/quarkus-run.jar
COPY simple-client/src/main/docker/startup_script.sh startup_script.sh
RUN chmod 777 startup_script.sh

ARG TRUST_STORE_PASSWORD
ENV TRUST_STORE_PASSWORD=$TRUST_STORE_PASSWORD

ENTRYPOINT ./startup_script.sh
