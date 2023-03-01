#!/bin/bash

# Add the CA to CA certs
keytool -import -cacerts -trustcacerts -noprompt -storepass changeit -file /tmp/ca/zennote.crt.pem -keypass $TRUST_STORE_PASSWORD

java -jar /deployments/quarkus-run.jar
