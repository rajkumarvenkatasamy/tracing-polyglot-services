# tracing-polyglot-services
Demo Project : Distributed tracing with Zipkin in a Polyglot Microservices project


## Pre-requisites:

* JDK 1.8
* Python 3
* Docker
* The build and execution scripts are directly compatible with Windows OS. However it should be easy enough for you to convert it to shell or other scripting formats.


## Development Setup in Local machine

* Git clone the project repository

* Switch to python flask app
  
  cd ${project base directory}\python-flask-service

* Create the virtual environment by executing the command
   
   python -m venv .\venv

* Activate the virtual environment by executing the command
   
   venv\Scripts\activate 

* Install the dependent packages for python app
  
  pip install -r requirements.txt


## Build

${project-base-dir-path}\build-and-execute\build\build.bat


## Execute

### Start the services

${project-base-dir-path}\build-and-execute\execute\start.bat

### Stop the services

${project-base-dir-path}\build-and-execute\execute\stop.bat


## Spring Cloud Eureka Server URL

http://localhost:8761/


## Zipkin UI

http://localhost:9411/


## Endpoints

1. GET http://localhost:9191/java-service/api/v1/internal/greetings

   * Internal endpoint which makes a call to Java microservice app and returns the response to the user. 
   * Request traversal path : User -> API Gateway -> Java App -> Response to the User

2. GET http://localhost:9191/java-service/api/v1/external/greetings/

   * External endpoint in the sense that first the call is made to Java microservice app and then to python flask service for getting the response back to the user
   * Request traversal path : User -> API Gateway -> Java App -> Python App -> Response back to Java App -> Response to the user

3. GET http://localhost:9191/java-service/api/v1/external/belated-greetings/

   * External endpoint in the sense that first the call is made to Java microservice app and then to python flask service for getting the response back to the user. However this time, the response is delayed because of the induced latency.
   * Request traversal path : User -> API Gateway -> Java App -> Python App -> Response back to Java App after an induced latency -> Response to the user