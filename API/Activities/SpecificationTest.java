package Examples;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static io.restassured.RestAssured.when;
import static org.hamcrest.Matchers.lessThanOrEqualTo;
import static org.hamcrest.Matchers.equalTo;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class SpecificationTest {

    //Specifications
    RequestSpecification requestSpec;
    ResponseSpecification responseSpec;

    int petId;

    @BeforeClass
    public void setup()
    {
        //Request Specification
        requestSpec = new RequestSpecBuilder()
                .setBaseUri("https://petstore.swagger.io/v2/pet")
                .addHeader("Content-Type", "application/json")
                .build();

        //Response Specification
        responseSpec = new ResponseSpecBuilder()
                .expectStatusCode(200)
                .expectResponseTime(lessThanOrEqualTo(3000L))
                .expectBody("status", equalTo("alive"))
                .build();

    }

    @Test
    public void postRequestTest()
    {
        Map <String, Object> reqBody = new HashMap<>();
        reqBody.put("id", 77232);
        reqBody.put("name", "Riley");
        reqBody.put("status", "alive");

        //Send POST Request
        Response response = given().spec(requestSpec).body(reqBody).log().all().when().post();
        System.out.println(response.getBody().asPrettyString());

        //Extract ID from Response
        petId = response.then().extract().path("id");

        //Assertions
        response.then().spec(responseSpec).body("name", equalTo("Riley")).log().all();
    }

    @Test
    public void getRequestTest()
    {
        //Send GET Request
        given().spec(requestSpec).pathParam("petId", petId).log().all()
                .when().delete("/{petId}").then()
                .statusCode(200)
                .time(lessThanOrEqualTo(5000L))
                .body("message", equalTo("" + petId));
    }
    @Test
    public void deleteRequestTest()
    {
        //Send GET Request
        given().spec(requestSpec).pathParam("petId", petId).
                when().delete("/{petId}").
                then().statusCode(200).time(lessThanOrEqualTo(5000L)).
                body("message", equalTo("" +petId));
    }

}
