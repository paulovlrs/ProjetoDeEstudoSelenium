package com.page;

import com.Serialized.ElementosPage;
import com.utils.SeleniumUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    private SeleniumUtils seleniumUtils;
    private ElementosPage elementosPage;

    public HomePage(WebDriver driver) {
        this.seleniumUtils = new SeleniumUtils(driver);
        elementosPage = ElementosPage.fromJson();
    }

    public void clicarBotaoLogin() {
        seleniumUtils.clicar(By.xpath(elementosPage.getHome().getXpathBotaoLogin()));

        // gambiarra para passar pelo site de anti-bot
        while (seleniumUtils.antiBot(By.cssSelector(elementosPage.getLogin().getCssSelectorModalLogin())) == false) {
            seleniumUtils.acessarSite("https://slimeread.com/");
            seleniumUtils.clicar(By.xpath(elementosPage.getHome().getXpathBotaoLogin()));
        }
    }

    public void clicarBotaoPesquisa() {
        seleniumUtils.clicar(By.cssSelector(elementosPage.getHome().getCssSelectorBotaoPesquisarMangas()));

        // gambiarra para passar pelo site de anti-bot
        while (seleniumUtils.antiBot(By.cssSelector(elementosPage.getPesquisar().getCssSelectorCampoPesquisa())) == false) {
            seleniumUtils.acessarSite("https://slimeread.com/");
            seleniumUtils.clicar(By.cssSelector(elementosPage.getHome().getCssSelectorBotaoPesquisarMangas()));
        }
    }
}
