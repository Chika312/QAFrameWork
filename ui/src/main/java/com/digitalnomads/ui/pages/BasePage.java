package com.digitalnomads.ui.pages;

import com.digitalnomads.ui.helper.HelperMethod;

public abstract class BasePage {
    HelperMethod helperMethod;
    public  BasePage(){
        helperMethod = new HelperMethod();
    }
}
