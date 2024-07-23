package com.leniolabs.testcases;

import com.leniolabs.pages.HomePage;
import com.leniolabs.pages.LoginPage;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

import java.util.Map;

public class DemoTest extends BaseTest {

    HomePage homePage;

    @Test
    public void tc1_LoginSuccessfully(Map<String, String> data) {

        // Perform Login
        homePage = new LoginPage().setEmail(data.get("userEmail"))
                .setPassword(data.get("password"))
                .clickOnBtnLogin();

        // Validate that is correctly logged:
        Assertions.assertThat(homePage.isPageDisplayed()).as("Home Page is not displayed").isTrue();
    }
}
