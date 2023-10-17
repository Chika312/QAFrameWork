package com.digitalnomads.api.utils;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.digitalnomads.api.entities.User;

public class JacksonUtils {
    private  static  final ObjectMapper objentMapper = new ObjectMapper();

    public  static  String  fromObjectTOJson(Object object){
        try{
            return objentMapper.writeValueAsString(object);
        }catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        User user = EntityManager.geneerateUser();
        System.out.println(user);
        System.out.println(fromObjectTOJson(user));
    }
}
