package tests;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class UserTest {

    @BeforeClass
    public void setup(){
        RestAssured.baseURI = "https://petstore.swagger.io/v2";
    }

    @Test(description = "should return 200 when valid payload for user is sent")
    public void createUser(){
        given()
            .contentType(ContentType.JSON)
            .body("{\n" +
                    "  \"id\": 0,\n" +
                    "  \"username\": \"S@M\",\n" +
                    "  \"firstName\": \"Sam\",\n" +
                    "  \"lastName\": \"Jones\",\n" +
                    "  \"email\": \"sam@email.com\",\n" +
                    "  \"password\": \"sam123\",\n" +
                    "  \"phone\": \"(27) 98480-1678\",\n" +
                    "  \"userStatus\": 0\n" +
                    "}")
        .when()
            .post("/user")
        .then()
            .log()
            .all()
            .statusCode(200);

    }
}
