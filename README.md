# NN Test App

This is the homework application modul B

For any question contact: nazim.elmardi@gmail.com

## BUILD

- Build:
mvn clean install
- Run locally:
mvn spring-boot:run
- default port is 8089

At this point frontend not added to the app

---

## DATABASE
- H2 database url: localhost:8080/console
- H2 jdbc URL:jdbc:h2:mem:testdb 
- H2 default user: sa
- H2 default password: <blank>

## HEALTH
### Actuator healthcheck
Actuator basic healthchech information is available at localhost:8080/actuator