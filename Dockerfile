# Use an official Java runtime as a parent image
FROM amazoncorretto:21.0.4-alpine3.18

# Set the working directory in the container
WORKDIR /app

# Copy the JAR file into the container
COPY target/containerize-java-spring-0.0.1-SNAPSHOT.jar app.jar

# Copy the application.properties into the container
COPY target/classes/application.properties application.properties

# Copy the logback.xml file into the container
COPY target/classes/logback.xml logback.xml

# Expose the port that the application will run on
EXPOSE 8080

# Run the JAR file
ENTRYPOINT ["java", "-jar", "app.jar"]
