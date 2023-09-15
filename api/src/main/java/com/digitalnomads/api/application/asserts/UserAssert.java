package org.example.api.application.asserts;

import io.restassured.response.Response;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.example.api.entities.User;
@Slf4j
public class UserAssert {
    Response response;

    public UserAssert(Response response) {
        this.response = response;
    }
    public static UserAssert assertThat(Response response){
        return  new UserAssert(response);
    }

    public UserAssert isEqual(User expectedUser){
        User actualUser = this.response.as(User.class);
        actualUser.isEquals(expectedUser);
        return this;
    }
    public UserAssert isIdNotNull(){
        User actualUser = this.response.as(User.class);
        Assertions.assertThat(actualUser.getId()).isNotNull();
        return this;
    }
    public UserAssert idIsEquals(String actualId,String expectedId){
        Assertions.assertThat(actualId.equals(expectedId));
        log.info("Actual courseID: {}, Expected courseId: {}",actualId,expectedId);
        return this;
    }
}
