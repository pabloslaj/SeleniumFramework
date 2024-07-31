package com.pls.driver.manager.remote.selenium;

import com.pls.config.factory.ConfigFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

public class SeleniumGridEdgeManager {

    private SeleniumGridEdgeManager() {
    }

    public static WebDriver getDriver() {
        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.addArguments("--disable-dev-shm-usage"); // overcome limited resource problems
        edgeOptions.addArguments("--no-sandbox"); // Bypass OS security model
        edgeOptions.addArguments("--disable-extensions");
        edgeOptions.addArguments("--headless=new");
        edgeOptions.addArguments("--no-sandbox");
        return new RemoteWebDriver(ConfigFactory.getConfig().seleniumGridURL(), edgeOptions);
    }
}