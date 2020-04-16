FROM maven:3.3-jdk-8-onbuild

VOLUME  maven-repo:/root/.m2

FROM java:8
COPY --from=0 /usr/src/app/target/limits-service.jar /opt/limits-service.jar

#COPY target/limits-service.jar /opt/limits-service.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "-Dspring.profiles.active=dev", "/opt/limits-service.jar"]
