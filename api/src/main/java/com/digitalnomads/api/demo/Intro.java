package com.digitalnomads.api.demo;


import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.*;

public class Intro {
   @Test
    void  demoTest(){
       RestAssured.baseURI="https://reqres.in/";// Указали основной URL
       RequestSpecification requestSpecification =
               given()
                       .contentType(ContentType.JSON)// Указваем тип параметра например в каком формате отпрвить запрос
                       .accept(ContentType.JSON);//В каком формате получить ответ
       Response response = requestSpecification
               .request(Method.GET,"api/users?page=2");
       response.prettyPrint();
   }
    @Test
    void  demoTest2(){
        RestAssured.baseURI="https://reqres.in/";// Указали основной URL
        RequestSpecification requestSpecification =
                given()
                        .contentType(ContentType.JSON)// Указваем тип параметра например в каком формате отпрвить запрос
                        .accept(ContentType.JSON);//В каком формате получить ответ
        Response response = requestSpecification
                .request(Method.GET,"api/users/2");
        response.prettyPrint();
        assertEquals(response.statusCode(),200);
    }
    @Test
    void  createNewUser(){
        RestAssured.baseURI="https://reqres.in/";// Указали основной URL
        RequestSpecification requestSpecification =
                given()
                        .contentType(ContentType.JSON)// Указваем тип параметра например в каком формате отпрвить запрос
                        .accept(ContentType.JSON)//В каком формате получить ответ
                        .body("{\n" +
                                "    \"name\": \"Chika\",\n" +
                                "    \"job\": \"leader\"\n" +
                                "}");
        Response response = requestSpecification
                .request(Method.POST,"api/users");
//        response.prettyPrint();
        JsonPath jsonPath = response.jsonPath();
        assertEquals(response.statusCode(),201);
        assertEquals(jsonPath.getString("name"),"Chika");
        assertEquals(jsonPath.getString("jb"),"leader");
    }
}
