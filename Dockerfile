# Verwenden des Eclipse Temurin JRE-Images als Basis
FROM docker.io/library/eclipse-temurin:20-jre

# Setzen Sie das Arbeitsverzeichnis im Container
WORKDIR /usr/store-app

# Standardwerte für Umgebungsvariablen festlegen
ENV POSTGRES_HOST=localhost
ENV POSTGRES_PORT=54322
ENV POSTGRES_DB=dvdrentalstore
ENV POSTGRES_USER=postgres
ENV POSTGRES_PASSWORD=trust

# Kopieren des Bootable JAR-Files in den Docker-Container
COPY ./target/dvdrental-store-bootable.jar /usr/store-app/dvdrental-store-bootable.jar

# Expose Port 8082 für den Container
EXPOSE 8082

# Setzen der WildFly-Konfiguration, um auf alle Netzwerkschnittstellen zu hören und Port 8082 zu verwenden
CMD java -Djboss.http.port=8082 \
     -Djboss.bind.address=0.0.0.0 \
     -Djboss.bind.address.management=0.0.0.0 \
     -Djboss.management.http.port=9992 \
     -Dpostgresql.host=${POSTGRES_HOST} \
     -Dpostgresql.port=${POSTGRES_PORT} \
     -Dpostgresql.database=${POSTGRES_DB} \
     -Dpostgresql.user=${POSTGRES_USER} \
     -Dpostgresql.password=${POSTGRES_PASSWORD} \
     -jar /usr/store-app/dvdrental-store-bootable.jar
