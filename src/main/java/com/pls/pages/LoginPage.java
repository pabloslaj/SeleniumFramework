package com.pls.pages;

import com.pls.enums.WaitStrategy;
import org.openqa.selenium.By;

import static com.pls.utils.testutils.UIActionsHelper.click;
import static com.pls.utils.testutils.UIActionsHelper.sendKeys;

public class LoginPage extends BasePage {

    private final By inputEmail = By.xpath("//input[@name='username']");
    private final By inputPassword = By.xpath("//input[@name='password']");
    private final By btnLogin = By.xpath("//button[@type='submit']");

    @Override
    public boolean isPageDisplayed() {
        return false;
    }

    @Override
    public boolean isPageUrlDisplayed() {
        return false;
    }

    public LoginPage setEmail(String email) {
        sendKeys(inputEmail, email, WaitStrategy.VISIBLE, "Input text [Email]");
        return this;
    }

    public LoginPage setPassword(String password) {
        sendKeys(inputPassword, password, WaitStrategy.VISIBLE, "Input text [Password]");
        return this;
    }

    public HomePage clickOnBtnLogin() {
        click(btnLogin, WaitStrategy.CLICKABLE, "Button [Login]");
        return new HomePage();
    }
}
