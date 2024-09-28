FROM gradle:7.6-jdk17 AS build
WORKDIR /app
COPY . .
RUN gradle clean build -DskipTests

FROM openjdk:17-ea-4-jdk-slim
WORKDIR /app
COPY --from=build /app/build/libs/MCQ-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8080
CMD ["java", "-jar", "app.jar"]