# Spring Prediction Microservices Demo
## Purpose
This project demonstrates communication between microservices using RabbitMQ.

## Technologies Used
1. Java 17
2. Spring Boot version 3.4.2

## Deployment Process
Run Docker Compose to establish Docker containers for RabbitMQ and the PostgreSQL database.
You can deploy the applications in Docker containers or run them directly using Maven on your local machine.

## Important Notes
1. The Weather service allows unlimited data fetching, while the Forex service limits requests to 25 per day. This limitation is not handled in the code, as you can purchase a service plan to access more data.
2. The default data-fetching interval is set to once per hour, so you should not exceed the Forex data request limit.
3. The prediction model uses simple linear regression.

## Architecture
1. The Weather Service retrieves weather data every hour using WebClient.
2. The Forex Service fetches exchange rates from EUR to PLN.
3. The Prediction Service collects data from both services, performs predictions for the next measurement, and stores the results in the database. Each database record contains both the actual measurement and the forecast.
  a. This service also includes a UI built with Angular 19 using standalone components to display values and forecast variations in a table.
5. Microservices communicate via RabbitMQ.
6. If the data reception frequency increases and duplicates appear, both microservices check for duplicates and prevent redundant data from being published.
