FROM openjdk:17-alpine
VOLUME /tmp
ADD /target/SpringBootDemo-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]