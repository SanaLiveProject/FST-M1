package LiveProject;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.lessThan;
import static io.restassured.RestAssured.given;

public class GitHubProjectTest {
    String sshKey = "AAAAC3NzaC1lZDI1NTE5AAAAIPqAtvjlRlsymDDAYzt14TaLr6+ZgokW3ZIZaWIdlos6";
            int sshKeyId;
    //Request Specification
    RequestSpecification requestSpec = new RequestSpecBuilder().
            setBaseUri("https://api.github.com/user/keys").
            addHeader("Authorization", "token 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").
            addHeader("Content-Type", "application/json").build();

    //Response Specification
    ResponseSpecification responseSpec = new ResponseSpecBuilder().
            expectResponseTime(lessThan(5000L)).
            expectBody("key", equalTo(sshKey)).
            expectBody("title", equalTo("TestAPIKey")).build();
    @Test(priority = 1)
    public void postRequestTest()
    {
        //Path : https://api.github.com/user/keys
        //Request body
        Map<String, String> reqBody = new HashMap<>();
        reqBody.put("title", "TestAPIKey");
        reqBody.put("key", sshKey);

        //Generate Response
        Response response = given().spec(requestSpec).body(reqBody).when().post();

        //Extract the id
         sshKeyId = response.then().extract().path("id");

         //Assertions
        response.then().statusCode(201).spec(responseSpec);
    }
    @Test(priority = 2)
    public void getRequestTest()
    {
        //Path : https://api.github.com/user/keys
        //Generate response and assert
        given().spec(requestSpec).pathParam("keyId", sshKeyId).
                when().get("/{keyId}").then().statusCode(200).spec(responseSpec);

    }
    @Test(priority = 3)
    public void deleteRequestTest()
    {
        //Path : https://api.github.com/user/keys
        //Generate response and assert
        given().spec(requestSpec).pathParam("keyId", sshKeyId).
                when().delete("/{keyId}").then().statusCode(204).time(lessThan(5000L));

    }

}
