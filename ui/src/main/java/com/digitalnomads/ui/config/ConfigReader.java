package com.digitalnomads.ui.config;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    static Properties properties;
    static {
       try{
           String path = "src/main/resources/app.properties";
           FileInputStream input = new FileInputStream(path);
           properties = new Properties();
           properties.load(input);
           input.close();
       }catch (IOException e){
           e.printStackTrace();
       }
    }
    public  static  String getPropertiesInfo(String key){
        return properties.getProperty(key);
    }
}
