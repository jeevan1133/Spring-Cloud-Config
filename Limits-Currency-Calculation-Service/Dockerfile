FROM java:8-jdk-alpine

WORKDIR /usr/app

COPY ./target/*.jar ./calculation.jar

EXPOSE 8100

ENTRYPOINT ["java", "-jar", "-Dspring.profiles.active=dev", "calculation.jar"]
