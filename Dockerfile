FROM openjdk:19
ADD target/alluneed-0.0.1-SNAPSHOT.jar alluneed-0.0.1-SNAPSHOT.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "alluneed-0.0.1-SNAPSHOT.jar"]