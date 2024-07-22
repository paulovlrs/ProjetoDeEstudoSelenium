package stepDefinitions;

import com.hooks.Hooks;
import com.page.ObraPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

public class LerObraSteps {
    private ObraPage obraPage;
    private WebDriver driver;

    public LerObraSteps(){
        this.driver = Hooks.getDriver();
        this.obraPage = new ObraPage(driver);
    }

    @Given("Que estou na pagina da obra {string}")
    public void que_estou_na_pagina_da_obra(String string) {
        obraPage.acessarPaginaDaObra(string);
    }
    @When("clicar em iniciar leitura")
    public void clicar_em_iniciar_leitura() {
        obraPage.clicarLerIniciarLeitura();
    }
    @Then("Acesso o primeiro capitulo da obra")
    public void acesso_o_primeiro_capitulo_da_obra() {
        obraPage.verificaQualCapituloEstou("Cap-1");
    }
}
