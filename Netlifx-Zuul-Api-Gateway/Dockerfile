FROM maven:3.3-jdk-8-onbuild

FROM java:8
COPY --from=0 /usr/src/app/target/zuul-gateway.jar /opt/zuul-gateway.jar

EXPOSE 8765

ENTRYPOINT ["java", "-jar", "-Dspring.profiles.active=dev", "/opt/zuul-gateway.jar"]
