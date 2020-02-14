package Tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import automatizacionWorkflow.Estructura;
import automatizacionWorkflow.Grupo;
import automatizacionWorkflow.Login;
import automatizacionWorkflow.Partner;
import automatizacionWorkflow.dependencia;

public class alltests {
	WebDriver driver;
	Login teste;
	Partner teste2;
	Grupo teste3;
	Estructura teste4;
	dependencia teste5;

	@Before
	public void setUp() throws Exception {
		teste = new Login(driver);

		driver = teste.iniciar();
		teste.get("https://s4v2.solucionesdigitales.com.mx:8952/#!/login");
		teste2 = new Partner(driver);
		teste3 = new Grupo(driver);
		teste4 = new Estructura(driver);
		teste5 = new dependencia(driver);
	}

	@Test
	public void test() throws InterruptedException {
		try {
			teste.login();
			teste2.IngresarPartner();
			teste3.abrirmenuG();
			teste4.abrirmenu();
		} catch (Exception e) {
			System.out.println(e);
		}
		

	}

	@After
	public void tearDown() throws Exception {
	}

}
