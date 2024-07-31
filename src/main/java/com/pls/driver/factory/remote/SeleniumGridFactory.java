package com.pls.driver.factory.remote;

import com.pls.driver.manager.remote.selenium.SeleniumGridChromeManager;
import com.pls.driver.manager.remote.selenium.SeleniumGridEdgeManager;
import com.pls.driver.manager.remote.selenium.SeleniumGridFirefoxManager;
import com.pls.enums.BrowserType;
import org.openqa.selenium.WebDriver;

public final class SeleniumGridFactory {
    private SeleniumGridFactory() {
    }

    public static WebDriver getDriver(BrowserType browserType) {
        WebDriver webDriver;
        switch (browserType) {
            case CHROME:
                webDriver = SeleniumGridChromeManager.getDriver();
                break;
            case FIREFOX:
                webDriver = SeleniumGridFirefoxManager.getDriver();
                break;
            case EDGE:
                webDriver = SeleniumGridEdgeManager.getDriver();
                break;
            default:
                throw new IllegalArgumentException("Browser not supported: " + browserType);
        }
        return webDriver;
    }
}
