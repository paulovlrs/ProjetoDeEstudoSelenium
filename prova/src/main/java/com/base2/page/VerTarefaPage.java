package com.base2.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.base2.utils.SeleniumUtils;

public class VerTarefaPage {

    private SeleniumUtils seleniumUtils;
    private String idGeradoAtualmente;

    public VerTarefaPage(WebDriver driver) {
        this.seleniumUtils = new SeleniumUtils(driver);
    }

    public void preencherAnotacao(String anotacao){
        seleniumUtils.digiteTexto(By.id("bugnote_text"), anotacao);
    }

    public void enviarArquivos(){
        seleniumUtils.enviarArquivo("src\\test\\resources\\attachments\\evidencia.png");
    }

    public void clicarAdicionarAnotacao(){
        seleniumUtils.clicar(By.cssSelector("[class='btn btn-primary btn-white btn-round']"));
    }

    public void verificarSeMensagemFoiSalva(String pesquisar){
        if(seleniumUtils.mensagemSpam() == false) {
            seleniumUtils.saveScreenshotPNG();
            seleniumUtils.esperarElementoVisivel(By.xpath("//tr[contains(.,'" + pesquisar + "')]"));
        }
       else{
            seleniumUtils.saveScreenshotPNG();
            seleniumUtils.mensagemDeFalhaStep("Você atingiu o limite permitido de atividade de 10 nos últimos 3600 segundos, suas ações foram bloqueados para evitar spam");
        }
    }

    public String salvaRetornaIdTarefaGerada(){
        idGeradoAtualmente = seleniumUtils.retornarValorElemento(By.cssSelector("[class='bug-id']"));
        return idGeradoAtualmente;
    }

    public String retornarIdDaUltimaTarefaCriada(){
        return idGeradoAtualmente;
    }

    public void clicarTarefaEspecifica(String idTarefa){
        seleniumUtils.clicar(By.xpath("//td[@class='column-id' and contains(.,'" + idTarefa + "')]"));
    }

    public void verificarComentarioExiste(String comentario) {
        seleniumUtils.esperarElementoVisivel(By.xpath("//td[@class='bugnote-note bugnote-public' and contains(.,'" + comentario + "')]"));
        seleniumUtils.saveScreenshotPNG();
    }
}
