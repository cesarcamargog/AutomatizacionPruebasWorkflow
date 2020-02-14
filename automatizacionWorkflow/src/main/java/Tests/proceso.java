package Tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import automatizacionWorkflow.Login;
import automatizacionWorkflow.Procesos;

public class proceso {
	WebDriver driver;
	Login teste;
	Procesos teste2;


	@Before
	public void setUp() throws Exception {
		 teste = new Login(driver);
		
			driver=teste.iniciar();
			teste.get("https://s4v2.solucionesdigitales.com.mx:8952/#!/login");
			 teste2 = new Procesos(driver);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() throws InterruptedException {
		teste.login();
		teste2.actualizar();
		teste2.eliminar();
	}

}
