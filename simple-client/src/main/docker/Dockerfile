FROM registry.access.redhat.com/ubi8/openjdk-17:1.14

COPY simple-client/target/simple-client-1.0.0-SNAPSHOT-runner.jar /deployments/quarkus-run.jar

USER 185

ENV JAVA_OPTS="-Djava.util.logging.manager=org.jboss.logmanager.LogManager"
ENV JAVA_APP_JAR="/deployments/quarkus-run.jar"
