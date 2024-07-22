Feature: LerObra

  Scenario: Quero Ler o primeiro capitulo
    Given Que estou na pagina da obra "O rei dos cavaleiros que Retorna com um Deus"
    When clicar em iniciar leitura
    Then Acesso o primeiro capitulo da obra

