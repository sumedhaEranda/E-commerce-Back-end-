FROM openjdk:8-jdk-alpine
VOLUME /tmp
ADD target/sk-company-product-service-docker.jar sk-company-product-service-docker.jar
ENTRYPOINT ["java","-jar","/sk-company-product-service-docker.jar"]