package cucumberJava;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.offset.PointOption;
import cucumber.api.java.en.Then;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import cucumber.api.java.en.And;


public class DefinicionPasos {
	
	public static WebDriver driver;
	
	public static String retornarCadena(String archivo) throws FileNotFoundException, IOException {
        
		String cadena;
		File miDir = new File (".");
        FileReader f = new FileReader(miDir.getCanonicalPath()+ "\\src\\test\\resources\\"+archivo);
        BufferedReader b = new BufferedReader(f);
        cadena = b.readLine();
        b.close();
        
        return cadena;
    }
	
	///////////////////////////
	//**** LOGIN EXITOSO ****//
	///////////////////////////
	
	@Given("^Que soy un usuario de la aplicacion de linkedin$")
	public void login_view() throws Throwable {
			
		DesiredCapabilities capabilities = new DesiredCapabilities();	
		capabilities.setCapability("deviceName", "My Phone");		 
		capabilities.setCapability("platformName", "Android");              
		capabilities.setCapability("appPackage", "com.google.android.gms");                 
		capabilities.setCapability("appActivity", "com.google.android.gms.auth.api.credentials.ui.CredentialPickerActivity");
		capabilities.setCapability("noReset", "true");

		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		 
		//Validar si el usuario se encuentra en la vista de perfil de usuario
		boolean usuario_logueado = driver.findElements(By.xpath("//android.widget.ImageView[@content-desc=\"Perfil\"]")).size() != 0;
		
		if (usuario_logueado)
			driver.findElement(By.xpath("//android.widget.ImageView[@content-desc=\"Perfil\"]")).click();
		
		//Validar si el usuario se encuentra en la vista home
		boolean vista_home = driver.findElements(By.xpath("//android.widget.ImageButton[@content-desc=\"Botón de menú de configuración\"]")).size() != 0;
		
		if (vista_home) {

			driver.findElement(By.xpath("//android.widget.ImageButton[@content-desc=\"Botón de menú de configuración\"]")).click();
			
			//Swipe hacia arriba
			TouchAction ts = new TouchAction((PerformsTouchActions)driver);
			ts.press(PointOption.point(0, 384)).moveTo(PointOption.point(0, 744)).release().perform();
			
			driver.findElement(By.xpath("//android.widget.TextView[@text=\"Cerrar sesión\"]")).click();
		}	
		
		Thread.sleep(5000);
		//Cerrar popup de credenciales guardadas en dispositivo real
		boolean sesiones_guardadas = driver.findElements(By.xpath("//android.widget.Button[@text=\"NINGUNA DE LAS OPCIONES ANTERIORES\"]")).size() != 0;

		if (sesiones_guardadas)
			driver.findElement(By.xpath("//android.widget.Button[@text=\"NINGUNA DE LAS OPCIONES ANTERIORES\"]")).click();
		
	}
	
	@When("^Ingreso mis correo y password correctamente$")
	public void credenciales_correctas() throws Throwable {
		
		String cadena = retornarCadena("datoscorrectos.txt");
		String[] credenciales = cadena.split(",");
		String usuario = credenciales[0];
		String pass = credenciales[1];
				
		driver.findElement(By.xpath("//android.widget.EditText[@text=\"Email\"]")).sendKeys(usuario);
		driver.findElement(By.xpath("//android.widget.EditText[@text=\"Contraseña\"]")).sendKeys(pass);
	}
	  
	@And("^Presiono el boton de iniciar sesion$")
	public void iniciar_sesion_correcto() throws Throwable {
		
		driver.findElement(By.xpath("//android.widget.Button[@text=\"INICIA SESIÓN\"]")).click();
		
		boolean existe_guardar_pass = driver.findElements(By.xpath("//android.widget.Button[@text=\"NUNCA\"]")).size() != 0;
		
		if (existe_guardar_pass)
			driver.findElement(By.xpath("//android.widget.Button[@text=\"NUNCA\"]")).click();		
	}
	  
	@Then("^Se realiza el login exitoso$")
	public void ingreso_correcto() throws Throwable {
		
		Thread.sleep(5000);
		driver.findElement(By.xpath("//android.widget.ImageView[@content-desc=\"Perfil\"]")).click();
		Thread.sleep(15000);
	}
	
	
	///////////////////////////
	//**** LOGIN ERRONEO ****//
	///////////////////////////
	
	@When("^Ingreso credenciales no registradas$")
	public void credenciales_incorrectas() throws Throwable {
			
		String cadena = retornarCadena("datosincorrectos.txt");
		String[] credenciales = cadena.split(",");
		String usuario = credenciales[0];
		String pass = credenciales[1];	
			
		driver.findElement(By.xpath("//android.widget.EditText[@text=\"Email\"]")).sendKeys(usuario);
		driver.findElement(By.xpath("//android.widget.EditText[@text=\"Contraseña\"]")).sendKeys(pass);
	 }
	  

	 @Then("^El sistema me indica que el usuario no esta registrado$")
	 public void validacion_incorrecto() throws Throwable {
		  
		driver.findElement(By.xpath("//android.widget.Button[@text=\"ACEPTAR\"]")).click();  
		  
	  }
}
