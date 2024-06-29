package com.base2.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.base2.utils.SeleniumUtils;

public class HomePage {
    private SeleniumUtils seleniumUtils;

    public HomePage(WebDriver driver) {
        this.seleniumUtils = new SeleniumUtils(driver);
        seleniumUtils.saveScreenshotPNG();
    }

    public void expandirNaoAtribuidos(){

    }

    public void expandirRelatadosPorMim(){

    }

    public void expandirResolvidos(){

    }

    public void expandirModificadosRecentemente(){

    }

    public void expandirMonitoradosPorMim(){

    }

    public void expandirLinhaDoTempo(){

    }

    public void clicarCriarTarefa(){
        seleniumUtils.clicar(By.cssSelector("[class='menu-icon fa fa-edit']"));
        seleniumUtils.saveScreenshotPNG();
    }

    public void clicarVerTarefa(){
        seleniumUtils.clicar(By.cssSelector("[class='menu-icon fa fa-list-alt']"));
    }

    public void clicarMinhaVisao(){
        seleniumUtils.clicar(By.cssSelector("[class='menu-icon fa fa-dashboard']"));
    }
}
