FROM openjdk:21
LABEL authors="vstavit_text"
COPY build/libs/ITOneRESTAPIFinance-0.0.1-SNAPSHOT.jar .
EXPOSE 8080:8080
EXPOSE 5432:5432
CMD ["java","-jar","ITOneRESTAPIFinance-0.0.1-SNAPSHOT.jar"]