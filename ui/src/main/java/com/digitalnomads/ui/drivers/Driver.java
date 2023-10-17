package com.digitalnomads.ui.drivers;

import com.digitalnomads.ui.config.ConfigReader;
import org.openqa.selenium.WebDriver;

public class Driver {
    private Driver() { // сиглтон
    }

    public static WebDriver driver;

    public static WebDriver getDriver() {
        if (driver == null) {
            switch (ConfigReader.getPropertiesInfo("browers")) {
                case "chrome":
                    driver = CromeWebDriver.loadCromeWebDriver();
                    break;
                case "firefox":
                    driver = FirefoxWebDriver.loadFirefoxDriver();
                    break;
                default:
                    System.out.println("Вы не правильно ввели данные ");
            }
        }
        return driver;
    }
    public static  void closedDriver(){
        try{
            if(driver!=null){
                driver.close();
                driver.quit();
                driver=null;
            }
        }catch (Exception e){
            System.out.println("Ошибка при закрытии ");
        }
    }

}
