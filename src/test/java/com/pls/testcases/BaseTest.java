package com.pls.testcases;

import com.pls.driver.Driver;
import com.pls.driver.DriverManager;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.util.Map;

public class BaseTest {

    protected BaseTest() {
    }

    @BeforeSuite
    public void beforeSuite() {
    }

    @AfterSuite
    public void afterSuite() {

    }

    @BeforeMethod
    protected void setUp(Object[] data) {
        Map<String, String> map = (Map<String, String>) data[0];
        Driver.initDriver(map.get("browser"));
        DriverManager.getDriver().manage().window().maximize();
    }

    @AfterMethod
    protected void tearDown() {
        Driver.quitDriver();
    }
}