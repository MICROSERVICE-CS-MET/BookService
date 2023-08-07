# 1. Build stage
FROM gradle:8.1.1-jdk17 AS build

WORKDIR /book_service

# Copy the rest of the source code
COPY . .

# Build the application
RUN gradle build --no-daemon

# 2. Runtime stage
FROM openjdk:17-jdk-slim

WORKDIR /book_service

COPY --from=build /book_service/build/libs/book-service-0.0.1-SNAPSHOT.jar .

ENTRYPOINT ["java", "-jar", "book-service-0.0.1-SNAPSHOT.jar"]
