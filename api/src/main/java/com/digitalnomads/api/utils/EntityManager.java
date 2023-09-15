package org.example.api.utils;

import org.example.api.entities.Category;
import org.example.api.entities.Course;
import org.example.api.entities.User;

import static org.example.api.utils.MockData.*;

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
