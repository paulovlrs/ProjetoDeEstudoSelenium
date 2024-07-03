package com.base2.Serialized;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import lombok.Data;

import java.io.FileReader;
import java.io.IOException;

@Data
public class ElementosPage {
    @Data
    public static class CriarTarefa{
        @SerializedName("id_selecionar_categoria")
        private String idSelecionarCategoria;
        @SerializedName("id_selecionar_frequencia")
        private String idSelecionarFrequencia;
        @SerializedName("id_selecionar_drodown_valor")
        private String idSelecionarDrodownValor;
        @SerializedName("cssSelector_botao_expasivel")
        private String cssSelectorBotaoExpasivel;
        @SerializedName("cssSelector_botao_reduzir")
        private String cssSelectorBotaoReduzir;
        @SerializedName("id_resumo")
        private String idResumo;
        @SerializedName("id_descricao")
        private String idDescricao;
        @SerializedName("id_passos_para_reproduzir")
        private String idPassosParaReproduzir;
        @SerializedName("id_informacoes_adicionais")
        private String idInformacoesAdicionais;
        @SerializedName("id_aplicar_marcadores")
        private String idAplicarMarcadores;
        @SerializedName("id_selecionar_marcadores_existente")
        private String idSelecionarMarcadoresExistente;
        @SerializedName("xpath_selecionar_visibilidade_publico")
        private String xpathSelecionarVisibilidadePublico;
        @SerializedName("xpath_selecionar_visibilidade_privado")
        private String xpathSelecionarVisibilidadePrivado;
        @SerializedName("cssSelector_visualizar_mensagem_de_Sucesso")
        private String cssSelectorVisualizarMensagemDeSucesso;
    }
    @Data
    public static class Home {
        @SerializedName("cssSelector_clicar_tarefa")
        private String cssSelectorClicarTarefa;
        @SerializedName("cssSelector_clicar_ver_tarefa")
        private String cssSelectorClicarVerTarefa;
        @SerializedName("cssSelector_clicar_minha_visao")
        private String cssSelectorClicarMinhaVisao;
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
    }
    @Data
    public static class VerTarefa {
        @SerializedName("id_anotacao")
        private String idAnotacao;
        @SerializedName("cssSelector_adicionar_anotacao")
        private String cssSelectorAdicionarAnotacao;
        @SerializedName("cssSelector_salva_retorna_id_tarefa_gerada")
        private String cssSelectorSalvaRetornaIdTarefaGerada;
    }

    @SerializedName("CriarTarefa")
    private CriarTarefa criarTarefa;
    @SerializedName("Home")
    private Home home;
    @SerializedName("Login")
    private Login login;
    @SerializedName("VerTarefa")
    private VerTarefa verTarefa;
    @SerializedName("local_path_arquivo")
    private String localPathArquivo;

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