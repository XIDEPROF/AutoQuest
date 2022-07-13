import io.restassured.http.ContentType;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class TestRest {
    @Test
    void postAdd() {

        String name = "Буся";
        JSONObject bodyJO = new JSONObject()
                .put("id", 25)
                .put("name",name)
                .put("status", "available");

        given()
                .when()
                .contentType(ContentType.JSON)
                .log().all()
                .body(bodyJO.toString())
                .post("https://petstore.swagger.io/v2/pet")
                .then()
                .log().all()
                .statusCode(200);

        System.out.println(bodyJO);
    }

    @Test
    void updatePet() {
        String name = "Муся";
        JSONObject bodyJO = new JSONObject()
                .put("id", 25)
                .put("name",name)
                .put("status", "available");

        given()
                .when()
                .contentType(ContentType.JSON)
                .log().all()
                .body(bodyJO.toString())
                .post("https://petstore.swagger.io/v2/pet")
                .then()
                .log().all()
                .statusCode(200);

        System.out.println(bodyJO);
    }

    @Test
    void getInfoPet(){

        given()
                .when()
                .log().all()
                .pathParam("petId",25)
                .get("https://petstore.swagger.io/v2/pet/{petId}")
                .then()
                .log().all()
                .statusCode(200);

    }

    @Test
    void deletePet() {
        given()
                .when()
                .log().all()
                .pathParam("petId",25)
                .delete("https://petstore.swagger.io/v2/pet/{petId}")
                .then()
                .log().all()
                .statusCode(200);
    }
}
