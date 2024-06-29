package com.base2.utils;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.time.Duration;
import java.util.List;

import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumUtils {
    private WebDriver driver;
    private WebDriverWait wait;

    public SeleniumUtils(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(this.driver, Duration.ofSeconds(10));
    }

    public void esperarElementoVisivel(By by) {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        } catch (TimeoutException e) {
            Assert.fail("Elemento não encontrado dentro do tempo esperado: " + by + ", erro: " + e);
        }
    }

    public Boolean mensagemSpam(){
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[class='alert alert-danger']")));
            return true;
        } catch (TimeoutException e) {
            return false;
        }
    }

    public Boolean esperarWebElementoClicavel(By by) {
        WebElement element = driver.findElement(by);
        try {
            wait.until(ExpectedConditions.elementToBeClickable(element));
            return true;
        } catch (TimeoutException e) {
           return false;
        }
    }

    public void esperarWebElementoLocated(By by) {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        } catch (TimeoutException e) {
            Assert.fail("Elementos não foram encontrados dentro do tempo esperado: " + by + ", erro: " + e);
        }
    }

    public void passarSobreElementoLista(By by, Integer numeroDaLista) {
        List<WebElement> elements = driver.findElements(by);
        WebElement element = elements.get(numeroDaLista);
        Actions action = new Actions(driver);
        action.moveToElement(element).moveToElement(element).click().build().perform();
    }

    public void clicarBotaoListaJavaScript(By by, Integer numero) {
        List<WebElement> elements = driver.findElements(by);

        WebElement element = elements.get(numero); // Localize o elemento

        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", element);
    }

    public void clicarBotaoJavaScript(By by) {

        WebElement element = driver.findElement(by);

        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", element);
    }

    public void clicar(By by) {
        esperarElementoVisivel(by);
        driver.findElement(by).click();
    }

    public void selecionarDrodownIndex(By by, Integer index){
        esperarElementoVisivel(by);
        Select dropdown = new Select(driver.findElement(by));
        dropdown.selectByIndex(index);
    }

    public void selecionarDrodownValor(By by, String opcao){
        esperarElementoVisivel(by);
        Select dropdown = new Select(driver.findElement(by));
        dropdown.selectByValue(opcao);
    }

    public void enviarArquivo(String caminho){
        File file = new File(caminho);
        driver.findElement(By.cssSelector("input[type='file']")).sendKeys(file.getAbsolutePath());       
    }


    public void digiteTexto(By by, String texto) {
        esperarElementoVisivel(by);
        driver.findElement(by).sendKeys(texto);
    }

    public void apertarEnter(By by) {
        esperarElementoVisivel(by);
        driver.findElement(by).sendKeys(Keys.ENTER);
    }

    public void mensagemDeFalhaStep(String mensagem){
        Assert.fail(mensagem);
    }

    public String retornarValorElemento(By by){
        return driver.findElement(by).getText();
    }

    @Attachment(value = "Page screenshot", type = "image/png")
    public byte[] saveScreenshotPNG() {
        Allure.addAttachment("Screenshot", new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }
}
