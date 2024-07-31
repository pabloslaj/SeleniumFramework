package com.pls.driver.factory.remote;

import com.pls.enums.BrowserRemoteModeType;
import com.pls.enums.BrowserType;
import org.openqa.selenium.WebDriver;

public final class RemoteDriverFactory {

    private RemoteDriverFactory() {
    }

    public static WebDriver getDriver(BrowserRemoteModeType browserRemoteModeType, BrowserType browserType) {
        if (browserRemoteModeType == BrowserRemoteModeType.SELENIUM) {
            return SeleniumGridFactory.getDriver(browserType);
        }
        return null;
    }

}