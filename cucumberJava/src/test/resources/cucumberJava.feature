#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
@tag
Feature: Login en linkedin
  Como usuario de linkedin
  Deseo ingresar a la plataforma, ingresar mis credenciales y presionar boton Iniciar sesion
  Para ingresar a la pagina de Linkedin

  @tag1
  Scenario: Login con correo y password correctos	
    Given Que soy un usuario de la aplicacion de linkedin
    When Ingreso mis correo y password correctamente
    And Presiono el boton de iniciar sesion
    Then Se realiza el login exitoso

  @tag2
  Scenario: Login con correo no registrado
    Given Que soy un usuario de la aplicacion de linkedin
    When Ingreso credenciales no registradas
    And Presiono el boton de iniciar sesion
    Then El sistema me indica que el usuario no esta registrado