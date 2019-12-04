FROM openjdk:11-jre
LABEL EMAIL="rongfengliang"
WORKDIR /app
COPY worker/target/myinstance-app.jar  /app
ENTRYPOINT [ "java","-jar","/app/myinstance-app.jar" ]