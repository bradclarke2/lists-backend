FROM maven:3.6.0-jdk-11

COPY src /usr/src/app/src
COPY pom.xml /usr/src/app

WORKDIR /usr/src/app
RUN mvn clean install

EXPOSE 8080

#CMD ["/usr/bin/java", "-jar", "target/to-do-list-backend-0.0.1-SNAPSHOT.jar"]
CMD mvn clean spring-boot:run -Dspring-boot.run.profiles=dev

