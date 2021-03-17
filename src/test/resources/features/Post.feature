
 # Funcionalidade: Consulta
  #  Cenario: Consultar Ovo de Pascoa
   #   Dado que acesso a Wikipedia em Portugues
    #  Quando pesquiso por "Ovo de Páscoa"
     # Entao Exibe a expressão "Ovo de Páscoa" no titulo da guia

Feature: Consulta
  Scenario: Consultar Ovo de Pascoa
    Given que acesso a Wikipedia em Portugues
    When pesquiso por "Ovo de Páscoa"
    Then Exibe a expressão "Ovo de Páscoa" no titulo da guia