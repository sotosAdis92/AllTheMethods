FROM eclipse-temurin:21-jdk-alpine AS dependencies
ADD target/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]