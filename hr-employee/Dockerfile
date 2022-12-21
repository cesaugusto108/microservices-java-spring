FROM openjdk:11
VOLUME /tmp
ADD ./target/hr-employee-0.0.1-SNAPSHOT.jar hr-employee.jar
ENTRYPOINT ["java", "-jar", "/hr-employee.jar"]