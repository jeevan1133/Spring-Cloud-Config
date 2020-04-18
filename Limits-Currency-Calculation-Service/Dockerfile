FROM openjdk:8-jdk-alpine

COPY target/currency-calculation-service.jar /opt/currency-calculation-service.jar

EXPOSE 8100

ENTRYPOINT ["java", "-jar", "-Dspring.profiles.active=dev", "/opt/currency-calculation-service.jar"]
