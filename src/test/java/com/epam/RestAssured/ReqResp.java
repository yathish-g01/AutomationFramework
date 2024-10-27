package com.epam.RestAssured;

import org.testng.annotations.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.*;
import static org.hamcrest.CoreMatchers.equalTo;

public class ReqResp {

    final String URL = "https://reqres.in/api/users";
    int id;

    @Test(priority = 3,dependsOnMethods = "createUser")
    public void getAllUsers() {
        given()
                .when()
                .get("https://reqres.in/api/users?page=11")
                .then()
                .statusCode(200)
                .body("page", equalTo(11))
                .log().all();
    }

    @Test(priority = 1)
    public void createUser() {
        String data = "{ \"name\": \"David\", \"job\": \"Developer\" }";
        //or

        HashMap<String,String> data1=new HashMap<>();
        data1.put("thomas","teacher");
        data1.put("adam","Sales");
        id = given()
                .contentType("application/json")
                .body(data)
                .when()
                .post(URL)
                .jsonPath().getInt("id");
//                .then()
//                .statusCode(201)
//                .log().all();


    }

    @Test(priority = 3,dependsOnMethods = "createUser")
    public void updateuser() {
        String data = "{ \"name\": \"Yathish\", \"job\": \"Tester\" }";
        given()
                .contentType("application/json")
                .body(data)
                .when()
                .put(URL+"/id")
                .then()
                .statusCode(200);
    }

    @Test(priority = 4)
    public void deleteUser(){
        given()
                .when()
                .delete(URL+"id")
                .then()
                .statusCode(204).log().all();
    }
}

