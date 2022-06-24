FROM openjdk

WORKDIR /app

COPY target/aplazo-0.0.1-SNAPSHOT.jar /app/aplazo-app.jar

ENTRYPOINT ["java", "-jar", "aplazo-app.jar"]