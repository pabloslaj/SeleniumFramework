package com.pls.driver.manager.remote.selenium;

import com.pls.config.factory.ConfigFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

public final class SeleniumGridFirefoxManager {

    private SeleniumGridFirefoxManager() {
    }

    public static WebDriver getDriver() {
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        firefoxOptions.addArguments("--disable-dev-shm-usage"); // overcome limited resource problems
        firefoxOptions.addArguments("--no-sandbox"); // Bypass OS security model
        firefoxOptions.addArguments("--remote-debugging-pipe");//In this mode DevToolsActivePort is not used.
        return new RemoteWebDriver(ConfigFactory.getConfig().seleniumGridURL(), firefoxOptions);
    }
}
