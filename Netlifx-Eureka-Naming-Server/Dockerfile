FROM maven:3.3-jdk-8-onbuild

FROM java:8

COPY --from=0 /usr/src/app/target/eureka-server.jar /opt/eureka-server.jar
#COPY target/eureka-server.jar /opt/eureka-server.jar

EXPOSE 8761

CMD ["java", "-jar", "-Dspring.profiles.active=dev", "/opt/eureka-server.jar"]
