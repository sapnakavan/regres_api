package org.example.Userinfo;

import io.restassured.response.Response;
import org.example.model.UserPojo;
import org.example.testbase.TestBase;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class UserPostLoginSuccessful extends TestBase {
    @Test
    public void userloginsuccessful() {
        UserPojo userPojo = new UserPojo();
        userPojo.setEmail("eve.holt@reqres.in");
        userPojo.setPassword("cityslicka");

        Response response = given()
                .header("Content-Type", "application/json")
                .body(userPojo)
                .when()
                .post("/login");
        response.then().statusCode(200);
        response.prettyPrint();
    }

}