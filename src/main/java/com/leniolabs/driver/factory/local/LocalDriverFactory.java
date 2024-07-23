package com.leniolabs.driver.factory.local;

import com.leniolabs.driver.manager.local.ChromeManager;
import com.leniolabs.driver.manager.local.EdgeManager;
import com.leniolabs.driver.manager.local.FirefoxManager;
import com.leniolabs.driver.manager.local.SafariManager;
import com.leniolabs.enums.BrowserType;
import org.openqa.selenium.WebDriver;

public final class LocalDriverFactory {

    private LocalDriverFactory() {
    }

    public static WebDriver getDriver(BrowserType browserType) {
        WebDriver webDriver;
        switch (browserType) {
            case CHROME:
                webDriver = ChromeManager.getDriver();
                break;
            case FIREFOX:
                webDriver = FirefoxManager.getDriver();
                break;
            case EDGE:
                webDriver = EdgeManager.getDriver();
                break;
            case SAFARI:
                webDriver = SafariManager.getDriver();
                break;
            default:
                throw new IllegalArgumentException("Tipo de navegador no soportado: " + browserType);
        }
        return webDriver;
    }

}