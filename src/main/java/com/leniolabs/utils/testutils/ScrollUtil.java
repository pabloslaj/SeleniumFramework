package com.leniolabs.utils.testutils;

import com.leniolabs.enums.LogType;
import com.leniolabs.enums.WaitStrategy;
import com.leniolabs.driver.DriverManager;
import com.leniolabs.factories.ExplicitWaitFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

import static com.leniolabs.reports.FrameworkLogger.log;

public final class ScrollUtil {

    private ScrollUtil() {
    }

    public static boolean scrollToFindElementYAxis(By by) {
        try {
            log(LogType.CONSOLE, "Scrolling to Element");
            WebElement element = ExplicitWaitFactory.performExplicitWait(WaitStrategy.PRESENCE, by);
            ((JavascriptExecutor) DriverManager.getDriver()).executeScript("arguments[0].scrollIntoView(true)", element);
            return true;
        } catch (NoSuchElementException e) {
            log(LogType.EXTENT_AND_CONSOLE, "Element not found");
            return false;
        } catch (Exception e) {
            log(LogType.EXTENT_AND_CONSOLE, "An error occurred when scrolling to the element");
            return false;
        }
    }

    public static void scrollAndClickElement(By by, String elementName) {
        WebElement webElement = ExplicitWaitFactory.performExplicitWait(WaitStrategy.CLICKABLE, by);
        ((JavascriptExecutor) DriverManager.getDriver()).executeScript("arguments[0].click()", webElement);
        log(LogType.EXTENT_AND_CONSOLE, String.format("The element [%s] was clicked", elementName));
    }

    public static void scrollToPageBottom() {
        ((JavascriptExecutor) DriverManager.getDriver()).executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }
}

