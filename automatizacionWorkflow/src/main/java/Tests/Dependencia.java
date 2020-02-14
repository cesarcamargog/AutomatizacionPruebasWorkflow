package Tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import automatizacionWorkflow.Login;
import automatizacionWorkflow.dependencia;

public class Dependencia {

	WebDriver driver;
	Login teste;
	dependencia teste2;


	@Before
	public void setUp() throws Exception {
		 teste = new Login(driver);
		
			driver=teste.iniciar();
			teste.get("https://s4v2.solucionesdigitales.com.mx:8952/#!/login");
			teste2 = new dependencia(driver);
			 
	}
	@After
	public void tearDown() throws Exception {
		driver.quit();
	}

	@Test
	public void test() throws InterruptedException {
		teste.login();
		teste2.IngresarDependencia();
		teste2.actualizardependencia();
		teste2.Eliminardependencia();
	}

}
