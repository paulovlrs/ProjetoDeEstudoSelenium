package com.page;

import com.Serialized.ElementosPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.utils.SeleniumUtils;

public class LoginPage {
    private SeleniumUtils seleniumUtils;
    private ElementosPage elementosPage;

    public LoginPage(WebDriver driver) {
        elementosPage = ElementosPage.fromJson();
        this.seleniumUtils = new SeleniumUtils(driver);
    }

    public void informarNomeDeUsuario() {
        seleniumUtils.digiteTexto(By.id(elementosPage.getLogin().getIdUsername()), elementosPage.getLogin().getValorUsuario());
    }

    public void clicarBotaoEntrar() {
        seleniumUtils.clicar(By.cssSelector(elementosPage.getLogin().getCssSelectorBotaoEntrar()));
    }

    public void informarSenha() {
        seleniumUtils.digiteTexto(By.id(elementosPage.getLogin().getIdPassword()), elementosPage.getLogin().getValorSenha());
    }
}