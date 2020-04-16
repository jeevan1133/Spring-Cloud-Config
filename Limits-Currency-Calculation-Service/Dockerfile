
FROM maven:3.3-jdk-8-onbuild

VOLUME maven-repo:/root/.m2

FROM java:8

COPY --from=0 /usr/src/app/target/currency-calculation-service.jar /opt/currency-calculation-service.jar
#FROM java:8-jdk-alpine

#COPY target/currency-calculation-service.jar /opt/currency-calculation-service.jar

EXPOSE 8100

ENTRYPOINT ["java", "-jar", "-Dspring.profiles.active=dev", "/opt/currency-calculation-service.jar"]
