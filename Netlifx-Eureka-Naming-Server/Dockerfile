FROM openjdk:8-jdk-alpine

COPY target/eureka-server.jar /opt/eureka-server.jar

EXPOSE 8761

CMD ["java", "-jar", "-Dspring.profiles.active=dev", "/opt/eureka-server.jar"]
