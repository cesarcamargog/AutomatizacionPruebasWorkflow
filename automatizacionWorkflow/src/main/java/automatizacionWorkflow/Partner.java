package automatizacionWorkflow;

import java.util.List;
import java.util.Random;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Partner extends Base {
	By menu = By.cssSelector("#ulSidebar > li:nth-child(3) > ul");
	By partner = By.linkText("Partner");
	By ciudadano = By.xpath("//ul[@id='ulSidebar']/li[3]/ul/li/a/span");
	By operador = By.cssSelector("#ulSidebar > li.treeview.menu-open > ul > li:nth-child(2) > a > span");
	By funcionario = By.cssSelector("#ulSidebar > li.treeview.menu-open > ul > li:nth-child(3) > a > span");
	By locatorPartner = By.xpath("//div/div[1]/h3");
	By NP = By.xpath("//span/button[2]");
	By numero = By.id("txtnumero");
	By identificador = By.id("txtidentificador");
	By personafisica = By.id("txtpersonaFisica");
	By razonsocial = By.id("txtrazonSocial");
	By nombreC = By.id("txtnombreComercial");
	By nombre = By.id("txtnombre");
	By apellidop = By.id("txtapellidoPaterno");
	By apellidom = By.id("txtapellidoMaterno");
	By FN = By.id("txtfechaNacimiento");
	By rfc = By.id("txtrfc");
	By curp = By.id("txtcurp");
	By LC = By.id("txtlimiteCredito");
	By DC = By.id("txtdiasCredito");
	By Ce = By.id("txtcorreoElectronico");
	By tel = By.id("txttelefono");
	By precaptura = By.id("txtprecaptura");
	By activo = By.id("txtactivo");
	By alerta = By.id("txtalerta");
	By usuario = By.id("txtUser");
	By pass = By.id("txtPassword");
	By guardar = By.xpath("//div/button[2]");
	By ok = By.xpath("//div[3]/button[1]");
	By tittle = By.xpath("//*[@id=\"swal2-title\"]");
	By confirmar = By.xpath("//div[3]/button[1]");
	By verEliminado = By.id("swal2-content");
	WebElement element;
	List<WebElement> lista;
	String[][] valores;
	NombresPruebas x;
	int valorDado,g,us1;

	String n, ap, am,k;


	public Partner(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public void IngresarPartner() throws InterruptedException {
		Thread.sleep(1000);
		if (!isdisplayed(menu)) {
			click(partner);
		}
		Thread.sleep(1000);
		for (int i = 1; i < 4; i++) {
			IC(i);
			actualizarpartner(i);
			eliminarPartner(i);
		}
	}

	public void IC(int f) throws InterruptedException {
		g=0;
		try {
			Thread.sleep(1000);
			x = new NombresPruebas();
			switch (f) {
			case 1:
				click(ciudadano);
				Thread.sleep(1000);
				break;
			case 2:
				click(operador);
				Thread.sleep(1000);
				break;
			case 3:
				click(funcionario);
				Thread.sleep(1000);
				break;

			}

			click(NP);
			Thread.sleep(2000);
			valores = x.setPartner();
			int valorEntero = (int) Math.floor(Math.random() * (100 - 10 + 1) + 10);
			type(String.valueOf(valorEntero), numero);
			Random z = new Random();
			valorDado = z.nextInt(4);
			Thread.sleep(500);
			type("1", identificador);
			Thread.sleep(500);
			type("1", personafisica);
			Thread.sleep(500);
			type("1", razonsocial);
			Thread.sleep(500);
			type("conocido", nombreC);
			Thread.sleep(500);
			type(valores[valorDado][0], nombre);
			Thread.sleep(500);
			type(valores[valorDado][1], apellidop);
			Thread.sleep(500);
			type(valores[valorDado][2], apellidom);
			Thread.sleep(500);
			type(valores[valorDado][3], FN);
			Thread.sleep(500);
			type(valores[valorDado][4], rfc);
			Thread.sleep(500);
			type(valores[valorDado][4], curp);
			Thread.sleep(500);
			type("10000000", LC);
			Thread.sleep(500);
			type("30", DC);
			Thread.sleep(500);
			type(valores[valorDado][0] + valores[valorDado][valorDado] + "@hotmail.com", Ce);
			Thread.sleep(500);
			type("5423982039", tel);
			Thread.sleep(500);;
			type("1", precaptura);
			Thread.sleep(500);
			type("1", activo);
			Thread.sleep(500);
			type("1", alerta);
			Thread.sleep(500);
			us1 = (int) Math.floor(Math.random())*6;
			type(valores[valorDado][us1]+valorEntero, usuario);
			Thread.sleep(500);
			type(valores[valorDado][5], pass);
			element = driver.findElement(By.name("cboRol"));
			Thread.sleep(500);
			List<WebElement> options = element.findElements(By.tagName("option"));
			switch (f) {
			case 1:
				for (int i = 0; i < options.size(); i++) {
					if (options.get(i).getText().equalsIgnoreCase("ciudadano")) {
						options.get(i).click();
					}
				}
				break;
			case 2:
				for (int i = 0; i < options.size(); i++) {
					if (options.get(i).getText().equalsIgnoreCase("operador")) {
						options.get(i).click();
					}
				}
				break;
			case 3:
				for (int i = 0; i < options.size(); i++) {
					if (options.get(i).getText().equalsIgnoreCase("Funcionario")) {
						options.get(i).click();
					}
				}
				break;

			}
			Thread.sleep(1000);
			click(guardar);
			Thread.sleep(2000);
			if (getText(tittle).equals("Correcto")) {
				click(ok);
				Thread.sleep(1000);
			}else {
				
			}
		}catch(Exception e) {
			
		}
		
		
	}

	public void eliminarPartner(int f) throws InterruptedException {
		switch (f) {
		case 1:
			click(ciudadano);
			Thread.sleep(1000);
			break;
		case 2:
			Thread.sleep(1000);
			click(operador);
			Thread.sleep(1000);
			break;
		case 3:
			Thread.sleep(1000);
			click(funcionario);
			Thread.sleep(1000);
			break;

		}
		Thread.sleep(2000);
		lista = driver.findElements(By.xpath("//tbody/tr"));
		Thread.sleep(1000);
		do {
			for (int i = 1; i < lista.size() + 1; i++) {
				if (driver.findElement(By.xpath("//tbody/tr[" + i + "]/td[1]")).getText()
						.equalsIgnoreCase(valores[valorDado][0])) {
					if (driver.findElement(By.xpath("//tbody/tr[" + i + "]/td[2]")).getText()
							.equalsIgnoreCase(valores[valorDado][1])) {
						if (driver.findElement(By.xpath("//tbody/tr[" + i + "]/td[3]")).getText()
								.equalsIgnoreCase(valores[valorDado][2])) {
							driver.findElement(By.xpath("//tbody/tr[" + i + "]/td[5]/button")).click();
							Thread.sleep(2000);
							click(confirmar);
							Thread.sleep(2000);
							k = getText(verEliminado);
							if(k.equals("PARTNER ELIMINADO Correctamente")) {
								click(ok);
								System.out.println("Se elimino correctamente");
								g = 1;
							}
						
							
							break;
						}
					}
				}

			}
			if (g == 0) {
				driver.findElement(By.linkText("Siguiente")).click();
			}
		} while (g == 0);
		
		
		
		
		
		
	}//---------------eliminar partner-------------------
public void actualizarpartner(int f) throws InterruptedException{
	Thread.sleep(2000);
	switch (f) {
	case 1:
		click(ciudadano);
		Thread.sleep(1000);
		break;
	case 2:
		click(operador);
		Thread.sleep(1000);
		break;
	case 3:
		click(funcionario);
		Thread.sleep(1000);
		break;

	}
	Thread.sleep(2000);
	int y = 0;
	System.out.println("buscando al partner: " + valores[valorDado][0] + " " + valores[valorDado][1] + " "
			+ valores[valorDado][2]);
	Thread.sleep(2000);

	lista = driver.findElements(By.xpath("//tbody/tr"));
	do {
		for (int i = 1; i < lista.size() + 1; i++) {
		
			if (driver.findElement(By.xpath("//tbody/tr[" + i + "]/td[1]")).getText()
					.equals(valores[valorDado][0])) {

				Thread.sleep(1000);
				if (driver.findElement(By.xpath("//tbody/tr[" + i + "]/td[2]")).getText()
						.equals(valores[valorDado][1])) {
					Thread.sleep(1000);
					if (driver.findElement(By.xpath("//tbody/tr[" + i + "]/td[3]")).getText()
							.equals(valores[valorDado][2])) {
						Thread.sleep(1000);
						driver.findElement(By.xpath("//tbody/tr[" + i + "]/td[4]/button")).click();
						Thread.sleep(2000);
					type("19091998", FN);
						Thread.sleep(2000);
						type("UsuarioCambiado", usuario);
						Thread.sleep(2000);
						click(guardar);
						Thread.sleep(2000);
						click(ok);
						
						y = 1;
						break;
					}
				}
			}

		}
		if (y == 0) {
			driver.findElement(By.linkText("Siguiente")).click();
		}
	} while (y == 0);
	System.out.println("Se actualizo correctamente");
	Thread.sleep(2000);

}
	
	
}//------------------------------------------------------------------------------------