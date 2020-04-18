FROM openjdk:8-jdk-alpine

COPY target/zuul-gateway.jar /opt/zuul-gateway.jar

EXPOSE 8765

ENTRYPOINT ["java", "-jar", "-Dspring.profiles.active=dev", "/opt/zuul-gateway.jar"]
