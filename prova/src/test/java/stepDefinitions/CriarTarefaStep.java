package stepDefinitions;

import com.base2.Serialized.ElementosPage;
import com.base2.base.WebDriverBase;
import com.base2.page.CriarTarefaPage;
import com.base2.page.HomePage;
import com.base2.page.LoginPage;
import com.base2.page.VerTarefaPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

public class CriarTarefaStep {

    private WebDriver driver;
    private LoginPage loginPage;
    private HomePage homePage;
    private VerTarefaPage verTarefaPage;
    private CriarTarefaPage criarTarefaPage;
    private ElementosPage elementosPage;

    @Before
    public void setUp() {
        driver = WebDriverBase.inicializarDriver();
        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
        criarTarefaPage = new CriarTarefaPage(driver);
        verTarefaPage = new VerTarefaPage(driver);
        elementosPage = ElementosPage.fromJson();
    }
    @After
    public void finalizar(){
        WebDriverBase.fechaDriver();
    }

    @Given("que estou na tela principal")
    public void que_estou_na_tela_principal() {
        loginPage.informarNomeDeUsuario(elementosPage.getLogin().getValorUsuario());
        loginPage.clicarBotaoEntrar();
        loginPage.informarSenha(elementosPage.getLogin().getValorSenha());
        loginPage.clicarBotaoEntrar();
    }
    @When("clicar em Criar Tarefa")
    public void clicar_em_criar_tarefa() {
        homePage.clicarCriarTarefa();
    }
    @When("preencher todos os campos")
    public void preencher_todos_os_campos() {
        criarTarefaPage.selecionarCategoria("nova categoria");
        criarTarefaPage.selecionarFrequencia("N/D");
        criarTarefaPage.selecionarGravidade("obstáculo");
        criarTarefaPage.preencherResumo("O aplicativo trava ao tentar salvar um documento");
        criarTarefaPage.preencherDescricao("Ao tentar salvar um documento no formato .docx, o aplicativo fecha inesperadamente sem salvar o progresso. Esse problema ocorre sempre que a opção de salvar é acionada, independentemente do tamanho do documento.");
        criarTarefaPage.preencherPassosParaReproduzir("Abrir o aplicativo.\n" +
                "Criar ou abrir um documento existente.\n" +
                "Adicionar conteúdo ao documento.\n" +
                "Tentar salvar o documento no formato .docx.");
        criarTarefaPage.preencherInformacoesAdicionais("Versão do aplicativo: 1.0.3\n" +
                "Sistema Operacional: Windows 10\n" +
                "Memória RAM: 8GB\n" +
                "Espaço em Disco: 100GB disponível");
        criarTarefaPage.selecionarMarcadoresAtuais("bug");
        criarTarefaPage.selecionarMarcadoresAtuais("Desenvolvimento");
        criarTarefaPage.selecionarVisibilidade("privado");
        criarTarefaPage.clicarCriarNovaTarefa();
    }
    @Then("a tarefa sera salva na tela de Ver Tarefas")
    public void a_tarefa_sera_salva_na_tela_de_ver_tarefas() {
        // Verifico que se exibe a mensagem de sucesso
        criarTarefaPage.visualizarMensagemDeSucesso();
        // Verifico se foi realmente salvo durante o redirecionamento da pagina (Para não ter o caso do falso positivo)
        verTarefaPage.verificarSeMensagemFoiSalva("Ao tentar salvar um documento no formato .docx");
    }
}