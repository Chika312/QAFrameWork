package com.digitalnomads.api.apiTest.courses;

import com.digitalnomads.api.apiTest.BaseApiTest;
import org.example.api.application.asserts.ApiAsserst;
import org.example.api.entities.Course;
import org.example.api.utils.EntityManager;
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
        Course course = EntityManager.generateCourse();
        courserController.createCourse(course);
        ApiAsserst.assertThat(courserController.getResponse()).isCorrectStatesCode(200);
    }

}
