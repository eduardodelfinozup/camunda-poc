## CAMUNDA
```
Link Java: https://github.com/mattferreiras/camunda-course-java
Link Kotlin: https://github.com/mattferreiras/camunda-course-kotlin
```
## RODAR O DOCKER
```
sudo docker-compose -f docker-compose.yml up
```
## logar no camunda
```
localhost:8080/app/cockpit/default/#/login
```
## localhost
```
localhost:8080/rest
```

## doc
```
docs.comunda.org/
```
## Testando workflow
```
curl --location --request POST 'localhost:8080/workflow/suspend-products-workflow' \
--header 'Content-Type: application/json' \
--data-raw '{
    "status": "START_CAMUNDA_POC"
}'
```




