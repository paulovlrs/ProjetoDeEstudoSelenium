package stepDefinitions;

import com.Serialized.ElementosPage;
import com.hooks.Hooks;
import com.page.HomePage;
import com.page.LoginPage;
import com.page.ObraPage;
import com.page.PesquisaPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PesquisaSteps {
    private HomePage homePage;
    private PesquisaPage pesquisaPage;
    private LoginPage loginPage;
    private ElementosPage elementosPage;
    private ObraPage obraPage;
    private WebDriver driver;

    public PesquisaSteps() {
        this.driver = Hooks.getDriver();
        this.homePage = new HomePage(driver);
        this.loginPage = new LoginPage(driver);
        this.pesquisaPage = new PesquisaPage(driver);
        this.obraPage = new ObraPage(driver);
        this.elementosPage = ElementosPage.fromJson();
    }

    @Given("Que estou na tela principal")
    public void que_estou_na_tela_principal() {
        homePage.clicarBotaoLogin();
        loginPage.informarNomeDeUsuario();
        loginPage.informarSenha();
        loginPage.clicarBotaoEntrar();
    }

    @When("Pesquisar o nome do Manhwa ou manga")
    public void pesquisar_o_nome_do_manhwa_ou_manga() {
        homePage.clicarBotaoPesquisa();
        pesquisaPage.preencherCampoPesquisa(elementosPage.getPesquisar().getValorPesquisaTituloUm());
        pesquisaPage.clicarBotaoPesquisa();
    }

    @When("clicar no resultado da pesquisa")
    public void clicar_no_resultado_da_pesquisa() {
        pesquisaPage.clicarCardObra(elementosPage.getPesquisar().getValorPesquisaTituloUm());
    }

    @Then("Sou redirecionado para pagina com os capitulos")
    public void sou_redirecionado_para_pagina_com_os_capitulos(){
        obraPage.informacoesObra(By.cssSelector(elementosPage.getObra().getCssSelectorDivInformacaoObra()),elementosPage.getPesquisar().getValorPesquisaTituloUm());
    }
}