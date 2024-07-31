package com.pls.testcases;

import com.pls.pages.HomePage;
import com.pls.pages.LoginPage;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

import java.util.Map;

public class LoginTests extends BaseTest {

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
