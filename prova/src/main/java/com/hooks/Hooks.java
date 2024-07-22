package com.hooks;

import com.base.WebDriverBase;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;

public class Hooks extends WebDriverBase {
    private static WebDriver driver;

    @Before
    public void setUp() {
        driver = inicializarDriver();
    }

    @After
    public void tearDown() {
        fechaDriver();
    }

    public static WebDriver getDriver() {
        return driver;
    }
}