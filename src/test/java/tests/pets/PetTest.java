package tests.pets;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.core.IsIterableContaining.*;

public class PetTest {
    @BeforeClass
    public void setup(){
        RestAssured.baseURI = "https://petstore.swagger.io/v2";
    }

    @Test(description = "should return 200 when valid payload for pet is sent")
    public void registerPet(){
        given()
            .contentType(ContentType.JSON)
            .body("{\n" +
                    "  \"id\": 101,\n" +
                    "  \"category\": {\n" +
                    "    \"id\": 10,\n" +
                    "    \"name\": \"Dogs\"\n" +
                    "  },\n" +
                    "  \"name\": \"Rex\",\n" +
                    "  \"photoUrls\": [\n" +
                    "    \"https://petphotos.com/dog/rex123.jpg\"\n" +
                    "  ],\n" +
                    "  \"tags\": [\n" +
                    "    {\n" +
                    "      \"id\": 1,\n" +
                    "      \"name\": \"puppy\"\n" +
                    "    } \n" +
                    "  ],\n" +
                    "  \"status\": \"available\"\n" +
                    "}\n")
        .when()
            .post("/pet")
        .then()
            .statusCode(200)
                .body("id", equalTo(101))
                .body("name", equalTo("Rex"))
                .body("category.id", equalTo(10))
                .body("category.name", equalTo("Dogs"))
                .body("photoUrls", hasItems("https://petphotos.com/dog/rex123.jpg"))
                .body("tags.id", hasItem(1))
                .body("tags.name", hasItem("puppy"))
                .body("status", equalTo("available"));

    }

}
