package stepDefinitions;

import com.base2.base.WebDriverBase;
import com.base2.page.CriarTarefaPage;
import com.base2.page.HomePage;
import com.base2.page.LoginPage;
import com.base2.page.VerTarefaPage;
import io.cucumber.java.Before;
import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

public class EditarTarefaSteps extends WebDriverBase {

    private WebDriver driver;
    private LoginPage loginPage;
    private HomePage homePage;
    private VerTarefaPage verTarefaPage;
    private CriarTarefaPage criarTarefaPage;

    @Given("que estou na tela de Ver Tarefa")
    public void que_estou_na_tela_de_ver_tarefa() {
        loginPage.informarNomeDeUsuario("Paulo_VIctor");
        loginPage.clicarBotaoEntrar();
        loginPage.informarSenha("paulo15");
        loginPage.clicarBotaoEntrar();

        // Massa de dados
        homePage.clicarCriarTarefa();
        criarTarefaPage.selecionarCategoria("nova categoria");
        criarTarefaPage.selecionarFrequencia("N/D");
        criarTarefaPage.selecionarGravidade("obstáculo");
        criarTarefaPage.preencherResumo("Bug na funcinalidade xy");
        criarTarefaPage.preencherDescricao("acontece todo santo dia");
        criarTarefaPage.preencherPassosParaReproduzir("Segue a vida que da certo");
        criarTarefaPage.preencherInformacoesAdicionais("novas informações adicionadas");
        criarTarefaPage.selecionarMarcadoresAtuais("bug");
        criarTarefaPage.selecionarMarcadoresAtuais("Desenvolvimento");
        criarTarefaPage.selecionarVisibilidade("privado");
        criarTarefaPage.clicarCriarNovaTarefa();
        verTarefaPage.verificarSeMensagemFoiSalva("acontece todo santo dia");
        verTarefaPage.salvaRetornaIdTarefaGerada();

        // Estou na pagina após criar a massa de teste
        homePage.clicarVerTarefa();
    }
    @When("clicar no codigo da Tarefa")
    public void clicar_no_codigo_da_tarefa() {
        verTarefaPage.clicarTarefaEspecifica(verTarefaPage.retornarIdDaUltimaTarefaCriada());
    }
    @When("preencho uma anotacao {string}")
    public void preencho_uma_anotacao(String anotacao) {
        verTarefaPage.preencherAnotacao(anotacao);
    }
    @When("adiciono um arquivo")
    public void adiciono_um_arquivo() {
        verTarefaPage.enviarArquivos();
    }
    @When("clico no botao de Adicionar Anotacao")
    public void clico_no_botao_de_adicionar_anotacao() {
        verTarefaPage.clicarAdicionarAnotacao();
    }
    @Then("a tarefa salva a anotacao {string}")
    public void a_tarefa_salva_a_anotacao(String anotacao) {
        verTarefaPage.verificarComentarioExiste(anotacao);
    }

    @Before
    public void setUp() {
        driver = inicializarDriver();
        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
        criarTarefaPage = new CriarTarefaPage(driver);
        verTarefaPage = new VerTarefaPage(driver);
    }
    @After
    public void finalizar(){
        fechaDriver();
    }
}