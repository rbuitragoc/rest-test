# rest-test
A small test rest with JEE

* This was initialized with Adam Bien's Maven 3 archetype for JEE7: https://github.com/AdamBien/javaee7-essentials-archetype
* Run with Glassfish 4, use Java SDK 7.
* Test by sending a GET to http://localhost:8080/rest-test/resources/greetings; you should get a JSON payload that resembles the following: `{ "Hello": "World" }`