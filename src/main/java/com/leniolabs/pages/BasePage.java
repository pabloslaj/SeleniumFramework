package com.leniolabs.pages;


import com.leniolabs.driver.DriverManager;

public abstract class BasePage {

    protected String getPageTitle() {
        return DriverManager.getDriver().getTitle();
    }

    public abstract boolean isPageDisplayed();

    public abstract boolean isPageUrlDisplayed();

}
