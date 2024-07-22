package com.utils;

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
        this.wait = new WebDriverWait(this.driver, Duration.ofSeconds(20));
    }

    public Boolean antiBot(By by) {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(by));
            return true;
        } catch (Exception e) {
            acessarSite("https://slimeread.com/recentes");
            return false;
        }
    }

    public void acessarSite(String site) {
        driver.get(site);
    }

    public void esperarElementoVisivel(By by) {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        } catch (TimeoutException e) {
            mensagemDeFalhaStep("Elemento não encontrado dentro do tempo esperado: " + by + ", erro: " + e);
        }
    }

    public void clicarListaElementos(By by, Integer numero){
        List<WebElement> listaElementos = driver.findElements(by);
        listaElementos.get(numero).click();
    }

    public void encontrarTextoElemento(By by, String texts) {
        try {
            wait.until(ExpectedConditions.textToBePresentInElementLocated(by, texts));
        } catch (Exception e) {
            mensagemDeFalhaStep("Não foi possível localizar o texto:'" + texts + "' no elemento, erro: " + e.getMessage());
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
            mensagemDeFalhaStep("Elementos não foram encontrados dentro do tempo esperado: " + by + ", erro: " + e);
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

        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", element);
    }

    public void clicarBotaoJavaScript(By by) {

        WebElement element = driver.findElement(by);

        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", element);
    }

    public void clicar(By by) {
        esperarElementoVisivel(by);
        driver.findElement(by).click();
    }

    public void selecionarDrodownIndex(By by, Integer index) {
        esperarElementoVisivel(by);
        Select dropdown = new Select(driver.findElement(by));
        dropdown.selectByIndex(index);
    }

    public void selecionarDrodownValor(By by, String opcao) {
        esperarElementoVisivel(by);
        Select dropdown = new Select(driver.findElement(by));
        dropdown.selectByValue(opcao);
    }

    public void enviarArquivo(String caminho) {
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

    public void mensagemDeFalhaStep(String mensagem) {
        Assert.fail(mensagem);
    }

    public String retornarValorElemento(By by) {
        return driver.findElement(by).getText();
    }

    @Attachment(value = "Page screenshot", type = "image/png")
    public byte[] saveScreenshotPNG() {
        Allure.addAttachment("Screenshot", new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }
}
