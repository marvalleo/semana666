package StepDefinition;

import java.sql.DriverManager;
import java.sql.Connection;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.java.en.And;

public class Steps {
	
	Connection connection;
	WebDriver driver;

	@Given("Abrir navegador")
	public void abrir_navegador() {

		System.out.println("Abre el navegador");
		System.out.println("Abre http://localhost:8081/BancoPlatinumLogin/faces/login.jsp");
		System.setProperty("webdriver.gecko.driver","D:\\01-Programacion\\Drivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		//driver.manage().window().maximize();
		driver.get("http://localhost:8081/BancoPlatinumLogin/faces/login.jsp");
	}

	@When("ingresa Username {string} y Password {string}")
	public void ingresa_Username_y_Password(String string, String string2) {
		
		System.out.println("Se ingresan las credenciales de usuario");
		driver.findElement(By.id("j_id_jsp_1391726837_1:userName")).sendKeys(string);
		driver.findElement(By.id("j_id_jsp_1391726837_1:password")).sendKeys(string2);

	}

	@Then("inicia sesion")
	public void inicia_sesion() {
	    
		System.out.println("Intenta iniciar sesion mediante el boton Login");
		driver.findElement(By.id("j_id_jsp_1391726837_1:btnLogin")).click();
		
	}
	
	
	@And("Cerrar navegador")
	public void cerrar_navegador() {
		System.out.println("Cerrar el navegador");
		driver.close();
	}
	
    @When("Conectar como Username: {string} y Password: {string} a la base de datos MySql: {string}") 
    public void conectarBD(String username,String password,String url) {

    	try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(url,username,password);
    		System.out.println("Conexion a BD exitosa DriverManager.getConnection = "+ connection);
    	}catch(Exception ex) {
    		System.out.println("Ocurrio una excepcion en el proceso, la Causa = " + ex.getCause() + "\nDriverManager.getConnection = "+ connection);
    	}
    	
    }

}
