FROM java:8-jdk-alpine

COPY ./target/*.jar /usr/app/exchange.jar

WORKDIR /usr/app

EXPOSE 8001

ENTRYPOINT ["java", "-jar", "-Dspring.profiles.active=dev", "exchange.jar"]
