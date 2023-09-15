package org.example.api.demo;

import com.google.gson.Gson;
import org.testng.annotations.Test;

public class GsonDemo {
    @Test
    void  test123(){
        String payload ="{\n" +
                "    \"brand\": \"BMW\",\n" +
                "    \"doors\": \"4\"\n" +
                "}";
        Gson gson = new Gson();
        Car car = gson.fromJson(payload,Car.class);
        System.out.println(car);
        Car car1 = new Car("Mers",6);
        String result = gson.toJson(car1);
        System.out.println(result);
    }
}
