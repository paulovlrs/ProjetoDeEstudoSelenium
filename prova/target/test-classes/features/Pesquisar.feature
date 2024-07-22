Feature: Pesquisar

  Scenario: Pesquisar o manga "O rei dos cavaleiros que Retorna com um Deus"
    Given Que estou na tela principal
    When Pesquisar o nome do Manhwa ou manga
    And clicar no resultado da pesquisa
    Then Sou redirecionado para pagina com os capitulos