FROM openjdk:17-oracle

WORKDIR /app

COPY target/papersystem-0.0.1-SNAPSHOT.jar /app/app.jar

EXPOSE 7001

CMD ["java", "-jar", "app.jar"]