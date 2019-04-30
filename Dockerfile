FROM maven:3.6.0-jdk-11

COPY src /usr/src/myapp/src
COPY pom.xml /usr/src/myapp

WORKDIR /usr/src/myapp

EXPOSE 8080

#CMD ["/usr/bin/java", "-jar", "target/to-do-list-backend-0.0.1-SNAPSHOT.jar"]
CMD mvn spring-boot:run -Dspring-boot.run.profiles=dev

