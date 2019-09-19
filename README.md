# rest-apis

rest-apis is a project which uses API "https://petstore.swagger.io". It uses the following REST endpoint: "https://petstore.swagger.io/#/pet/findPetsByStatus"

It is a maven project , all the dependencies can be found in the pom.xml file


To run the Tests:
1. Run the Test as a TNG test

Output:
The test PetTests.java has 2 tests.
getPetByStatusTest() will validate that valid response is returned.
getPetByStatusAndDoChecksTest()will get the JSON response payload and validate how many pets have the status “available” and the name “doggie”.

