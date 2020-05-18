FROM openjdk
ARG JAR_FILE=target/mapTileServer-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} AutoDriveMapTileServer.jar
COPY util/application.properties application.properties
ENTRYPOINT ["java","-jar","/AutoDriveMapTileServer.jar"]
