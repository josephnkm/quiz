# Stage 1: Build the application with Gradle 8.8
FROM gradle:8.8-jdk17 AS build
WORKDIR /app

# Copy the project files to the container
COPY . .

# Build the project, skipping tests for faster build
RUN gradle clean build -DskipTests --no-build-cache --warning-mode=all

# Stage 2: Run the application using OpenJDK 17
FROM openjdk:17-jdk-slim
WORKDIR /app

# Copy the built JAR file from the Gradle build stage
COPY --from=build /app/build/libs/MCQ-0.0.1-SNAPSHOT.jar app.jar

# Expose the port the application runs on
EXPOSE 8080

# Command to run the Spring Boot application
CMD ["java", "-jar", "app.jar"]
