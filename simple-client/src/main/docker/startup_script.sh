#!/bin/bash

export CLIENT_TRUSTSTORE=/tmp/client-truststore.pkcs12

# Add the CA to CA certs
keytool -importcert -trustcacerts -noprompt -file /tmp/ca/zennote.crt.pem -alias zennote-ca -keystore $CLIENT_TRUSTSTORE -storepass $TRUST_STORE_PASSWORD

java -Djdk.tls.client.protocols=TLSv1.3 -Djavax.net.ssl.trustStore=$CLIENT_TRUSTSTORE -Djavax.net.ssl.trustStorePassword=$TRUST_STORE_PASSWORD -jar /deployments/quarkus-run.jar
