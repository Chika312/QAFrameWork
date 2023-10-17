package com.digitalnomads.api.application.asserts;

import io.restassured.response.Response;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;

@Slf4j
public class ApiAsserst {
    Response response;

    public ApiAsserst(Response response) {
        this.response = response;
    }

    public static ApiAsserst assertThat(Response response) {
        return new ApiAsserst(response);
    }

    public ApiAsserst isCorrectStatesCode(Integer expectedStatusCode) {
        int actualStatusCode = this.response.getStatusCode();
        Assertions.assertThat(actualStatusCode)
                .withFailMessage("Status code is not correct")
                .isEqualTo(expectedStatusCode);
        log.info("Status code is correct Actual {}, Expected {}", actualStatusCode, expectedStatusCode);
        return this;
    }
    public UserAssert assertUser(){
        return  UserAssert.assertThat(this.response);
    }
}
