package com.leniolabs.pages;

import com.leniolabs.enums.WaitStrategy;
import com.leniolabs.factories.ExplicitWaitFactory;
import com.leniolabs.utils.testutils.UIActionsHelper;
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
