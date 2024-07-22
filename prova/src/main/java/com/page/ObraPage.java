package com.page;

import com.Serialized.ElementosPage;
import com.utils.SeleniumUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ObraPage {

    private SeleniumUtils seleniumUtils;
    private ElementosPage elementosPage;

    public ObraPage(WebDriver driver) {
        elementosPage = ElementosPage.fromJson();
        this.seleniumUtils = new SeleniumUtils(driver);
    }

    public void informacoesObra(By by, String informacao) {
        seleniumUtils.esperarElementoVisivel(by);
        seleniumUtils.encontrarTextoElemento(by, informacao);
    }

    public void acessarPaginaDaObra(String nomeObra) {
        String x, y, z;
        x = elementosPage.getPesquisar().getValorPesquisaTituloUm();
        y = elementosPage.getPesquisar().getValorPesquisaTituloDois();
        z = elementosPage.getPesquisar().getValorPesquisaTituloTres();

        if (elementosPage.getPesquisar().getValorPesquisaTituloUm().contains(nomeObra))
            seleniumUtils.acessarSite(elementosPage.getObra().getUrlOReiDosCavaleirosQueRetornaComUmDeus());
        else if (elementosPage.getPesquisar().getValorPesquisaTituloDois().contains(nomeObra))
            seleniumUtils.acessarSite(elementosPage.getObra().getUrlAstralPetStore());
        else if (elementosPage.getPesquisar().getValorPesquisaTituloTres().contains(nomeObra))
            seleniumUtils.acessarSite(elementosPage.getObra().getUrl_OProdigioCavaleiroNegroEmCondicaoTerminal());
        else
            seleniumUtils.mensagemDeFalhaStep("Não foi encontrado a obra que deseja acessar '" + nomeObra + "'");
    }

    public void clicarLerIniciarLeitura() {
        seleniumUtils.clicar(By.cssSelector(elementosPage.getObra().getCssSelectorIniciarLeitura()));
    }

    public void verificaQualCapituloEstou(String capitulo) {
        seleniumUtils.encontrarTextoElemento(By.xpath(elementosPage.getObra().getXpathCapituloAtual()), capitulo);
    }
}
