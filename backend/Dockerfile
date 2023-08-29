FROM eclipse-temurin:17-jdk

VOLUME /tmp

RUN apt-get update && apt-get install -y maven

RUN apt-get install -y inotify-tools

WORKDIR /app

COPY pom.xml .

COPY src ./src

COPY run.sh .

#RUN mvn package
#
#ENTRYPOINT ["java","-jar","/app/target/backend-0.0.1-SNAPSHOT.jar"]
