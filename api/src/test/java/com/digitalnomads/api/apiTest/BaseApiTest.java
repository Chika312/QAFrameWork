package com.digitalnomads.api.apiTest;
import org.example.api.controllers.CourserController;
import org.example.api.controllers.UserController;
import org.testng.annotations.BeforeSuite;

import static org.example.api.application.TalentLMSBaseEndpoint.BASE_URL;

public class BaseApiTest {
    protected UserController userController;
    protected CourserController courserController;

    @BeforeSuite(alwaysRun = true)
    public void setUpControllers(){
        this.userController= new UserController(BASE_URL);
        this.courserController=new CourserController(BASE_URL);
    }
}
