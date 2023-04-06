FROM amazoncorretto:8-alpine-jdk 
MAINTAINER FRANCO
COPY target/Franco-0.0.1-SNAPSHOT.jar FrancoApplication.jar
ENTRYPOINT ["java","-jar","/Franco-Application.jar"]
EXPOSE 8080