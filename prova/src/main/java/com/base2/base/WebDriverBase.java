package com.base2.base;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class WebDriverBase {
    private static WebDriver driver;

    public static WebDriver inicializarDriver() {
        if (driver == null) {
            ChromeOptions options = new ChromeOptions();
            driver = new ChromeDriver(options);
            driver.manage().window().maximize();
            driver.get("https://mantis-prova.base2.com.br/");
        }
        return driver;
    }

    public static void fechaDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
