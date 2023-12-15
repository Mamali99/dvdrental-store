#!/bin/bash

# Setze Umgebungsvariablen für die Datenbankverbindung
export POSTGRES_HOST=localhost
export POSTGRES_PORT=54322 # muss alle 5432 sein
export POSTGRES_DB=dvdrentalstore
export POSTGRES_USER=postgres
export POSTGRES_PASSWORD=trust

# Setze den Port, auf dem der Service laufen soll
export HTTP_PORT=8082

# Führe den bootfähigen JAR aus mit den Systemeigenschaften
java -Djboss.http.port=${HTTP_PORT} \
     -Djboss.bind.address=0.0.0.0 \
     -Djboss.bind.address.management=0.0.0.0 \
     -Djboss.management.http.port=9992 \
     -Denv.POSTGRES_HOST=${POSTGRES_HOST} \
     -Denv.POSTGRES_PORT=${POSTGRES_PORT} \
     -Denv.POSTGRES_DB=${POSTGRES_DB} \
     -Denv.POSTGRES_USER=${POSTGRES_USER} \
     -Denv.POSTGRES_PASSWORD=${POSTGRES_PASSWORD} \
     -jar target/dvdrental-store-bootable.jar
