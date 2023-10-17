package com.digitalnomads.ui.helper;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HelperMethod {
    public SelenideElement waitElement(SelenideElement element) {
        return element.shouldBe(Condition.visible);
    }

    public HelperMethod writeText(SelenideElement element, String text) {
        waitElement(element).setValue(text);
        return this;
    }

    public HelperMethod scroll(SelenideElement element) {
        waitElement(element).scrollTo();
        return this;
    }

    public HelperMethod moveToElement(SelenideElement element) {
        waitElement(element).hover();
        return this;
    }
}
