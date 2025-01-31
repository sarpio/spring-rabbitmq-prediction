# Spring Prediction microservices demo
## It is to simple demonstrate communication between microservices over rabbitmq
1. Sprinb boot version 3.4.2
2. Java 17

## Deployment process
1. run docker compose in order to esablish docker containers for rabbitmq, postgres database
2. you can deploy on docker applications or run directly using maven on local pc

## Important
1. Weather service allows unlimited time of data fetching while Forex data allow only 25 request per day. This limitation is not covered by the code since you can buy service and get data as much as you need.
2. Default setting for data fetching every hour so you should exceed not forex data limitation
3. Prediction is only linear reggression, very simple.
