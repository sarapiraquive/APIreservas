FROM openjdk:21-jdk-slim

COPY build/libs/APIreservas-0.0.1-SNAPSHOT.jar /app/APIreservas.jar

WORKDIR /app

EXPOSE 8080

CMD ["java", "-jar", "gestioninventarios.jar"]
