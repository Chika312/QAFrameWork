package org.example.api.utils;

import com.github.javafaker.Faker;

import java.util.Locale;

public class MockData {
    private  static Faker faker = new Faker(new Locale("EN"));
    public  static  String generateName(){
        return faker.name().firstName();
    }

    public  static  String generateLastName(){
        return faker.name().lastName();
    }
    public  static  String generateLogin(){
        return faker.name().username();
    }
    public  static  String generateEmail(){
        return faker.internet().emailAddress();
    }
    public  static  String generatePassword(){
        return faker.internet().password(10,12,true,true,true);
    }
public static String generateCourseName(){
        return faker.book().author();
}
public  static  String generateDescription(){
        return faker.job().title();
}
public static String generateCourseCode(){
        return  faker.internet().password();
}
}
