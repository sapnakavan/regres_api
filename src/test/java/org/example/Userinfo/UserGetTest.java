package org.example.Userinfo;


import io.restassured.response.Response;
import org.example.testbase.TestBase;
import org.junit.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.given;


public class UserGetTest extends TestBase {

    @Test
    public void getAllUserInfo() {
        Response response=given()
                .when()
                .get("/users?page=2");
        response.then().statusCode(200);
        response.prettyPrint();
    }

    @Test
    public void getSingleuserInfo() {
    Response response=given()
            .when()
            .get("/users/8");
    response.then().statusCode(200);
    response.prettyPrint();
    }







}
