FROM openjdk:8-jdk-alpine

COPY target/limits-service.jar /opt/limits-service.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "-Dspring.profiles.active=dev", "/opt/limits-service.jar"]
