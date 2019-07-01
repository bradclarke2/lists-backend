FROM maven:3.6.1-jdk-11-slim AS builder

WORKDIR /app
COPY pom.xml .
RUN mvn -e -B dependency:go-offline

COPY src ./src
RUN mvn -e -B package

FROM openjdk:11-jre-slim
COPY --from=builder /app/target/app.jar /
EXPOSE 8080
CMD ["java", "-jar", "/app.jar"]