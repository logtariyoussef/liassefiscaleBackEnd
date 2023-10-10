FROM openjdk:17
ADD . . 
COPY ProjetLiasseFiscale-0.0.1.jar app.jar
#SRUN ls
ENTRYPOINT ["java","-jar","./app.jar"]