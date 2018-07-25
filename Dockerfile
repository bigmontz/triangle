FROM java:8-jdk

ARG USER_HOME_DIR="/root"

RUN mkdir -p /usr/src/app 
WORKDIR /usr/src/app 
RUN mkdir -p /usr/src/app/src

COPY . .
RUN chmod +x mvnw
RUN ./mvnw clean install
RUN cp target/triangle-*.jar target/triangle.jar

# Entrypoint
ENTRYPOINT exec java -jar target/triangle.jar
