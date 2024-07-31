package com.pls.pages;

import com.pls.enums.WaitStrategy;
import com.pls.factories.ExplicitWaitFactory;
import org.openqa.selenium.By;

import java.util.Objects;

public class HomePage extends BasePage {

    private final By sideMenu = By.xpath("//ul[@class='oxd-main-menu']");

    @Override
    public boolean isPageDisplayed() {
        return Objects.nonNull(ExplicitWaitFactory.performExplicitWait(WaitStrategy.VISIBLE, sideMenu));
    }

    @Override
    public boolean isPageUrlDisplayed() {
        return false;
    }
}
