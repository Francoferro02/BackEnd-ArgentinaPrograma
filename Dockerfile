FROM amazoncorretto:11-alpine-jdk 
MAINTAINER FRANCO
COPY target/Franco-0.0.1-SNAPSHOT.jar Franco-Application.jar
ENTRYPOINT ["java","-jar","/Franco-Application.jar"]
EXPOSE 8080