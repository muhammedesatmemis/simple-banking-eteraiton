FROM openjdk:17-slim as build

COPY target/simple-banking-app-0.0.1-SNAPSHOT.jar simple-banking-app-0.0.1-SNAPSHOT.jar

ENTRYPOINT ["java", "-jar", "simple-banking-app-0.0.1-SNAPSHOT.jar"]