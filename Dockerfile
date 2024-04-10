FROM openjdk:17.0.1-jdk-slim
COPY build/libs/demo-0.0.1-SNAPSHOT.jar /app/demo.jar
EXPOSE 8000
CMD ["java", "-jar", "/app/demo.jar"]