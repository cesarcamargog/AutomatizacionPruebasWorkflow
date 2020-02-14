package Tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import automatizacionWorkflow.Grupo;
import automatizacionWorkflow.Login;

public class grupos {
	WebDriver driver;
	Login teste;
	Grupo teste2;

	@Before
	public void setUp() throws Exception {
		teste = new Login(driver);
		driver = teste.iniciar();
		teste.get("https://s4v2.solucionesdigitales.com.mx:8952/#!/login");
		teste2 = new Grupo(driver);
	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
	}

	@Test
	public void test() throws InterruptedException {
		teste.login();
		teste2.abrirmenuG();
	}

}
