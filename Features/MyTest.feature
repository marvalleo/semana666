Feature: Pruebas de conexion a BD local y testeo del sitio con Selenium y Cucumber con la nomenclatura de Gherkin

Scenario: Conexion a MySql 3 : Sin datos
When Conectar como Username: "" y Password: "" a la base de datos MySql: ""

Scenario: Conexion a MySql 2 : Utilizando Username y Password
When Conectar como Username: "root" y Password: "root" a la base de datos MySql: ""

Scenario: Conexion a MySql 1 : Utilizando URL, Username y Password
When Conectar como Username: "root" y Password: "root" a la base de datos MySql: "jdbc:mysql://localhost:3306/banco_platinum"

Scenario: Caso 3: Ingresar valores vacíos.
Given Abrir navegador
When ingresa Username "" y Password "" 
Then inicia sesion
And Cerrar navegador

Scenario: Caso 2: Ingresar nombre de usuario y contraseña incorrecto.
Given Abrir navegador
When ingresa Username "userX" y Password "passX" 
Then inicia sesion
And Cerrar navegador

Scenario: Caso 1: Ingresar nombre de usuario y contraseña correctos.
Given Abrir navegador
When ingresa Username "user" y Password "pass" 
Then inicia sesion
