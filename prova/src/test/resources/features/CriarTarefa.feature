Feature: CriarTarefa

    Scenario: Criar tarefa
        Given que estou na tela principal
        When clicar em Criar Tarefa
        And preencher todos os campos
        Then a tarefa sera salva na tela de Ver Tarefas