package Examples;

import io.restassured.response.Response;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.lessThanOrEqualTo;

public class FirstTest {
    //BaseURI

    String baseURI = "https://petstore.swagger.io/v2/pet";

    @Test

    public void QueryParamTest() {
        //Send GET Request
        Response response =
                given()
                        .header("Content-Type", "application/json").queryParam("status", "alive")
                        .when().get(baseURI + "/findByStatus");

        //Response Body
        System.out.println(response.getBody().asString());
        System.out.println(response.getBody().asPrettyString());

        //Response Headers
        System.out.println(response.getHeaders().asList());
        System.out.println(response.getHeader("Server"));

        //Extract JSON Properties
        String petStatus = response.then().extract().path("[0].status");
        System.out.println("Status of pet 1 is" + petStatus);

        //RESTAssured Assertions
        response.then().statusCode(200);
        response.then().body("[0].status", equalTo("alive"));
        response.then().body("[0].name", equalTo("Hansel"));
        response.then().time(lessThanOrEqualTo(5000L));

    }

        @Test
        public void PathParamTest()
        {
            //Send GET Request
            given().header("Content-Type", "application/json").pathParam("petId", 77232)
                    .when()
                    .get(baseURI + "/{petId}")
                    .then()
                    .statusCode(200)
                    .body("status", equalTo("alive"))
                    .body("name", equalTo("Riley"))
                    .time(lessThanOrEqualTo(2000L));
        }


}
