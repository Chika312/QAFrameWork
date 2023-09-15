package org.example.api.controllers;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import lombok.extern.slf4j.Slf4j;
import org.example.api.ApiRequest;
import org.example.api.entities.User;
import org.example.api.utils.EntityManager;
import org.example.api.utils.JacksonUtils;
import org.example.api.utils.MockData;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import static org.example.api.application.TalentLMSBaseEndpoint.*;
import static org.example.api.utils.MockData.generateLogin;
import static org.example.api.utils.MockData.generatePassword;

@Slf4j
public class UserController extends ApiRequest {

    public UserController(String url) {
        super(url, API_KEY);
    }

    public Response getAllUsers() {
        return this.response = super.get(getEndpoint(API, V1, USERS));
    }

    public Response getUserByEmail(String email) {
        return this.response = super.getWithParams(getEndpoint(API, V1, USERS), generateParams(EMAIL, email));
    }

    public Response getUserById(String id) {
        return this.response = super.getWithParams(getEndpoint(API, V1, USERS), generateParams(ID, id));
    }

    public Response getUserByUsername(String userName) {
        return this.response = super.getWithParams(getEndpoint(API, V1, USERS), generateParams(USERS_NAME, userName));
    }

    public boolean isUserOnline(String id) {
        return super.getWithParams(getEndpoint(API, V1, ONLINE), generateParams("user_id", id)).jsonPath().getBoolean("online");
    }


    public Response userSerStatus(String userId, String activeOrInactive) {
        return this.response = super.getWithParams(getEndpoint(API, V1, USERS_STATUS), new HashMap<>() {{
            put("user_id", userId);
            put("status", activeOrInactive);
        }});
    }

    public Response userSignUp(User user) {
        return this.response = postWithParams(getEndpoint(API, V1, USER_SIGN_UP), new HashMap<>() {{
            put("first_name", user.getFirstName());
            put("last_name", user.getLastName());
            put("email", user.getEmail());
            put("login", user.getLogin());
            put("password", user.getPassword());
        }});
    }

    public Response editUserNameAndPassword(String id, String name, String password) {
        return this.response = postWithParams(getEndpoint(API, V1, EDIT_USER), new HashMap<>() {{
            put("user_id", id);
            put("first_name", name);
            put("password", password);
        }});
    }

    public Response getUserByCustomField(String v1) {
        return this.response = super.getWithParams(getEndpoint(API, V1, CUSTOM_FIELD), generateParams("custom_field_value", v1));
    }


    public User createUser(User user) {
        String jsonUser = JacksonUtils.fromObjectTOJson(user);
        return super.post(getEndpoint(API, V1, USER_SIGN_UP), jsonUser).as(User.class);
    }
    public Response createFourUser(User[]users){
        for (int i = 0; i < users.length; i++) {
            users[i].setLogin(generateLogin());
            users[i].setPassword(generatePassword());
            createUser(users[i]);
        }
        return this.response;
    }

    public Response deleteUser(String userId) {
        return super.postWithParams(getEndpoint(API, V1, DELETE_USER), new HashMap<>() {{
            put("user_id", userId);
            put("deleted_by_user_id", "1");
        }});
    }

    public Response deleteAllUsers(User[] users) {
        for (int i = 0; i < users.length; i++) {
            if (users[i].getId().equals("1")) {

            } else {
                deleteUser(users[i].getId());
            }
        }
        return this.response;
    }

    public Response userLogin(String login, String password) {
        return this.response = super.postWithParams(getEndpoint(API, V1, USER_LOGIN), new HashMap<>() {{
            put("login", login);
            put("password", password);
        }});

    }

    public List<String> courseId(String jsPath) {
        return this.response.jsonPath().getList(jsPath);
    }

    public User createUserAlwaysTime(User user) {
        log.info("createUserAlwaysTime");
        User[] user1 = getAllUsers().as(User[].class);
        if (user1.length >= 5) {
            int i = 0;
            for (i = 0; i < user1.length; i++) {
                if (user1[i].getFirstName().equals("Chyngyz")) {
                    break;
                }
            }
            int r = 0;
            for (int j = 0; j < 20; j++) {
                Random random = new Random();
                r = random.nextInt(5);
                if (r != i) {
                    break;
                }
            }
            log.info("Delete user {}, size is {}", user1[r].firstName, user1.length);
            deleteUser(user1[r].getId());

        }
        return createUser(user);
    }


}
