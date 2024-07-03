package com.base2.page;

import com.base2.Serialized.ElementosPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.base2.utils.SeleniumUtils;

public class LoginPage {
    private SeleniumUtils seleniumUtils;
    private ElementosPage elementosPage;

    public LoginPage(WebDriver driver) {
        elementosPage = ElementosPage.fromJson();
        this.seleniumUtils = new SeleniumUtils(driver);
    }

    public void informarNomeDeUsuario(String nome) {
        seleniumUtils.digiteTexto(By.id(elementosPage.getLogin().getIdUsername()), nome);
        seleniumUtils.saveScreenshotPNG();
    }

    public void clicarBotaoEntrar() {
        seleniumUtils.clicar(By.cssSelector(elementosPage.getLogin().getCssSelectorBotaoEntrar()));
    }

    public void informarSenha(String nome) {
        seleniumUtils.digiteTexto(By.id(elementosPage.getLogin().getIdPassword()), nome);
    }
}