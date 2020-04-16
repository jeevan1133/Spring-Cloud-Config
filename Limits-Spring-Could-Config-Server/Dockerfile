FROM maven:3.3-jdk-8-onbuild

FROM java:8

COPY --from=0 /usr/src/app/target/config-server.jar /opt/config-server.jar

EXPOSE 8001

ENTRYPOINT ["java", "-jar", "-Dspring.profiles.active=dev", "/opt/config-server.jar"]
