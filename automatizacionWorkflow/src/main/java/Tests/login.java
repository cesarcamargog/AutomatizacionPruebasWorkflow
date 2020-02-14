package Tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import automatizacionWorkflow.Login;

public class login {
	WebDriver driver;
	Login teste;

	@Before
	public void setUp() throws Exception {
	 teste = new Login(driver);
		driver=teste.iniciar();
		teste.get("https://s4v2.solucionesdigitales.com.mx:8952/#!/login");
	}

	@Test
	public void test() throws InterruptedException {
		teste.login();

	}

	@After
	public void tearDown() throws Exception {
		if (teste.ingreso()) {
			System.out.println("se ah ingresado correctamente");
			System.out.println("El test login funciono correctamente");
		}else {
			System.out.println("ALgo fallo al intentar ingresar");
		}
		driver.quit();
	}
}
