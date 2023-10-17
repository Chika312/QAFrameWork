package com.digitalnomads.api.utils;

import com.digitalnomads.api.entities.Category;
import com.digitalnomads.api.entities.Course;
import com.digitalnomads.api.entities.User;

import static com.digitalnomads.api.utils.MockData.*;

public class EntityManager {
    public  static User geneerateUser(){
        return User.builder()
                .firstName(generateName())
                .lastName(generateLastName())
                .email(generateEmail())
                .login(generateLogin())
                .password(generatePassword())
                .build();
    }
    public static Course generateCourse(){
        return Course.builder()
                .name(generateName())
                .description(generateDescription())
                .code(generateCourseCode())
                .build();
    }
    public static Category generateCategory(){
        return Category.builder()
                .name(generateName())
                .price(generateEmail())
                .build();
    }

}
