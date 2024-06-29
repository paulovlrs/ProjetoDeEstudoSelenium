package com.base2.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.base2.utils.SeleniumUtils;

public class LoginPage {
    private SeleniumUtils seleniumUtils;

     public LoginPage(WebDriver driver) {
        this.seleniumUtils = new SeleniumUtils(driver);
    }

    public void informarNomeDeUsuario(String nome){
        seleniumUtils.digiteTexto(By.id("username"), nome);
        seleniumUtils.saveScreenshotPNG();
    }

    public void clicarBotaoEntrar(){
        seleniumUtils.clicar(By.cssSelector("[value='Entrar']"));
    }

    public void informarSenha(String nome){
        seleniumUtils.digiteTexto(By.id("password"), nome);
    }
}
