FROM adoptopenjdk/openjdk11:armv7l-ubuntu-jre-11.0.8_10

LABEL vendor="Catalin Matache"
MAINTAINER Catalin Matache "https://i-catalin.ro"

COPY infrastructure/spring-boot-application/target/spring-boot-application-1.0.0.jar /lara.jar
EXPOSE 8901

ENTRYPOINT ["java", "-jar", "lara.jar"]
