package com.digitalnomads.api.demo;

import lombok.extern.slf4j.Slf4j;
@Slf4j
public class Main {

    public static void main(String[] args) {
        System.out.println("Hello world!");
        testLog();
    }
    public static  void testLog(){
        log.info("Тестируем логин");
        log.warn("GET");
        log.debug("chika");
        log.error("chikas");
    }

}