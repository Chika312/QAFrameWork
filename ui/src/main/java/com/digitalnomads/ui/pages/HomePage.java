package com.digitalnomads.ui.pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Selenide.$x;

public class HomePage extends BasePage {
    public SelenideElement foodBtn = $x("(//a[@href='/food'])[1]");

}
