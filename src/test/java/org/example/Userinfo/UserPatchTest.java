package org.example.Userinfo;



import io.restassured.response.Response;
import org.example.model.UserPojo;
import org.example.testbase.TestBase;
import org.junit.Test;

import static io.restassured.RestAssured.given;


public class UserPatchTest extends TestBase {

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
}
