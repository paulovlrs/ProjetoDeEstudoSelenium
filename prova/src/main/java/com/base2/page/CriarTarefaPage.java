package com.base2.page;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.base2.utils.SeleniumUtils;

public class CriarTarefaPage {
    private SeleniumUtils seleniumUtils;

    public CriarTarefaPage(WebDriver driver){
        this.seleniumUtils = new SeleniumUtils(driver);
    }
    
    public void selecionarCategoria(String opcao){

        switch (opcao) {
            case "categoria teste" -> {
                seleniumUtils.selecionarDrodownIndex(By.id("category_id"), 1);
            }
            case "nova categoria" -> {
                seleniumUtils.selecionarDrodownIndex(By.id("category_id"), 2);
            }
            default -> throw new AssertionError();
        }
    }

    public void selecionarFrequencia(String opcao){
        switch (opcao) {
            case "sempre" -> {
                seleniumUtils.selecionarDrodownValor(By.id("reproducibility"), "10");
            }
            case "às vezes" -> {
                seleniumUtils.selecionarDrodownValor(By.id("reproducibility"), "30");
            }
            case "aleatório" -> {
                seleniumUtils.selecionarDrodownValor(By.id("reproducibility"), "50");
            }
            case "não se tentou" -> {
                seleniumUtils.selecionarDrodownValor(By.id("reproducibility"), "70");
            }
            case "incapaz de reproduzir" -> {
                seleniumUtils.selecionarDrodownValor(By.id("reproducibility"), "90");
            }
            case "N/D" -> {
                seleniumUtils.selecionarDrodownValor(By.id("reproducibility"), "100");
            }
            default -> throw new AssertionError();
        }
    }

    public void selecionarGravidade(String opcao){
        switch (opcao) {
            case "recurso" -> {
                seleniumUtils.selecionarDrodownValor(By.id("severity"), "10");
            }
            case "trivial" -> {
                seleniumUtils.selecionarDrodownValor(By.id("severity"), "20");
            }
            case "texto" -> {
                seleniumUtils.selecionarDrodownValor(By.id("severity"), "30");
            }
            case "mínimo" -> {
                seleniumUtils.selecionarDrodownValor(By.id("severity"), "40");
            }
            case "pequeno" -> {
                seleniumUtils.selecionarDrodownValor(By.id("severity"), "50");
            }
            case "grande" -> {
                seleniumUtils.selecionarDrodownValor(By.id("severity"), "60");
            }
            case "travamento" -> {
                seleniumUtils.selecionarDrodownValor(By.id("severity"), "70");
            }
            case "obstáculo" -> {
                seleniumUtils.selecionarDrodownValor(By.id("severity"), "80");
            }
            default -> throw new AssertionError();
        }
    }

    public void clicarExpandirSelecionarPerfil() {
        if (seleniumUtils.esperarWebElementoClicavel(By.id("os_build")) == false) {
            seleniumUtils.clicar(By.cssSelector("[class='fa fa-plus-square-o']"));
        }
    }

    public void clicarRecolherSelecionarPerfil() {
        if (seleniumUtils.esperarWebElementoClicavel(By.id("os_build")) == true) {
            seleniumUtils.clicar(By.cssSelector("[class='fa fa-minus-square-o']"));
        }
    }

    public void preencherPlataforma(String plataforma){
        
    }

    public void preencherSO(String plataforma){
        
    }

    public void preencherVersaoSO(String plataforma){
        
    }

    public void preencherResumo(String resumo){
        seleniumUtils.digiteTexto(By.id("summary"), resumo);
    }

    public void preencherDescricao(String descricao){
        seleniumUtils.digiteTexto(By.id("description"), descricao);
    }

    public void preencherPassosParaReproduzir(String passos){
        seleniumUtils.digiteTexto(By.id("steps_to_reproduce"), passos);
    }

    public void preencherInformacoesAdicionais(String informacoes){
        seleniumUtils.digiteTexto(By.id("additional_info"), informacoes);
    }

    public void preencherAplicarMarcadores(String marcadores){
        seleniumUtils.digiteTexto(By.id("tag_string"), marcadores);
    }

    public void selecionarMarcadoresAtuais(String marcador){
        switch (marcador) {
            case "Atividade" -> seleniumUtils.selecionarDrodownValor(By.id("tag_select"), "4");
            case "bug" -> seleniumUtils.selecionarDrodownValor(By.id("tag_select"), "9");
            case "Desenvolvimento" -> seleniumUtils.selecionarDrodownValor(By.id("tag_select"), "2");
            case "Grupo Vermelho" -> seleniumUtils.selecionarDrodownValor(By.id("tag_select"), "5");
            case "urgente" -> seleniumUtils.selecionarDrodownValor(By.id("tag_select"), "10");
            default -> throw new AssertionError();
        }
    }

    public void enviarArquivos(){
        seleniumUtils.enviarArquivo("src\\test\\resources\\attachments\\evidencia.png");
    }

    public void selecionarVisibilidade(String visibilidade){
        switch (visibilidade) {
            case "público" -> seleniumUtils.clicarBotaoJavaScript(By.xpath("//label[contains(.,'público')]"));
            case "privado" -> seleniumUtils.clicarBotaoJavaScript(By.xpath("//label[contains(.,'privado')]"));
            default -> throw new AssertionError();
        }
    }

    public void checkCriarMaisTarefas(){
    }

    public void clicarCriarNovaTarefa(){
        seleniumUtils.saveScreenshotPNG();
        seleniumUtils.clicar(By.cssSelector("[class='btn btn-primary btn-white btn-round']"));
    }

    public void visualizarMensagemDeSucesso(){
        try {
            seleniumUtils.esperarElementoVisivel(By.cssSelector("[class='alert alert-success center']"));
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
