FROM maven:3.8.4-openjdk-17 AS build

WORKDIR /app
COPY ./pom.xml /app
RUN mvn verify clean --fail-never
COPY src /app/src

RUN mvn package

FROM openjdk:17.0.2-slim

WORKDIR /app
COPY --from=build /app/target/data.jar /app
COPY ./real-estate-data.csv /app
CMD java -jar data.jar