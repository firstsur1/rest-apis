package com.example.restapis.actions;
import static com.example.restapis.Constants.BASE_URL;
import static io.restassured.RestAssured.given;

import java.util.List;

import com.example.restapis.classes.Pet;
import com.example.restapis.classes.PetStatus;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

/**
 * PetsActions
 */
public class PetsActions {
    public static String PET_ENDPOINT = BASE_URL + "/pet";
    private RequestSpecification requestSpecification;

    public PetsActions() {
        requestSpecification = new RequestSpecBuilder()
                .setBaseUri(BASE_URL)
                .setContentType(ContentType.JSON)
                .log(LogDetail.ALL).build();
    }

    public ValidatableResponse getPetsByStatus(PetStatus status) {
        return given(requestSpecification)
                .queryParam("status", PetStatus.available.toString())
                .get(PET_ENDPOINT + "/findByStatus")
                .then().log().all();
                
    }
    
    public List<Pet> getPetsByStatusAndDoChecks(PetStatus status) {
        return given(requestSpecification)
                .queryParam("status", PetStatus.available.toString())
                .get(PET_ENDPOINT + "/findByStatus")
                .then().log().all()
                .extract().body()
                .jsonPath().getList("", Pet.class);

    }

    
    

}