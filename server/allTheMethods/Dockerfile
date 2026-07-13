FROM eclipse-temurin:21-jdk-alpine AS dependencies
RUN apk add --no-cache maven
WORKDIR /build
COPY pom.xml .
RUN mvn dependency:go-offline
FROM dependencies AS builder
COPY src ./src
RUN mvn clean package -DskipTests
FROM eclipse-temurin:21-jre-alpine AS runtime
WORKDIR /app
COPY --from=builder /builder/target/*.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]