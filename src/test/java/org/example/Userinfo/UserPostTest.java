package org.example.Userinfo;



import io.restassured.response.Response;
import org.example.model.UserPojo;
import org.example.testbase.TestBase;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;


public class UserPostTest extends TestBase {

    @Test
    public void createUser() {

        UserPojo userPojo = new UserPojo();
        userPojo.setName("sapna");
        userPojo.setJob("Tester");


        Response response=given()
                .header("Content-Type","application/json")
                .body(userPojo)
                .when()
                .post("/users");
        response.then().statusCode(201);
        response.prettyPrint();
    }
}
