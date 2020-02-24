package automatizacionWorkflow;

import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.mashape.unirest.http.exceptions.UnirestException;

public class Grupo extends Base {
	Login t;
	WebElement element;
	List<WebElement> lista, options, options2;
	By menu = By.xpath("//*[@id=\"ulSidebar\"]/li[4]/ul");
	By grup = By.linkText("Grupo");
	By G = By.xpath("//*[@id=\"ulSidebar\"]/li[4]/ul/li[1]/a/span");
	By NG = By.xpath("//span/button[2]");
	By nombre = By.name("nombre");
	By guardar = By.xpath("//div[2]/div/button");
	By ok = By.xpath("//div[3]/button[1]");
	By GE = By.xpath("//*[@id=\"ulSidebar\"]/li[4]/ul/li[3]/a/span");
	By logo = By.name("logo");
	By NombreC = By.name("nombreComercial");
	By RS = By.name("razonSocial");
	By GS = By.xpath("//*[@id=\"ulSidebar\"]/li[4]/ul/li[2]/a/span");
	By SelectG = By.name("grupo");
	String r;
ErrorJira j;
	int grupo, grupo1;
	NombresPruebas gp;
	String[][] grupos;

	public Grupo(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public void abrirmenuG() throws InterruptedException, UnirestException {
	
		Thread.sleep(2000);
		if (!isdisplayed(menu)) {
			click(grup);
		}
		Thread.sleep(1000);
		Random x = new Random();
		grupo = x.nextInt(4);
		Random z = new Random();
		grupo1 = z.nextInt(4);
		gp = new NombresPruebas();
		grupos = gp.setgrupos();
		
		Thread.sleep(2000);
		for (int i = 1; i < 4; i++) {
			IG(i);
		}
		for (int i = 1; i < 4; i++) {
			actualizarGrupos(i);
		}
		for (int i = 1; i < 4; i++) {
			EliminarGrupos(i);
		}
		
		
	}

	public void IG(int f) throws InterruptedException, UnirestException {

	try {
		Thread.sleep(1000);
		switch (f) {
		case 1:
			Thread.sleep(1000);
			click(G);
			Thread.sleep(1000);
			click(NG);
			Thread.sleep(1000);
			type(grupos[grupo][0], nombre);
			r="grupo";
			break;
		case 2:
			click(GE);
			Thread.sleep(1000);
			click(NG);
			Thread.sleep(1000);
			type(grupos[grupo][1], logo);
			Thread.sleep(500);
			type(grupos[grupo][1], NombreC);
			Thread.sleep(500);
			type("privada", RS);
			Thread.sleep(500);
			element = driver.findElement(By.name("grupo"));

			options = element.findElements(By.tagName("option"));
			for (int i = 0; i < options.size(); i++) {
				if (options.get(i).getText().equals(grupos[grupo][0])) {
					options.get(i).click();

				}
			}
			r="grupo empresa";
			break;
		case 3:
			click(GS);
			Thread.sleep(1000);
			click(NG);
			Thread.sleep(1000);
			type(grupos[grupo][2], NombreC);
			element = driver.findElement(By.name("grupoEmpresa"));
			element.click();
			Thread.sleep(1000);
			options2 = element.findElements(By.tagName("option"));
			for (int i = 0; i < options2.size(); i++) {
				if (options2.get(i).getText().equals(grupos[grupo][1])) {
					options2.get(i).click();
				}
			}
		
			Thread.sleep(1000);
			r="grupo Sucursal";
			break;
		}
		click(guardar);
		Thread.sleep(2000);
		click(ok);
		System.out.println("se ingreso correctamente el "+r);
	}catch (Exception e) {
DefinirError.getException(ErrorLog(e), this.getClass().toString(), "IG");

	}
		
	}

	public void actualizarGrupos(int f) throws InterruptedException, UnirestException {
		try {
			Thread.sleep(2000);
			switch (f) {
			case 1:
				Thread.sleep(1000);
				click(G);
				Thread.sleep(1000);
				lista = driver.findElements(By.xpath("//tbody/tr"));
				for (int i = 1; i < lista.size()+1; i++) {
					if (driver.findElement(By.xpath("//tbody/tr[" + i + "]/td[2]")).getText().equals(grupos[grupo][0])) {
						
						Thread.sleep(1000);
						driver.findElement(By.xpath("//tbody/tr[" + i + "]/td[3]/button")).click();
						Thread.sleep(1000);
						limpiar(nombre);
						Thread.sleep(1000);
						type(grupos[grupo1][0], nombre);
						Thread.sleep(1000);
						click(guardar);
						Thread.sleep(2000);
						click(ok);
						System.out.println("se actualizo correctamente el grupo");
					}
				}
				break;
			case 2:
				Thread.sleep(1000);
				click(GE);
				Thread.sleep(1000);
				lista = driver.findElements(By.xpath("//tbody/tr"));
				for (int i = 1; i < lista.size() + 1; i++) {
					if (driver.findElement(By.xpath("//tbody/tr[" + i + "]/td[2]")).getText().equals(grupos[grupo][1])) {
						driver.findElement(By.xpath("//tbody/tr[" + i + "]/td[6]/button")).click();
						Thread.sleep(1000);
						limpiar(logo);
						Thread.sleep(1000);
						type(grupos[grupo1][1], logo);
						Thread.sleep(1000);
						limpiar(NombreC);
						Thread.sleep(1000);
						type(grupos[grupo1][1], NombreC);
						Thread.sleep(1000);
						click(guardar);
						Thread.sleep(2000);
						click(ok);
						System.out.println("se actualizo correctamente el grupo Empresa");
					}
				}
				break;
			case 3:
				Thread.sleep(1000);
				click(GS);
				Thread.sleep(1000);
				lista = driver.findElements(By.xpath("//tbody/tr"));
				for (int i = 1; i < lista.size() + 1; i++) {
					if (driver.findElement(By.xpath("//tbody/tr[" + i + "]/td[2]")).getText().equals(grupos[grupo][2])) {
						driver.findElement(By.xpath("//tbody/tr[" + i + "]/td[4]/button")).click();
						Thread.sleep(1000);
						limpiar(NombreC);
						Thread.sleep(500);
						type(grupos[grupo1][2], NombreC);
						Thread.sleep(1000);
						click(guardar);
						Thread.sleep(2000);
						click(ok);
						System.out.println("se actualizo correctamente el grupo Sucursal");
					}
				}
				break;
			}
			
		}catch (Exception e) {
			DefinirError.getException(ErrorLog(e), this.getClass().toString(), "actualizarGrupo");

				}
		

	}
public void EliminarGrupos(int f) throws InterruptedException, UnirestException {
try {
	Thread.sleep(2000);
	switch (f) {
	case 3:
		Thread.sleep(1000);
		click(G);
		Thread.sleep(1000);
		lista = driver.findElements(By.xpath("//tbody/tr"));
		for (int i = 1; i < lista.size()+1; i++) {
			if (driver.findElement(By.xpath("//tbody/tr[" + i + "]/td[2]")).getText().equals(grupos[grupo1][0])) {
				
				Thread.sleep(1000);
				driver.findElement(By.xpath("//tbody/tr[" + i + "]/td[4]/button")).click();
				Thread.sleep(1000);
				click(ok);
				System.out.println("se elimino correctamente el grupo");
			}
		}
		break;
	case 2:
		Thread.sleep(1000);
		click(GE);
		Thread.sleep(1000);
		lista = driver.findElements(By.xpath("//tbody/tr"));
		for (int i = 1; i < lista.size() + 1; i++) {
			if (driver.findElement(By.xpath("//tbody/tr[" + i + "]/td[2]")).getText().equals(grupos[grupo1][1])) {
				driver.findElement(By.xpath("//tbody/tr[" + i + "]/td[7]/button")).click();
				Thread.sleep(1000);
				click(ok);
				System.out.println("se elimino correctamente el grupo Empresa");
			}
		}
		break;
	case 1:
		Thread.sleep(1000);
		click(GS);
		Thread.sleep(1000);
		lista = driver.findElements(By.xpath("//tbody/tr"));
		for (int i = 1; i < lista.size() + 1; i++) {
			if (driver.findElement(By.xpath("//tbody/tr[" + i + "]/td[2]")).getText().equals(grupos[grupo1][2])) {
				driver.findElement(By.xpath("//tbody/tr[" + i + "]/td[5]/button")).click();
				Thread.sleep(1000);
				click(ok);
				System.out.println("se elimino correctamente el grupo Sucursal");
			}
		}
		break;
	}
}catch (Exception e) {
DefinirError.getException(ErrorLog(e), this.getClass().toString(), "EliminarGrupos");

}
	
}

public int setgrup() {
	return grupo;
}
}
