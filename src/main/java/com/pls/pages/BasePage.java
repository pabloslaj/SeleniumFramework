package com.pls.pages;


import com.pls.driver.DriverManager;

public abstract class BasePage {

    protected String getPageTitle() {
        return DriverManager.getDriver().getTitle();
    }

    public abstract boolean isPageDisplayed();

    public abstract boolean isPageUrlDisplayed();

}
