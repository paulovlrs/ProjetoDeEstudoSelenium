package com.base2.page;

import com.base2.Serialized.ElementosPage;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.base2.utils.SeleniumUtils;

public class CriarTarefaPage {
    private SeleniumUtils seleniumUtils;
    private ElementosPage elementosPage;

    public CriarTarefaPage(WebDriver driver){
        elementosPage = ElementosPage.fromJson();
        this.seleniumUtils = new SeleniumUtils(driver);
    }

    public void selecionarCategoria(String opcao){

        switch (opcao) {
            case "categoria teste" -> {
                seleniumUtils.selecionarDrodownIndex(By.id(elementosPage.getCriarTarefa().getIdSelecionarCategoria()), 1);
            }
            case "nova categoria" -> {
                seleniumUtils.selecionarDrodownIndex(By.id(elementosPage.getCriarTarefa().getIdSelecionarCategoria()), 2);
            }
            default -> throw new AssertionError();
        }
    }

    public void selecionarFrequencia(String opcao){
        switch (opcao) {
            case "sempre" -> {
                seleniumUtils.selecionarDrodownValor(By.id(elementosPage.getCriarTarefa().getIdSelecionarFrequencia()), "10");
            }
            case "às vezes" -> {
                seleniumUtils.selecionarDrodownValor(By.id(elementosPage.getCriarTarefa().getIdSelecionarFrequencia()), "30");
            }
            case "aleatório" -> {
                seleniumUtils.selecionarDrodownValor(By.id(elementosPage.getCriarTarefa().getIdSelecionarFrequencia()), "50");
            }
            case "não se tentou" -> {
                seleniumUtils.selecionarDrodownValor(By.id(elementosPage.getCriarTarefa().getIdSelecionarFrequencia()), "70");
            }
            case "incapaz de reproduzir" -> {
                seleniumUtils.selecionarDrodownValor(By.id(elementosPage.getCriarTarefa().getIdSelecionarFrequencia()), "90");
            }
            case "N/D" -> {
                seleniumUtils.selecionarDrodownValor(By.id(elementosPage.getCriarTarefa().getIdSelecionarFrequencia()), "100");
            }
            default -> throw new AssertionError();
        }
    }

    public void selecionarGravidade(String opcao){
        switch (opcao) {
            case "recurso" -> {
                seleniumUtils.selecionarDrodownValor(By.id(elementosPage.getCriarTarefa().getIdSelecionarDrodownValor()), "10");
            }
            case "trivial" -> {
                seleniumUtils.selecionarDrodownValor(By.id(elementosPage.getCriarTarefa().getIdSelecionarDrodownValor()), "20");
            }
            case "texto" -> {
                seleniumUtils.selecionarDrodownValor(By.id(elementosPage.getCriarTarefa().getIdSelecionarDrodownValor()), "30");
            }
            case "mínimo" -> {
                seleniumUtils.selecionarDrodownValor(By.id(elementosPage.getCriarTarefa().getIdSelecionarDrodownValor()), "40");
            }
            case "pequeno" -> {
                seleniumUtils.selecionarDrodownValor(By.id(elementosPage.getCriarTarefa().getIdSelecionarDrodownValor()), "50");
            }
            case "grande" -> {
                seleniumUtils.selecionarDrodownValor(By.id(elementosPage.getCriarTarefa().getIdSelecionarDrodownValor()), "60");
            }
            case "travamento" -> {
                seleniumUtils.selecionarDrodownValor(By.id(elementosPage.getCriarTarefa().getIdSelecionarDrodownValor()), "70");
            }
            case "obstáculo" -> {
                seleniumUtils.selecionarDrodownValor(By.id(elementosPage.getCriarTarefa().getIdSelecionarDrodownValor()), "80");
            }
            default -> throw new AssertionError();
        }
    }

    public void clicarExpandirSelecionarPerfil() {
        if (seleniumUtils.esperarWebElementoClicavel(By.id("os_build")) == false) {
            seleniumUtils.clicar(By.cssSelector(elementosPage.getCriarTarefa().getCssSelectorBotaoExpasivel()));
        }
    }

    public void clicarRecolherSelecionarPerfil() {
        if (seleniumUtils.esperarWebElementoClicavel(By.id("os_build")) == true) {
            seleniumUtils.clicar(By.cssSelector(elementosPage.getCriarTarefa().getCssSelectorBotaoReduzir()));
        }
    }

    public void preencherPlataforma(String plataforma){

    }

    public void preencherSO(String plataforma){

    }

    public void preencherVersaoSO(String plataforma){

    }

    public void preencherResumo(String resumo){
        seleniumUtils.digiteTexto(By.id(elementosPage.getCriarTarefa().getIdResumo()), resumo);
    }

    public void preencherDescricao(String descricao){
        seleniumUtils.digiteTexto(By.id(elementosPage.getCriarTarefa().getIdDescricao()), descricao);
    }

    public void preencherPassosParaReproduzir(String passos){
        seleniumUtils.digiteTexto(By.id(elementosPage.getCriarTarefa().getIdPassosParaReproduzir()), passos);
    }

    public void preencherInformacoesAdicionais(String informacoes){
        seleniumUtils.digiteTexto(By.id("additional_info"), informacoes);
    }

    public void preencherAplicarMarcadores(String marcadores){
        seleniumUtils.digiteTexto(By.id(elementosPage.getCriarTarefa().getIdAplicarMarcadores()), marcadores);
    }

    public void selecionarMarcadoresAtuais(String marcador){
        switch (marcador) {
            case "Atividade" -> seleniumUtils.selecionarDrodownValor(By.id(elementosPage.getCriarTarefa().getIdSelecionarMarcadoresExistente()), "4");
            case "bug" -> seleniumUtils.selecionarDrodownValor(By.id(elementosPage.getCriarTarefa().getIdSelecionarMarcadoresExistente()), "9");
            case "Desenvolvimento" -> seleniumUtils.selecionarDrodownValor(By.id(elementosPage.getCriarTarefa().getIdSelecionarMarcadoresExistente()), "2");
            case "Grupo Vermelho" -> seleniumUtils.selecionarDrodownValor(By.id(elementosPage.getCriarTarefa().getIdSelecionarMarcadoresExistente()), "5");
            case "urgente" -> seleniumUtils.selecionarDrodownValor(By.id(elementosPage.getCriarTarefa().getIdSelecionarMarcadoresExistente()), "10");
            default -> throw new AssertionError();
        }
    }

    public void enviarArquivos(){
        seleniumUtils.enviarArquivo(elementosPage.getLocalPathArquivo());
    }

    public void selecionarVisibilidade(String visibilidade){
        switch (visibilidade) {
            case "público" -> seleniumUtils.clicarBotaoJavaScript(By.xpath(elementosPage.getCriarTarefa().getXpathSelecionarVisibilidadePublico()));
            case "privado" -> seleniumUtils.clicarBotaoJavaScript(By.xpath(elementosPage.getCriarTarefa().getXpathSelecionarVisibilidadePrivado()));
            default -> throw new AssertionError();
        }
    }

    public void checkCriarMaisTarefas(){
    }

    public void clicarCriarNovaTarefa(){
        seleniumUtils.saveScreenshotPNG();
        seleniumUtils.clicar(By.cssSelector(elementosPage.getVerTarefa().getCssSelectorAdicionarAnotacao()));
    }

    public void visualizarMensagemDeSucesso(){
        try {
            seleniumUtils.esperarElementoVisivel(By.cssSelector(elementosPage.getCriarTarefa().getCssSelectorVisualizarMensagemDeSucesso()));
            seleniumUtils.saveScreenshotPNG();
        }
        catch (Exception e){
            Assert.fail("Não foi exibido mensagem de sucesso");
            seleniumUtils.saveScreenshotPNG();
        }
    }

    public void clicarVisualizarTarefaEnviada(){
        /*
         <a class="btn btn-primary btn-white btn-round " href="view.php?id=910">Visualizar Tarefa Enviada 910</a>
         */
    }

    public void clicarVerTarefa(){
        /*
         <a class="btn btn-primary btn-white btn-round " href="view_all_bug_page.php">Ver Tarefas</a>
         */
    }
}
