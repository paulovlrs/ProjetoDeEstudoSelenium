package com.page;

import com.Serialized.ElementosPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.utils.SeleniumUtils;

public class PesquisaPage {
    private SeleniumUtils seleniumUtils;
    private ElementosPage elementosPage;

    public PesquisaPage(WebDriver driver){
        elementosPage = ElementosPage.fromJson();
        this.seleniumUtils = new SeleniumUtils(driver);
    }

    public void preencherCampoPesquisa(String opcao){
        seleniumUtils.digiteTexto(By.cssSelector(elementosPage.getPesquisar().getCssSelectorCampoPesquisa()), opcao);
    }

    public void clicarBotaoPesquisa(){
        seleniumUtils.clicar(By.xpath(elementosPage.getPesquisar().getXpathBotaoPesquisar()));
    }

    public void clicarCardObra(String nomeObra) {
        nomeObra = "//a[contains(.,'" + nomeObra + "')]";
        seleniumUtils.clicar(By.xpath(nomeObra));
    }
}
