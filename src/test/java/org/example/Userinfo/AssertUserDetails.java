package org.example.Userinfo;

import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import org.hamcrest.Matcher;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.Matchers.hasKey;

public class AssertUserDetails {
    static ValidatableResponse response;

    @BeforeClass
    public static void inIt() {
        RestAssured.baseURI = "https://reqres.in/";
        response = given()
                .when()
                .get("/api/users?page=2")
                .then().statusCode(200);
    }

    //1.page = 2
    @Test
    public void verifypages(){
        response.body("page",equalTo(2));

    }


    //2.per_page = 6
    @Test
    public void verifyperpages(){
        response.body("per_page",equalTo(6));

    }
    //3.data[1].id = 8
    @Test
    public void verifyid(){
        response.body("data[1]",hasKey("id"));          //both method working
       // response.body("data[1].id",equalTo(8));

    }

    //4.data[3].first_name = Byron
    @Test
    public void verifyname(){
        response.body("data[3].first_name",equalTo("Byron"));

    }
    //5.list of data = 6
    @Test
    public void verifylistofitems() {
        response.body("data[5]", equalTo("6"));

    }


    //6.data[5].avatar="https://reqres.in/img/faces/12-image.jpg"
    @Test
    public void verifyavtar(){
        response.body("data[5].avatar",equalTo("https://reqres.in/img/faces/12-image.jpg"));

    }
    //7. support.url ="https://reqres.in/#support-heading"
    @Test
    public void verifyurl(){
        response.body("support.url",equalTo("https://reqres.in/#support-heading"));

    }
    //8. support.txt = "To keep ReqRes free, contributions towards server costs are appreciated!"
    @Test
    public void verifytext() {
        response.body("support.text", equalTo("To keep ReqRes free, contributions towards server costs are appreciated!"));
    }
    }
