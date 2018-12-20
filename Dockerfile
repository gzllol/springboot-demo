FROM openjdk:latest

WORKDIR /app

COPY demo-service/target/demo-service-0.0.1-SNAPSHOT.jar /app

CMD java -jar /app/demo-service-0.0.1-SNAPSHOT.jar


# start container:
# docker run -d --name sbd1 -p 8080:8080 springboot-demo:1.0