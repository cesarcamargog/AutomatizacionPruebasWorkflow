package Tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import com.mashape.unirest.http.exceptions.UnirestException;

import automatizacionWorkflow.Adjuntos;
import automatizacionWorkflow.Login;

public class adjunto {
	WebDriver driver;
	Login Teste;
	Adjuntos teste2;

	@Before
	public void setUp() throws Exception {
		Teste = new Login(driver);
		driver = Teste.iniciar();
		Teste.get("https://s4v2.solucionesdigitales.com.mx:8952/#!/login");
		teste2 = new Adjuntos(driver);

	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
	}

	@Test
	public void test() throws InterruptedException, UnirestException {
		Teste.login();
	teste2.ingresarAdjunto();
		teste2.actualizarAdjunto();
		teste2.eliminarAdjunto();
	}

}
