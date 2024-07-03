package com.base2.page;

import com.base2.Serialized.ElementosPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.base2.utils.SeleniumUtils;

public class HomePage {
    private SeleniumUtils seleniumUtils;
    private ElementosPage elementosPage;

    public HomePage(WebDriver driver) {
        this.seleniumUtils = new SeleniumUtils(driver);
        elementosPage = ElementosPage.fromJson();
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
        seleniumUtils.clicar(By.cssSelector(elementosPage.getHome().getCssSelectorClicarTarefa()));
        seleniumUtils.saveScreenshotPNG();
    }

    public void clicarVerTarefa(){
        seleniumUtils.clicar(By.cssSelector(elementosPage.getHome().getCssSelectorClicarVerTarefa()));
    }

    public void clicarMinhaVisao(){
        seleniumUtils.clicar(By.cssSelector(elementosPage.getHome().getCssSelectorClicarMinhaVisao()));
    }
}
