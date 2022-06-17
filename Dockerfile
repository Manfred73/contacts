FROM openjdk:11
ADD target/contacts.jar contacts.jar
ENTRYPOINT ["java", "-jar","contacts.jar"]
EXPOSE 8081
