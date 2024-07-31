package com.pls.driver;

import com.pls.driver.entity.WebDriverData;
import com.pls.driver.factory.remote.RemoteDriverFactory;
import org.openqa.selenium.WebDriver;

public class RemoteWebDriverImpl implements IWebDriver {

    @Override
    public WebDriver getDriver(WebDriverData webDriverData) {
        return RemoteDriverFactory.getDriver(webDriverData.getBrowserRemoteModeType(), webDriverData.getBrowserType());
    }
}