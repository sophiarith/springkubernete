FROM openjdk:11
ADD ./target/*.jar /ROOT.jar
ENTRYPOINT ["java", "-jar", "ROOT.jar"]
