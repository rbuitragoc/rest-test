# rest-test
A small test rest with JEE

* This was initialized with Adam Bien's Maven 3 archetype for JEE7: https://github.com/AdamBien/javaee7-essentials-archetype
* Run with Glassfish 4, use Java SDK 7.
* Unit tests supported by JUnit and Rest-Assured can be run via `mvn test` goal.
* Test by sending a GET to http://localhost:8080/rest-test/resources/greetings; you should get a JSON payload that resembles the following: 

	{ "Hello": "World" }
	
* Test by sending a GET to http://localhost:8080/rest-test/resources/greetings/ANYSTRING; you sould get a JSON payload that resembles the following: 

	{ "salutation": "hello, ANYSTRING"}
	
* Test POSTing plain string values for "firstName" and "lastName" form parameters to http://localhost:8080/rest-test/resources/greetings; you should get the following XML payload in return:

	<greeting>
	   <firstName>Nombre</firstName>
	   <lastName>Apellido</lastName>
	</greeting>
	