# crea el jar de la aplicacion en una imagen temporal
FROM openjdk:8u181-jdk-alpine AS build

RUN mkdir -p /app/src
WORKDIR /app/src
COPY . /app/src

RUN ./gradlew bootjar

# crea una imagen ligera solo con el jar de spring boot
FROM openjdk:8u181-jdk-alpine

COPY --from=build /app/src/build/libs/robomatic-email-api-1.0.0-SNAPSHOT.jar /app/

EXPOSE 8080

ENTRYPOINT ["java", "-Duser.timezone=UTC", "-jar","/app/robomatic-email-api-1.0.0-SNAPSHOT.jar"]
