import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.digitalnomads.ui.pages.BasePage;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.codeborne.selenide.Selenide.*;

public class TestNamba extends BaseTest {
    @Test
    public void nambofood() {
      open("https://nambafood.kg/");
        Assert.assertEquals(foodPage.foods.size(),16);
    }

    @Test
    public void selenideTest() throws InterruptedException {
        open("https://nambafood.kg/");

        Assert.assertTrue( foodPage.foodsName.stream().anyMatch(
                e ->e.getText().replaceAll("[a-zа-я\\d]","")
                        .trim()
                        .equalsIgnoreCase("национальная кухня")));
        Assert.assertEquals(foodPage.foodsName.size(),16);


    }
    @Test
    public void  testSelenide(){
        open("https://nambafood.kg/");
        $x("(//a[@href='/food'])[1]").click();
        $$x("//a[@class='cat-item']").shouldHave(CollectionCondition.textsInAnyOrder("национальная кухня"));


    }


    public static void main(String[] args) {

        Map<String, Integer> users = new HashMap<>();
        users.put("Chika", 19);
        users.put("Talai", 59);
        users.put("Ilgiz", 12);
        users.put("Nazar", 15);
        users.put("Izat", 49);
        users.put("Toily", 18);
        System.out.println(users);
        List<String> namba = new ArrayList<>(users.keySet());
        for (String name:namba) {
            if(users.get(name)<18){
                users.remove(name,users.get(name));
            }
        }
        System.out.println(users);

    }
    public static Map<String,Integer>userElderThan18(Map<String,Integer>users){
        List<String> name = new ArrayList<>(users.keySet());
        for (String username:name) {
            if(users.get(username)<18){
                users.remove(username);
            }
        }
        return users;
    }
    @DataProvider
    public Object[][] data(){
        return  new Object[][]{
                {"Chika",12,true},
                {"Talai",59,false},
                {"Ilgiz", 12,true},
                {"Nazar", 15,true},
                {"Izat", 49,false},
                {"Toily", 18,false},
        };

    }
    @Test(dataProvider = "data")
    public void testMethod (String v1,Integer v2,Boolean expected){
        Assert.assertEquals(userElderThan18(new HashMap<>(){{put(v1,v2);}}).isEmpty(),expected);

    }



}
