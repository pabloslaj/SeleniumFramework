package com.leniolabs.driver;

import com.leniolabs.config.factory.ConfigFactory;
import com.leniolabs.driver.entity.WebDriverData;
import com.leniolabs.enums.BrowserType;
import com.leniolabs.driver.factory.DriverFactory;
import org.openqa.selenium.WebDriver;

import java.util.Objects;

public final class Driver {

    private Driver() {
    }

    public static void initDriver(String browser) {
        if (Objects.isNull(DriverManager.getDriver())) {
            WebDriverData driverData = new WebDriverData(BrowserType.valueOf(browser.trim().toUpperCase()), ConfigFactory.getConfig().browserRemoteMode());

            WebDriver driver = DriverFactory
                    .getDriver(ConfigFactory.getConfig().runMode())
                    .getDriver(driverData);

            DriverManager.setDriver(driver);
            loadHomeURL();
        }
    }

    public static void loadHomeURL() {
        DriverManager.getDriver().get(ConfigFactory.getConfig().webUrl());
    }

    public static void quitDriver() {
        if (Objects.nonNull(DriverManager.getDriver())) {
            DriverManager.getDriver().quit();
            DriverManager.unload();
        }
    }
}