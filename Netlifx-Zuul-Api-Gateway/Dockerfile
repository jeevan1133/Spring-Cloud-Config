FROM java:8-jdk-alpine

COPY ./target/*.jar /usr/app/zuul.jar

WORKDIR /usr/app

EXPOSE 8765

ENTRYPOINT ["java", "-jar", "-Dspring.profiles.active=dev", "zuul.jar"]
