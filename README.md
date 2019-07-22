# Games API

This is an application which stores a games.json file and produces the data from this file.

### Technologies Used

- Java 8
- Spring
- Maven
- GitHub

### Building and running the application

In order to build the application, run the following command within the root of the project.

```mvn clean install```

To run the application, run the following command within the 'target' directory of the project.

```java -jar games-api-0.0.1-SNAPSHOT.jar```

If the games.json file does not exist within the project or is removed, this will prevent the application from running as this is a dependency. It will display a 404 when trying to send a request to one of the endpoints.

### Sending a request to the API

There are multiple ways to send a request to the API to view the required data. Please see below for some of the options which includes:

- Postman
- Curl
- Browser

##### Postman

Firstly, install the Postman application:

https://www.getpostman.com/downloads/

Once this has been installed, and you are all setup, create a new GET request with the following request URLs:

- For retrieving a list of all of the games use the following URL:
    - ```localhost:8080/games/{id}```
- For retrieving a report summary of the games use the following URL:
    - ```localhost:8080/games/report```
 
##### CURL

Use the following commands on a terminal session to retrieve the required data:

- For retrieving a list of all of the games use the following URL:
    - ```curl localhost:8080/games/{id}```
- For retrieving a report summary of the games use the following URL:
    - ```curl localhost:8080/games/report```
    
#### Browser

Start your preferred browser application and enter the following URLs:

- For retrieving a list of all of the games use the following URL:
    - ```localhost:8080/games/{id}```
- For retrieving a report summary of the games use the following URL:
    - ```localhost:8080/games/report```
    
### Improvements

Due to my experience and the time given for creating the application, there are some improvements I would have made including:

- Creating unit tests for the controller and the service, using Mockito
- Adding further exception handlers to catch any errors at the earliest stage
- Creating an interface
    
    



