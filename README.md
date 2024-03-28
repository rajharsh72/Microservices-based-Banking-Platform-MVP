# Microservices-based-Banking-Platform-MVP


•	I’ve created two microservices, one Account Service that will handle all the operations to be performed for an account of a customer and second is Customer Service to handle all the operations related to customer management.

•	I have established an inter-service communication using Feign Client so that when needed each service can utilize the services of the other microservice.

•	Apart from this I’ve also created Service Registery which is a Eureka Server, where instances of each of the microservices are registered.

•	Also, I’ve implemented an API gateway which will act as an entry point for all the API calls made by the client. This is also a Eureka Client Service.

•	To manage all the common configurations of our application, a centralized Config Server is implemented where all the common configurations of eureka server for all the services is defined. This configuration file is stored locally on the disk.

•	To run the application, make sure to start the server and services in the mentioned order – ServiceRegistery, ConfigServer, AccountService, CustomerService, ApiGateway.

•	Below is the flowchart of our application.



## Flowchart

![App Screenshot](https://github.com/rajharsh72/Microservices-based-Banking-Platform-MVP/blob/main/Microservices%20Flowchart.png)


## Authors

- [@rajharsh72](https://www.github.com/rajharsh72)

