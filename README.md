# MortagePlan
Code test for Crosskey trainee application

## Start plan folder
`docker build -t my-image . && docker run my-image` 

## Start mortage-ui folder:
- `mvn install -Pproduction` 
- `docker build -t vaadin-docker .`
- `docker run -ti -p 8090:8080 vaadin-docker`

