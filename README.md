## `VerifyCityPath`

VerifyCityPath application determines if two cities are connected. Two cities are considered
connected if there’s a series of roads that can be traveled from one city to another.

A rest api is exposed which determines the possible path between two cities. If path exists then return "Yes" or "No" in response


#### `Technologies`
Spring Boot 2.0<br>
Java 1.8 <br>
Maven <br>
Mockito for Unit testing. 

#### `Implementation Steps`

After analyzing  the requirement, it is considered to use Graph data structure to compute the path between two cities where they are not directly connected



1. [Cities.txt](https://github.com/sandip01jan/VerifyCityPath/blob/master/src/main/resources/cities.txt) -
    Given a text file consists of pair of cities in each line with comma(,) separated.
2. [ReadCitiesFromFile.java](https://github.com/sandip01jan/VerifyCityPath/blob/master/src/main/java/com/verify/city/path/config/ReadCitiesPathFromFile.java) - 
    Config file ReadCitiesFromFile.java reads the textfile and places all the cities in Graph data structure
3. [Graph.java](https://github.com/sandip01jan/VerifyCityPath/blob/master/src/main/java/com/verify/city/path/util/Graph.java) -
    is used to construct a graph for the given cities 
4. [Search.java](https://github.com/sandip01jan/VerifyCityPath/blob/master/src/main/java/com/verify/city/path/util/Search.java) -
    is used to traverse the graph in DFS(Depth First Search) algorithm.
5. [CitiesPathController.java](https://github.com/sandip01jan/VerifyCityPath/blob/master/src/main/java/com/verify/city/path/controller/VerifyCitiesPathController.java) -
    An API is exposed through a rest controller web method - findCitiesPath() which takes 2 inputs origin and destination as Query Parameters 
6. [FindCitiesPathService.java](https://github.com/sandip01jan/VerifyCityPath/blob/master/src/main/java/com/verify/city/path/services/VerifyCitiesPathService.java) -
    A service class is invoked from controller which process the inputs and send to Search class for computing the path of the cities.
7. Endpoints - test in postman.
   - http://localhost:8080/connected?origin=Boston&destination=Newark
   - http://localhost:8080/connected?origin=New York&destination=Philadelphia
   - http://localhost:8080/connected?origin=Philadelphia&destination=Trenton
   

#### `Unit Testing`

[Test classes package](https://github.com/sandip01jan/VerifyCityPath/tree/master/src/test/java/com/verify/city/path).<br>
Unit testing carried through Mockito framework, allows the creation of unit tests for the purpose of test-driven development (TDD).
Test cases are cover Only controller class for this project.
Unit Test classes can run through maven build command or can be execute directly from test class from intellij editor. 
  - />mvn clean install
 
 all the test cases passed.
 

#### `Build Status`
  - Success

#### `Code repository in GITHUB`

  - [VerifyCityPath GITHUB url](https://github.com/sandip01jan/VerifyCityPath)
  
#### `Installation`

  - Please clone above git repo or download the project zip file from github.
  - NO further config or settings needed.
  - Build the project from terminal 
        \VerifyCityPath> mvn clean install  
    Shows BUILD SUCCESS on project compilation and test classes pass through.
  - To execute the application please run below command from terminal 
        \VerifyCityPath> java -jar target/TravelPath-0.0.1-SNAPSHOT.jar    
   Server will up running on 8080     
        Tomcat started on port(s): 8080 (http) with context path<br>
        Started TravelPathApplication in 7.534 seconds (JVM running for 8.751)
        
#### `Screenshots For Proof`

   - [Screenshots](https://github.com/sandip01jan/VerifyCityPath/blob/master/Assignment_screenshots.docx) -
     screenshots of code snippet, unit test cases execution and api calls through postman are recorded in git document.

