package org.example.Userinfo;


import io.restassured.response.Response;
import org.example.model.UserPojo;
import org.example.testbase.TestBase;
import org.junit.Test;

import static io.restassured.RestAssured.given;


public class UserCRUDTest extends TestBase {


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
    @Test
    public void updateuserWithPatch(){

        UserPojo userPojo = new UserPojo();
        userPojo.setName("kiana");
        userPojo.setJob("Danser");


        Response response=given()
                .header("Content-Type","application/json")
                .body(userPojo)
                .when()
                .patch("/users/516");
        response.then().statusCode(200);
        response.prettyPrint();
    }
    @Test
    public void delete(){
        Response response=given()
                .when()
                .delete("/users/2");
        response.then().statusCode(204);
        response.prettyPrint();
    }
    @Test
    public void getbackuserInfo() {
        Response response=given()
                .when()
                .get("/users/2");
        response.then().statusCode(200);
        response.prettyPrint();
    }
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
