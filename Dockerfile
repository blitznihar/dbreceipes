FROM openjdk:8-jdk-alpine
RUN addgroup -S spring && adduser -S spring -G spring
USER spring:spring
ARG JAR_FILE=target/*.jar
ARG PROPERTIES_FILE=target/classes/*.properties
ARG SQL_FILE=target/classes/*.sql
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
#java -jar ./target/dbreceipes-1.3.1-SNAPSHOT.jar --spring.config.location=./target/classes/application-prod.properties,./target/classes/database.properties