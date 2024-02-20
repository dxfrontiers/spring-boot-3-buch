FROM amazoncorretto:21
COPY build/libs/docker-app.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
EXPOSE 8080