FROM openjdk:11

EXPOSE 8080

COPY build/libs/*.jar ./youtubeshare.jar

ENTRYPOINT ["java", "-jar", "./youtubeshare.jar"]