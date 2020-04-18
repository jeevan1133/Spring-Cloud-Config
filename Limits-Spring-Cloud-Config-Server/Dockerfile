FROM openjdk:8-jdk-alpine

COPY target/config-server.jar /opt/config-server.jar

EXPOSE 8888

ENTRYPOINT ["java", "-jar", "-Dspring.profiles.active=dev", "/opt/config-server.jar"]
