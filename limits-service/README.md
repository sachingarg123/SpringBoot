# Limit Service

1) This Spring Boot service is used to read configuration
2) Used Spring Clud Config Server to read configuration.
3) All configuration are stored in Git and read via Spring cloud Config Service
4) This Service is dependent on https://github.com/sachingarg123/SpringBoot/tree/master/spring-cloud-config-server for reading configuration


# URL on which Service Configured

 1) http://localhost:8080/limits: This will pick default configuration from Git
 2) http://localhost:8080/limits/dev : This will pick DEV property from GIT
 3) http://localhost:8080/limits/qa : This will pick QA property from GIT

