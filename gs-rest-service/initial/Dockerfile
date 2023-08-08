# Official OpenJDK runtime as the base image
FROM openjdk:17-jdk-slim

# Set the working directory in the container
VOLUME /tmp

# Copy the Spring Boot application JAR into the container at /tmp
COPY target/*.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]