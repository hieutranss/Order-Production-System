FROM openjdk:8-slim-buster as build                         

COPY .mvn .mvn                                               
COPY mvnw .                                                  
COPY pom.xml .                                               
COPY src src                                                 
RUN chmod +x ./mvnw
RUN ./mvnw -B package

FROM openjdk:8-jre-slim-buster                              

COPY --from=build target/*.jar ./app.jar         

EXPOSE 9003

ENTRYPOINT ["java", "-jar", "app.jar"] 
