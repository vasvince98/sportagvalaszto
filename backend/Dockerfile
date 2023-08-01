FROM eclipse-temurin:17-jdk

VOLUME /tmp

RUN apt-get update && apt-get install -y maven

WORKDIR /app

COPY pom.xml .

COPY src ./src

RUN mvn package

ENTRYPOINT ["java","-jar","/app/target/backend-0.0.1-SNAPSHOT.jar"]
