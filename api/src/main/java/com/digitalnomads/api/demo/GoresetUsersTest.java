package com.digitalnomads.api.demo;

import com.google.gson.Gson;
import io.restassured.http.ContentType;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import lombok.Getter;
import lombok.ToString;

import java.io.Reader;
import java.lang.annotation.Retention;
import java.util.List;

import static io.restassured.RestAssured.given;

public class GoresetUsersTest {
    public static void main(String[] args) {
        String newuser = "{\n" +
                "    \"name\": \"Chikasa\",\n" +
                "    \"email\": \"chikadjfhgo@gmail.com\",\n" +
                "    \"gender\": \"male\",\n" +
                "    \"status\": \"active\"\n" +
                "}";
        RequestSpecification requestSpecification =
                given()
                        .baseUri("https://gorest.co.in/public/v2")
                        .header("Authorization", "Bearer 174e9efd6cc73a2f6dc3efb07dc64287a5f5dcdb829a4b7a72df79e0443b0bf7")
                        .contentType(ContentType.JSON)
                        .accept(ContentType.JSON)
                        .body(newuser);
        Response response = requestSpecification.request("POST", "/users");
        response.prettyPrint();


    }
}
