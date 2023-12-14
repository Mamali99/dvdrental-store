# Verwenden des Eclipse Temurin JRE-Images als Basis
FROM docker.io/library/eclipse-temurin:20-jre

# Setzen Sie das Arbeitsverzeichnis im Container
WORKDIR /usr/store-app

# Setzen von Umgebungsvariablen für die Datenbankverbindung
ENV POSTGRESQL_USER=postgres
ENV POSTGRESQL_PASSWORD=trust

# Kopieren des Bootable JAR-Files in den Docker-Container
COPY ./target/dvdrental-store-bootable.jar /usr/store-app/dvdrental-store-bootable.jar

# Expose Port 8082 für den Container
EXPOSE 8082

# Setzen der WildFly-Konfiguration, um auf alle Netzwerkschnittstellen zu hören und Port 8082 zu verwenden
CMD java -Djboss.bind.address=0.0.0.0 -Djboss.bind.address.management=0.0.0.0 -Djboss.http.port=8082 -Djboss.management.http.port=9992 -jar /usr/store-app/dvdrental-store-bootable.jar -Dpostgresql.user=${POSTGRESQL_USER} -Dpostgresql.password=${POSTGRESQL_PASSWORD}
