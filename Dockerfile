FROM openjdk:8-jdk-alpine

WORKDIR /app

RUN apk --no-cache add tzdata && \
    ln -sf /usr/share/zoneinfo/Asia/Shanghai /etc/localtime && \
    echo "Asia/Shanghai" > /etc/timezone

COPY demo-service/target/demo-service-0.0.1-SNAPSHOT.jar /app

CMD java -jar /app/demo-service-0.0.1-SNAPSHOT.jar


# build image:
# docker image build -t springboot-demo:1.0 .

# create a volume
# docker volume create v2

# start container:
# docker run -d --name sbd1  --mount source=v2,target=/app/log -p 8080:8080 springboot-demo:1.0

# view logs
# docker run -dit --name alpine1 --mount source=v2,target=/app alpine ash
# docker attach alpine1
# ctrl+p,ctrl+q (exit alpine1)
