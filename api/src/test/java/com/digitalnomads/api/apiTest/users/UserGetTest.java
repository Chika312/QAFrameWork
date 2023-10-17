package com.digitalnomads.api.apiTest.users;

import com.digitalnomads.api.apiTest.BaseApiTest;
import com.digitalnomads.api.application.asserts.ApiAsserst;
import com.digitalnomads.api.entities.User;
import com.digitalnomads.api.utils.EntityManager;
import org.testng.annotations.Test;

import java.util.Arrays;

import static org.testng.Assert.*;

public class UserGetTest extends BaseApiTest {
    @Test
    public void getUser() {
        String expectedEmail = "smith@example.com";
        String expectedEmailNegative = "smith@example.com1";
        userController.getUserByEmail(expectedEmail);
        User user = userController.extractObjectFromResponse(User.class);
        System.out.println(user.toString());
        assertEquals(user.email, expectedEmail, "User email is not correct");
    }

    @Test
    public void getAllUser() {
        User[] user = userController.getAllUsers().as(User[].class);
        System.out.println(Arrays.toString(user));
    }

    @Test
    public void UserOnline() {
        userController.isUserOnline("1");
        ApiAsserst.assertThat(userController.getResponse()).isCorrectStatesCode(200);
    }

    @Test
    public void getUserByUsername() {
        userController.getUserByUsername("talaive_dkf2323");
        ApiAsserst.assertThat(userController.getResponse()).isCorrectStatesCode(200);
    }

    @Test
    public void setStatusUser() {
        userController.userSerStatus("11", "active");
        ApiAsserst.assertThat(userController.getResponse()).isCorrectStatesCode(200);
    }

    @Test
    public void userSignUp() {
        User user = EntityManager.geneerateUser();
        userController.userSignUp(user);
        ApiAsserst.assertThat(userController.getResponse()).isCorrectStatesCode(200);
    }

    @Test
    public void createUser() {
        User user = EntityManager.geneerateUser();
        User createdUser = userController.createUser(user);
        createdUser.isEquals(user);
        assertNotNull(createdUser.getId());
    }

    @Test
    public void deleteUser() {
        userController.deleteUser("12");
    }

    @Test
    public void createAndDeleteUser() {
        User expected = EntityManager.geneerateUser();
        userController.createUserAlwaysTime(expected);
        ApiAsserst.assertThat(userController.getResponse())
                .isCorrectStatesCode(200)
                .assertUser()
                .isEqual(expected)
                .isIdNotNull();


    }

    @Test
    public void editUser() {
        userController.getUserById("23");
        userController.editUserNameAndPassword("23", "London", "London2!");
    }

    @Test
    public void getUserCustomField() {
        userController.getUserByCustomField("test");
    }

    @Test
    public void userLogIn() {
        userController.userLogin("Chiken", "Chika2525");
        ApiAsserst.assertThat(userController.getResponse()).isCorrectStatesCode(200);
    }

}
