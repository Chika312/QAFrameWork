package com.digitalnomads.api.apiTest;
import com.digitalnomads.api.controllers.CourserController;
import com.digitalnomads.api.controllers.UserController;
import org.testng.annotations.BeforeSuite;

import static com.digitalnomads.api.application.TalentLMSBaseEndpoint.BASE_URL;

public class BaseApiTest {
    protected UserController userController;
    protected CourserController courserController;

    @BeforeSuite(alwaysRun = true)
    public void setUpControllers(){
        this.userController= new UserController(BASE_URL);
        this.courserController=new CourserController(BASE_URL);
    }
}
