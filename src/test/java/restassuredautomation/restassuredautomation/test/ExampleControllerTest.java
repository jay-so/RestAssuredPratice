package restassuredautomation.restassuredautomation.test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class ExampleControllerTest {

    @Test
    public void test_1_Testng() {
        Response response = RestAssured.get("https://reqres.in/api/users?page=2");

        System.out.println("response.getStatusCode() = " + response.getStatusCode());
        System.out.println("response.getTime() = " + response.getTime());
        System.out.println("response.getBody().asString() = " + response.getBody().asString());
        System.out.println("response.getStatusLine() = " + response.getStatusLine());
        System.out.println("response.getHeader(\"content-type\") = " + response.getHeader("content-type"));

        int statusCodeode = response.getStatusCode();

//        Assert.assertEquals(actural,expetcted);
        Assert.assertEquals(statusCodeode, 200);
    }

    @Test
    public void test_2() {

        baseURI = "https://reqres.in/api";
        given().
            get("/users?page=2").
            then().
            statusCode(200)
            .body("data[1].id", equalTo(8))
            .log().all();
    }
}
