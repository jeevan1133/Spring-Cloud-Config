FROM java:8-jdk-alpine

COPY ./target/*.jar /usr/app/eureka.jar

WORKDIR /usr/app

EXPOSE 8761

ENTRYPOINT ["java", "-jar", "-Dspring.profiles.active=dev", "eureka.jar"]
