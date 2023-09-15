package org.example.api.controllers;

import io.restassured.response.Response;
import org.example.api.ApiRequest;
import org.example.api.application.asserts.ApiAsserst;
import org.example.api.entities.Course;
import org.example.api.entities.User;
import org.example.api.utils.JacksonUtils;

import java.util.HashMap;

import static org.example.api.application.TalentLMSBaseEndpoint.*;

public class CourserController extends ApiRequest {

    public CourserController(String url) {
        super(url, API_KEY);
    }

    public Response getAllCourses() {
        return this.response = super.get(getEndpoint(API, V1, COURSES));
    }

    public Response getCourseById(String courseId) {
        return this.response = super.getWithParams(getEndpoint(API, V1, COURSES), generateParams("id", courseId));
    }

    public Response gotoCourse(String userId, String courseId) {
        return this.response = super.getWithParams(getEndpoint(API, V1, GOTO_COURSE), new HashMap<>() {{
            put("user_id", userId);
            put("course_id", courseId);
        }});
    }

    public Response getUserStatusInCourse(String courseId, String userId) {
        return this.response = super.getWithParams(getEndpoint(API, V1, STATUS_COURSE), new HashMap<>() {{
            put("course_id", courseId);
            put("user_id", userId);
        }});
    }

    public Response createCourse(Course course) {
        String json = JacksonUtils.fromObjectTOJson(course);
        return this.response = super.post(getEndpoint(API, V1, CREATE_COURSE), json);
    }
    public Course createCourse (Course course,String id){
        course.setCategoryId(id);
        String json = JacksonUtils.fromObjectTOJson(course);
        return super.post(getEndpoint(API,V1,CREATE_COURSE),json).as(Course.class);
    }
    public Response addUserToCourse(Course course, User user,String role){
         this.response = super.postWithParams(getEndpoint(API,V1,ADD_USER_TO_COURSE),new HashMap<>(){{
            put("user_id",user.getId());
            put("course_id",course.getId());
            put("role",role);
        }});
        return this.response;
    }
}
