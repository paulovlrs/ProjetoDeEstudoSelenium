package com.Serialized;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import lombok.Data;

import java.io.FileReader;
import java.io.IOException;

@Data
public class ElementosPage {

    @Data
    public static class Home {
        @SerializedName("xpath_botao_login")
        private String xpathBotaoLogin;
        @SerializedName("cssSelector_botao_pesquisar_mangas")
        private String cssSelectorBotaoPesquisarMangas;
    }
    @Data
    public static class Login {
        @SerializedName("id_username")
        private String idUsername;
        @SerializedName("id_password")
        private String idPassword;
        @SerializedName("cssSelector_botao_entrar")
        private String cssSelectorBotaoEntrar;
        @SerializedName("valor_usuario")
        private String valorUsuario;
        @SerializedName("valor_senha")
        private String valorSenha;
        @SerializedName("cssSelector_modal_login")
        private String cssSelectorModalLogin;
    }
    @Data
    public static class Pesquisar {
        @SerializedName("cssSelector_campo_pesquisa")
        private String cssSelectorCampoPesquisa;
        @SerializedName("xpath_botao_pesquisar")
        private String xpathBotaoPesquisar;
        @SerializedName("valor_pesquisa_titulo-1")
        private String valorPesquisaTituloUm;
        @SerializedName("valor_pesquisa_titulo-2")
        private String valorPesquisaTituloDois;
        @SerializedName("valor_pesquisa_titulo-3")
        private String valorPesquisaTituloTres;
    }

    @Data
    public static class Obra{
        @SerializedName("cssSelector_div_informacao_obra")
        private String cssSelectorDivInformacaoObra;
        @SerializedName("cssSelector_div_capitulos")
        private String cssSelectorDivCapitulos;
        @SerializedName("cssSelector_iniciar_leitura")
        private String cssSelectorIniciarLeitura;
        @SerializedName("url_astral-pet-store")
        private String urlAstralPetStore;
        @SerializedName("url_o-rei-dos-cavaleiros-que-retorna-com-um-deus")
        private String urlOReiDosCavaleirosQueRetornaComUmDeus;
        @SerializedName("url_o-prodigio-cavaleiro-negro-em-condicao-terminal")
        private String url_OProdigioCavaleiroNegroEmCondicaoTerminal;
        @SerializedName("xpath_Capitulo_Atual")
        private String xpathCapituloAtual;
    }

    @Data
    public static class CaminhoDeDiretorios{
        @SerializedName("local_path_arquivo")
        private String localPathArquivo;
    }

    @SerializedName("Home")
    private Home home;
    @SerializedName("Login")
    private Login login;
    @SerializedName("Pesquisar")
    private Pesquisar pesquisar;
    @SerializedName("CaminhoDeDiretorios")
    private CaminhoDeDiretorios caminhoDeDiretorios;
    @SerializedName("Obra")
    private Obra obra;

    public static ElementosPage fromJson() {
        Gson gson = new Gson();
        try (FileReader reader = new FileReader("src/test/resources/json/ElementosPage.json")) {
            return gson.fromJson(reader, ElementosPage.class);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}