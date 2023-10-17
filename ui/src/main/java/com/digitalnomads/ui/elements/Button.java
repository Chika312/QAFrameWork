package com.digitalnomads.ui.elements;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class Button extends BaseElement {
    public SelenideElement btn;

    public Button(String  xpath) {
        this.btn = $x(xpath);
    }
}
