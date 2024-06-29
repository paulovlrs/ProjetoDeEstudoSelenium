package com.base2.base;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverBase {
    protected WebDriver driver;

    public WebDriver inicializarDriver() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://mantis-prova.base2.com.br/");
        return driver;
    }

    protected void fechaDriver() {
        if (driver != null) {
            driver.quit();
        }
    }
}
