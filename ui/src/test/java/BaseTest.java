import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.digitalnomads.ui.helper.HelperMethod;
import com.digitalnomads.ui.pages.FoodPage;
import com.digitalnomads.ui.pages.HomePage;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.util.*;
import java.util.stream.Collectors;


//@Listeners(AllureReportListener.class)
public class BaseTest {
    public HelperMethod helperMethod;
    public HomePage homePage;
    public FoodPage foodPage;

    @BeforeClass
    public void openDriver() {
        homePage = new HomePage();
        homePage = new HomePage();
        foodPage = new FoodPage();
        helperMethod = new HelperMethod();
        Configuration.headless = false;
        Configuration.browser = "Chrome";
        Configuration.timeout = 10000;
        Configuration.screenshots = true;
        Configuration.browserSize = "1920x1080";

    }

    @AfterClass
    public void closeDriver() {
        Selenide.closeWebDriver();

    }

    public static void main(String[] args) {

    }
}