package com.leniolabs.factories;

import com.leniolabs.constants.FrameworkConstants;
import com.leniolabs.driver.DriverManager;
import com.leniolabs.enums.LogType;
import com.leniolabs.enums.WaitStrategy;
import com.leniolabs.reports.FrameworkLogger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public final class ExplicitWaitFactory {

    private ExplicitWaitFactory() {
    }

    public static WebElement performExplicitWait(WaitStrategy waitstrategy, By by) {
        WebElement element = null;
        if (waitstrategy == WaitStrategy.CLICKABLE) {
            element = untilClickable(by);
        } else if (waitstrategy == WaitStrategy.PRESENCE) {
            element = untilPresence(by);
        } else if (waitstrategy == WaitStrategy.VISIBLE) {
            element = untilVisible(by);
        } else if (waitstrategy == WaitStrategy.NONE) {
            element = onlyFindIt(by);
        }
        return element;
    }

    private static WebElement untilClickable(By by) {
        WebElement element = null;
        try {
            element = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(FrameworkConstants.getExplicitWait()))
                    .until(ExpectedConditions.elementToBeClickable(by));
        } catch (Exception e) {
            FrameworkLogger.log(LogType.CONSOLE, "Element not Clickable");
        }
        return element;
    }

    private static WebElement untilPresence(By by) {
        WebElement element = null;
        try {
            element = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(FrameworkConstants.getExplicitWait()))
                    .until(ExpectedConditions.presenceOfElementLocated(by));
        } catch (Exception e) {
            FrameworkLogger.log(LogType.CONSOLE, "Element not Present");
        }
        return element;
    }

    private static WebElement untilVisible(By by) {
        WebElement element = null;
        try {
            element = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(FrameworkConstants.getExplicitWait()))
                    .until(ExpectedConditions.visibilityOfElementLocated(by));
        } catch (Exception e) {
            FrameworkLogger.log(LogType.CONSOLE, "Element not Visible");
        }
        return element;
    }

    private static WebElement onlyFindIt(By by) {
        WebElement element = null;
        try {
            element = DriverManager.getDriver().findElement(by);
        } catch (Exception e) {
            FrameworkLogger.log(LogType.CONSOLE, "Element not Found");
        }
        return element;
    }

}
