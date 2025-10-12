FROM openjdk:17-jdk-alpine
FROM maven:3.8.5-eclipse-temurin-17

COPY --from=sb ./src /source/src
COPY --from=sb ./pom.xml /source/pom.xml
COPY ./backend/entrypoint.sh /source/entrypoint.sh
WORKDIR /source
#RUN mvn verify clean --fail-never
RUN mvn clean package -DskipTests
RUN chmod +x /source/entrypoint.sh
ENTRYPOINT ["/source/entrypoint.sh"]
