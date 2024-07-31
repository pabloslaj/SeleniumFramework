package com.pls.utils.testutils;

import com.pls.enums.LogType;
import com.pls.enums.WaitStrategy;
import com.pls.driver.DriverManager;
import com.pls.factories.ExplicitWaitFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.util.function.Consumer;

import static com.pls.factories.ExplicitWaitFactory.performExplicitWait;
import static com.pls.reports.FrameworkLogger.log;

public final class UIActionsHelper {

    private UIActionsHelper() {
    }

    public static void click(By by, WaitStrategy waitstrategy, String elementName) {
        WebElement element = performExplicitWait(waitstrategy, by);
        element.click();
        log(LogType.EXTENT_AND_CONSOLE, String.format("The element [%s] was clicked", elementName));
    }

    public static void sendKeys(By by, String value, WaitStrategy waitstrategy, String elementName) {
        WebElement element = ExplicitWaitFactory.performExplicitWait(waitstrategy, by);
        element.sendKeys(value);
        log(LogType.EXTENT_AND_CONSOLE, String.format("[%s] typed on [%s]", value, elementName));
    }

    public static void sendKeysAndPressEnter(By by, String value, WaitStrategy waitstrategy, String elementName) {
        WebElement element = ExplicitWaitFactory.performExplicitWait(waitstrategy, by);
        new Actions(DriverManager.getDriver())
                .click(element)
                .sendKeys(value)
                .sendKeys(Keys.ENTER)
                .perform();
        log(LogType.EXTENT_AND_CONSOLE, String.format("[%s] typed on [%s]", value, elementName));
    }

    public static void select(By by, Consumer<Select> consumer) {
        consumer.accept(new Select(performExplicitWait(WaitStrategy.VISIBLE, by)));
    }

    public static String getText(By by, String elementName) {
        WebElement element = ExplicitWaitFactory.performExplicitWait(WaitStrategy.PRESENCE, by);
        String elementText = element.getText();
        log(LogType.EXTENT_AND_CONSOLE, String.format("The text of [%s] is [%s]", elementName, elementText));
        return elementText;
    }


}
