$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("cucumberJava.feature");
formatter.feature({
  "comments": [
    {
      "line": 1,
      "value": "#Author: your.email@your.domain.com"
    },
    {
      "line": 2,
      "value": "#Keywords Summary :"
    },
    {
      "line": 3,
      "value": "#Feature: List of scenarios."
    },
    {
      "line": 4,
      "value": "#Scenario: Business rule through list of steps with arguments."
    },
    {
      "line": 5,
      "value": "#Given: Some precondition step"
    },
    {
      "line": 6,
      "value": "#When: Some key actions"
    },
    {
      "line": 7,
      "value": "#Then: To observe outcomes or validation"
    },
    {
      "line": 8,
      "value": "#And,But: To enumerate more Given,When,Then steps"
    },
    {
      "line": 9,
      "value": "#Scenario Outline: List of steps for data-driven as an Examples and \u003cplaceholder\u003e"
    },
    {
      "line": 10,
      "value": "#Examples: Container for s table"
    },
    {
      "line": 11,
      "value": "#Background: List of steps run before each of the scenarios"
    },
    {
      "line": 12,
      "value": "#\"\"\" (Doc Strings)"
    },
    {
      "line": 13,
      "value": "#| (Data Tables)"
    },
    {
      "line": 14,
      "value": "#@ (Tags/Labels):To group Scenarios"
    },
    {
      "line": 15,
      "value": "#\u003c\u003e (placeholder)"
    },
    {
      "line": 16,
      "value": "#\"\""
    },
    {
      "line": 17,
      "value": "## (Comments)"
    },
    {
      "line": 18,
      "value": "#Sample Feature Definition Template"
    }
  ],
  "line": 20,
  "name": "Login en linkedin",
  "description": "Como usuario de linkedin\nDeseo ingresar a la plataforma, ingresar mis credenciales y presionar boton Iniciar sesion\nPara ingresar a la pagina de Linkedin",
  "id": "login-en-linkedin",
  "keyword": "Feature",
  "tags": [
    {
      "line": 19,
      "name": "@tag"
    }
  ]
});
formatter.scenario({
  "line": 26,
  "name": "Login con correo y password correctos",
  "description": "",
  "id": "login-en-linkedin;login-con-correo-y-password-correctos",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 25,
      "name": "@tag1"
    }
  ]
});
formatter.step({
  "line": 27,
  "name": "Que soy un usuario de la aplicacion de linkedin",
  "keyword": "Given "
});
formatter.step({
  "line": 28,
  "name": "Ingreso mis correo y password correctamente",
  "keyword": "When "
});
formatter.step({
  "line": 29,
  "name": "Presiono el boton de iniciar sesion",
  "keyword": "And "
});
formatter.step({
  "line": 30,
  "name": "Se realiza el login exitoso",
  "keyword": "Then "
});
formatter.match({
  "location": "DefinicionPasos.login_view()"
});
formatter.result({
  "duration": 22981001787,
  "status": "passed"
});
formatter.match({
  "location": "DefinicionPasos.credenciales_correctas()"
});
formatter.result({
  "duration": 12898389823,
  "status": "passed"
});
formatter.match({
  "location": "DefinicionPasos.iniciar_sesion_correcto()"
});
formatter.result({
  "duration": 6473896234,
  "status": "passed"
});
formatter.match({
  "location": "DefinicionPasos.ingreso_correcto()"
});
