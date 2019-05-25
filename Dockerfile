FROM openjdk:8
ADD target/user-jammify-0.0.1-SNAPSHOT.jar user-jammify-0.0.1-SNAPSHOT.jar
EXPOSE 8085
ENTRYPOINT ["java", "-jar", "user-jammify-0.0.1-SNAPSHOT.jar"]