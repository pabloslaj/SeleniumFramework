package com.pls.driver.manager.remote.selenium;

import com.pls.config.factory.ConfigFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

public class SeleniumGridChromeManager {

    private SeleniumGridChromeManager() {
    }

    public static WebDriver getDriver() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--disable-dev-shm-usage"); // overcome limited resource problems
        chromeOptions.addArguments("--disable-extensions");
        chromeOptions.addArguments("--disable-gpu");
        chromeOptions.addArguments("--no-sandbox");
        chromeOptions.addArguments("--headless=new");
        return new RemoteWebDriver(ConfigFactory.getConfig().seleniumGridURL(), chromeOptions);
    }
}