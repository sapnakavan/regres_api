package org.example.Userinfo;



import io.restassured.response.Response;
import org.example.testbase.TestBase;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class UserDeleteTest extends TestBase {

    @Test
    public void delete(){
        Response response=given()
                .when()
                .delete("/users/2");
        response.then().statusCode(204);
        response.prettyPrint();
    }
}
