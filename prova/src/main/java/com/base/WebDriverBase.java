package com.base;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class WebDriverBase {
    private static WebDriver driver;

    private static final String API_KEY = "YOUR_2CAPTCHA_API_KEY";

    public static WebDriver inicializarDriver() {
        if (driver == null) {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--headless"); // Configuração para modo headless
            options.addArguments("--disable-gpu"); // Necessário para sistemas Linux
            options.addArguments("--no-sandbox");
            options.addArguments("--disable-dev-shm-usage");
            options.addArguments("disable-infobars"); // desabilitar infobars
            options.addArguments("--disable-extensions"); // desabilitar extensões
            options.addArguments("--disable-popup-blocking"); // desabilitar popup
            options.addArguments("--disable-features=EnableEphemeralGuest");
            options.addArguments("--disable-notifications");
            options.addArguments("--disable-blink-features=AutomationControlled");
            options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
            options.setExperimentalOption("useAutomationExtension", false);


            driver = new ChromeDriver(options);
            driver.manage().window().maximize();

            driver.get("https://slimeread.com");
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
