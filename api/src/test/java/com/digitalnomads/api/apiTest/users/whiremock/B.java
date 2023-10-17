package com.digitalnomads.api.apiTest.users.whiremock;

import com.digitalnomads.api.apiTest.BaseApiTest;
import com.github.tomakehurst.wiremock.WireMockServer;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import com.digitalnomads.api.entities.User;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.github.tomakehurst.wiremock.client.WireMock.*;

public class B extends BaseApiTest {


    private WireMockServer wireMockServer;

    @BeforeClass
    public void setUpWireMock() {
        // Define the desired port and host for WireMock
        int port = 8080;
        String host = "localhost";

        // Create and start the WireMock server with the specified configuration
        wireMockServer = new WireMockServer(port);
        wireMockServer.start();

        // Configure stubs for your tests
        stubFor(get(urlEqualTo("/api/users"))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("Content-Type", "application/json")
                        .withBody("[\n" +
                                "       \n" +
                                "        {\n" +
                                "            \"id\": 9,\n" +
                                "            \"email\": \"tobias.funke@reqres.in\",\n" +
                                "            \"first_name\": \"Tobias\",\n" +
                                "            \"last_name\": \"Funke\",\n" +
                                "            \"avatar\": \"https://reqres.in/img/faces/9-image.jpg\"\n" +
                                "        },\n" +
                                "        {\n" +
                                "            \"id\": 10,\n" +
                                "            \"email\": \"byron.fields@reqres.in\",\n" +
                                "            \"first_name\": \"Byron\",\n" +
                                "            \"last_name\": \"Fields\",\n" +
                                "            \"avatar\": \"https://reqres.in/img/faces/10-image.jpg\"\n" +
                                "        },\n" +
                                "        {\n" +
                                "            \"id\": 11,\n" +
                                "            \"email\": \"george.edwards@reqres.in\",\n" +
                                "            \"first_name\": \"George\",\n" +
                                "            \"last_name\": \"Edwards\",\n" +
                                "            \"avatar\": \"https://reqres.in/img/faces/11-image.jpg\"\n" +
                                "        },\n" +
                                "        {\n" +
                                "            \"id\": 12,\n" +
                                "            \"email\": \"rachel.howell@reqres.in\",\n" +
                                "            \"first_name\": \"Rachel\",\n" +
                                "            \"last_name\": \"Howell\",\n" +
                                "            \"avatar\": \"https://reqres.in/img/faces/12-image.jpg\"\n" +
                                "        }\n" +
                                "    ]")
                )
        );
    }

    @Test
    public void testWireMock(){
        // Your test code that interacts with the WireMock server

        Response response = RestAssured.given()
                .baseUri("http://localhost:8080")
                .get("/api/users");
        User[] getusers= response.as(User[].class);
        User[] users= userController.getAllUsers().as(User[].class);
        userController.deleteAllUsers(users);
        userController.createFourUser(getusers);
    }

    @AfterClass
    public void tearDownWireMock() {
        // Stop the WireMock server after your tests are complete
        wireMockServer.stop();
    }
}