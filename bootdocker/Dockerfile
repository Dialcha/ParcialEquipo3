FROM adoptopenjdk/openjdk8:latest
COPY almacen-0.0.1-SNAPSHOT.jar /usr/src/bootdocker/almacen-0.0.1-SNAPSHOT.jar
WORKDIR /usr/src/bootdocker
EXPOSE 8081
ENTRYPOINT ["java", "-jar", "/usr/src/bootdocker/almacen-0.0.1-SNAPSHOT.jar"]