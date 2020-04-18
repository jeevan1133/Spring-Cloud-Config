FROM openjdk:8-jdk-alpine

COPY target/currency-exchange-service.jar /opt/currency-exchange-service.jar

EXPOSE 8001

ENTRYPOINT ["java", "-jar", "-Dspring.profiles.active=dev", "/opt/currency-exchange-service.jar"]
