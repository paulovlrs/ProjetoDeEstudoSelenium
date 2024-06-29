Feature: EditarTarefa

 Scenario Outline: Adicionar Comentário na tarefa
    Given que estou na tela de Ver Tarefa
    When clicar no codigo da Tarefa
    And preencho uma anotacao "<comentario>"
    And adiciono um arquivo
    And clico no botao de Adicionar Anotacao
    Then a tarefa salva a anotacao "<comentario>"

   Examples:
     | comentario                   |
     | Bug acontece todo santo dia  |