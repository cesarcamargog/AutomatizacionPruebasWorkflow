package Tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import automatizacionWorkflow.Estructura;
import automatizacionWorkflow.Login;

public class Estructuras {
	WebDriver driver;
	Login teste;
	Estructura teste2;

	@Before
	public void setUp() throws Exception {
		 teste = new Login(driver);
			
			driver=teste.iniciar();
			teste.get("https://s4v2.solucionesdigitales.com.mx:8952/#!/login");
			 teste2 = new Estructura(driver);
	}

	@Test
	public void test() throws InterruptedException {
		teste.login();
		teste2.abrirmenu();
	}
	@After
	public void tearDown() throws Exception {
		driver.quit();
	}

}
