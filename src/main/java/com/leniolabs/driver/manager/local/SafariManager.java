package com.leniolabs.driver.manager.local;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.safari.SafariDriver;

public final class SafariManager {

    private SafariManager() {
    }

    public static WebDriver getDriver() {
        return new SafariDriver();
    }
}
