# Step 1: Build stage using Maven and Java 21
FROM maven:3.9.6-eclipse-temurin-21 AS build
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests

# Step 2: Runtime stage using a lightweight Java 21 JRE
FROM eclipse-temurin:21-jre-jammy
WORKDIR /app
# Finds your .jar and renames it to app.jar
COPY --from=build /app/target/*.jar app.jar
# Standard Spring Boot port
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
