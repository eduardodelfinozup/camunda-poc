## OBJETIVO CRIAR UMA POC PARA TESTAR FLUXOS DO CAMUNDA
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

## Testando um exemplo de fluxo simples  
```
Nesse exemplo o fluxo sera escolhido automaticamente  uma cor já pre definida
``` 
```
curl --location --request POST 'localhost:8080/workflow/cor-predilect'
```
## Testando workflow
```
Para testar: no objeto status coloque uma String "true" ou "false" ex: status = "true"
```
#### EX - 1 
```
curl --location --request POST 'localhost:8080/workflow/suspend-products-workflow' \
--header 'Content-Type: application/json' \
--data-raw '{
    "status": "true"
}'
```

```
Resp:
status 200
{
    "idProcesso": "c588f81b-bdc8-11ed-8fff-aa5cec0ed428",
    "subscriptionStatus": "SUSPENDE",
    "message": "processo concluido"
}
```

#### Ex - 2
```
curl --location --request POST 'localhost:8080/workflow/suspend-products-workflow' \
--header 'Content-Type: application/json' \
--data-raw '{
    "status": "false"
}'
```

```
Resp:
status 200
{
    "idProcesso": "c588f81b-bdc8-11ed-8fff-aa5cec0ed428",
    "subscriptionStatus": "ACTIVE",
    "message": "processo concluido"
}
```

#### Ex - 3
```
curl --location --request POST 'localhost:8080/workflow/suspend-products-workflow' \
--header 'Content-Type: application/json' \
--data-raw '{
    "status": "FLAG_QUALQUER"
}'
```

```
Resp:
status 422
{
    "idProcesso": "[ processo null ]",
    "subscriptionStatus": "FLAG_QUALQUER",
    "message": "O status precisa ser true ou false"
}
```

##### Em Out mappings configure
```
<bpmn:extensionElements>
       <camunda:out sourceExpression="${shouldReverseSubscriptionPayment}" target="shouldReverseSubscriptionPayment" />
</bpmn:extensionElements>
```
