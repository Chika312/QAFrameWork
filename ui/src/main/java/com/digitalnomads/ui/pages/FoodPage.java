package com.digitalnomads.ui.pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static com.codeborne.selenide.Selenide.*;

public class FoodPage extends BasePage {
    public List<SelenideElement> foods=$$x("//div[@class='cat-item--prev']");
    public List<SelenideElement> foodsName=$$x("//a[@class='cat-item']");

    public FoodPage clickFirstElement() {
        foods.get(0).click();
        return this;
    }





}
