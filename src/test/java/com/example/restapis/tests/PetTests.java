package com.example.restapis.tests;


import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.example.restapis.actions.PetsActions;
import com.example.restapis.classes.Pet;
import com.example.restapis.classes.PetStatus;

import io.restassured.response.ValidatableResponse;



/**

 * PetTests

 */

public class PetTests {

    PetsActions petsActions;



    @BeforeClass

    public void beforeClass() {

        petsActions = new PetsActions();

    }

    @Test

    public void getPetsByStatusTest() {
    	
    	petsActions.getPetsByStatus(PetStatus.available);

        }

    
    @Test
    public void getPetsByStatusAndDoChecksTest() {
    	
    	int noOfPetsWithStatusAvailable=0;
    	int noOfPetsWithNameDoggie=0;
        List<Pet> pets = petsActions.getPetsByStatusAndDoChecks(PetStatus.available);

        for (Pet pet : pets) {
        	if(pet.getStatus().equals(PetStatus.available)) {       		
        		noOfPetsWithStatusAvailable++;
        	}
        	if(pet.getName().equals("doggie"))   {        		
        		noOfPetsWithNameDoggie++;
        	}
        }
		Assert.assertEquals(noOfPetsWithStatusAvailable, 4185);
		Assert.assertEquals(noOfPetsWithNameDoggie, 2523);

            

        }

    }



    





    

