package Tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import com.mashape.unirest.http.exceptions.UnirestException;

import automatizacionWorkflow.Login;
import automatizacionWorkflow.Partner;

public class partner {
	WebDriver driver;
	Login teste;
	Partner teste2;

	@Before
	public void setUp() throws Exception {
	 teste = new Login(driver);
		driver=teste.iniciar();
		teste.get("https://s4v2.solucionesdigitales.com.mx:8952/#!/login");
		teste2 = new Partner(driver);
	}

	@Test
	public void test() throws InterruptedException, UnirestException {
		
		teste.login();
teste2.IngresarPartner();
	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
	}
}


