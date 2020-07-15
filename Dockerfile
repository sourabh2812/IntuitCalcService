FROM java:8
ADD target/IntuitCalcService-0.0.1-SNAPSHOT.jar IntuitCalcService-0.0.1-SNAPSHOT.jar
ENTRYPOINT [ "java", "-jar", "IntuitCalcService-0.0.1-SNAPSHOT.jar" ]