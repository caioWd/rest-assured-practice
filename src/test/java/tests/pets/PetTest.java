package tests.pets;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import payloads.pets.dtos.PetDTO;
import payloads.pets.records.Category;
import payloads.pets.records.Tags;

import java.util.List;

import static io.restassured.RestAssured.*;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.core.IsIterableContaining.*;

public class PetTest {
    @BeforeClass
    public void setup() {
        RestAssured.baseURI = "https://petstore.swagger.io/v2";
    }

    @Test(description = "should return 200 when valid payload for pet is sent")
    public void registerPet() {

        PetDTO pet = PetDTO.builder()
                .id(101)
                .name("Rex")
                .category(new Category(10, "Dogs"))
                .photoUrls(List.of("https://petphotos.com/dog/rex123.jpg"))
                .tags(List.of(new Tags(1, "puppy")))
                .status("available")
                .build();

        given()
                .contentType(ContentType.JSON)
                .body(pet)
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
