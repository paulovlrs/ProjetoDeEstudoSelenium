# Prova Base2

## Projeto de Automação de Testes

Este projeto consiste em testes de automação utilizando Selenium WebDriver e Cucumber para verificar as funcionalidades de report de bug [mantis](https://mantis-prova.base2.com.br/

### Pré-requisitos

Certifique-se de ter o seguinte instalado em sua máquina:

- **Java Development Kit (JDK) 17**
- Maven
- Git
- Scoop

### Configuração do Ambiente

1. Clone este repositório:

	```bash
    git clone git@github.com:paulovlrs/ProvaBaseDois.git
	```


2. Instale o Allure Framework usando o Scoop:

    ```bash
    scoop install allure
    ```

## Gerando e Visualizando Relatórios

Para gerar e visualizar o relatório do Allure é necessário que tenha realizado a execução dos testes, acesse a pasta do projeto no terminal, execute os seguintes comandos:

1. Gere os resultados do Allure:

    ```bash
    allure serve
    ```

2. Isso abrirá uma página da web local com o relatório gerado.

Lembre-se de que é necessário ter o Java configurado corretamente na sua máquina, com a variável de ambiente `JAVA_HOME` apontando para a instalação do Java.

Este projeto utiliza o Cucumber para escrever cenários de teste em linguagem natural e o Selenium WebDriver para interagir com o navegador.

### Estrutura do Projeto

- **EditarTarefa.feature:** Testa a funcionalidade de editar um registro existente.
- **CriarTarefa.feature:** Testa a funcionalidade de criar um novo registro.

Cada feature possui cenários de teste escritos em Gherkin, e os passos dos cenários são implementados em Java nos pacotes `Steps` e `Pages`.

Observação: Certifique-se de que o ChromeDriver está no PATH do sistema ou ajuste o caminho no código conforme necessário.

# DÉBITO TÉCNICO

- **Implementação de serialização;**
- **Configurar o Allure Report para executar diretamente dentro do github**;
- **Utilziar o Framework Lombook para redução de tamanho de código**;
- **Definição de mais cenários para teste**;
	- Exemplos: 
		- Filtros de pesquisa;
		- Imprimir/Exportar dados;
		- Mudança de status da tarefa;
		- Segurança dos dados;