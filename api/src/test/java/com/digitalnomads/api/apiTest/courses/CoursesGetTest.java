package com.digitalnomads.api.apiTest.courses;

import com.digitalnomads.api.apiTest.BaseApiTest;
import com.digitalnomads.api.application.asserts.ApiAsserst;
import com.digitalnomads.api.entities.Course;
import com.digitalnomads.api.entities.User;
import com.digitalnomads.api.utils.EntityManager;
import org.testng.annotations.Test;

import java.util.Arrays;

public class CoursesGetTest extends BaseApiTest {
    @Test
    public void getAllCoursesTest() {
        Course[] course = courserController.getAllCourses().as(Course[].class);
        System.out.println(Arrays.toString(course));
    }

    @Test
    public void getCourseById() {
        Course course = courserController.getCourseById("126").as(Course.class);
        System.out.println(course);
        ApiAsserst.assertThat(courserController.getResponse()).isCorrectStatesCode(200);
    }

    @Test
    public void getCotoCourse() {
        courserController.gotoCourse("1", "123");
        ApiAsserst.assertThat(courserController.getResponse()).isCorrectStatesCode(200);
    }

    @Test
    public void getStatusInCourse() {
        courserController.getUserStatusInCourse("124", "1");
        ApiAsserst.assertThat(courserController.getResponse()).isCorrectStatesCode(200);
    }

    @Test
    public void createCourse() {
        User user = userController.createUserAlwaysTime(EntityManager.geneerateUser());
        ApiAsserst.assertThat(userController.getResponse())
                .isCorrectStatesCode(200)
                .assertUser()
                .isIdNotNull();
        Course course = courserController.createCourse(EntityManager.generateCourse(), "3");
        ApiAsserst.assertThat(courserController.getResponse())
                .isCorrectStatesCode(200);
        courserController.addUserToCourse(course, user, "learner");
        ApiAsserst.assertThat(courserController.getResponse()).isCorrectStatesCode(200);
        userController.getUserById(user.getId());
        ApiAsserst.assertThat(userController.getResponse())
                .isCorrectStatesCode(200)
                .assertUser().idIsEquals(
                        userController.courseId("courses.id").get(0), course.getId());
    }

}
