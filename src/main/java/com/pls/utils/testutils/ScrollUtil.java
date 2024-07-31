package com.pls.utils.testutils;

import com.pls.enums.LogType;
import com.pls.enums.WaitStrategy;
import com.pls.driver.DriverManager;
import com.pls.factories.ExplicitWaitFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

import static com.pls.reports.FrameworkLogger.log;

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

