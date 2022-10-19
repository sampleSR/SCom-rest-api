FROM adoptopenjdk/openjdk11:alpine-jre
RUN mkdir -p /app/
WORKDIR /app
COPY "./build/libs/scom-rest-api-0.0.1-SNAPSHOT.jar" "scom-rest-api-0.0.1-SNAPSHOT.jar"
COPY "./build/resources/main/application.properties" "application.properties"
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "scom-rest-api-0.0.1-SNAPSHOT.jar"]
