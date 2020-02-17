package automatizacionWorkflow;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Campos extends Base {
	WebElement elemento;
	List<WebElement> lista;
	By campo = By.linkText("Campos");
	By NC = By.xpath("//div/span/button[2]");
	By nombre = By.id("txtNombreMostrar");
	By id = By.id("txtIdName");
	By tipo = By.id("cboTipo");
	By guardar = By.xpath("//div/div[3]/button[2]");
	By ok = By.xpath("//div[3]/button[1]");
	By verEliminado = By.id("swal2-content");
	By siguiente = By.linkText("Siguiente");
	String k;
	int f;

	public Campos(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public void nuevoCampo() throws InterruptedException {
		Thread.sleep(1000);
		click(campo);
		Thread.sleep(1000);
		click(NC);
		Thread.sleep(1000);
		type("nombre prueba", nombre);
		Thread.sleep(1000);
		type("nombre_p", id);
		elemento = driver.findElement(tipo);
		lista = elemento.findElements(By.tagName("option"));
		for (int i = 0; i < lista.size(); i++) {
			if (lista.get(i).getText().equals("TEXT BOX")) {
				lista.get(i).click();
			}
		}
		Thread.sleep(1000);
		click(guardar);
		Thread.sleep(2000);
		if (getText(verEliminado).equals("Campo Guardado Correctamente")) {
			Thread.sleep(1000);
			click(ok);
		}

	}

	public void actualizarCampo() throws InterruptedException {
		f=0;
		Thread.sleep(1000);
		click(campo);
		Thread.sleep(1000);
		do {
			lista = driver.findElements(By.xpath("//tbody/tr"));
			for (int i = 1; i < lista.size()+1; i++) {
				if (driver.findElement(By.xpath("//tbody/tr[" + i + "]/td")).getText().equals("nombre prueba")) {
					Thread.sleep(1000);
					driver.findElement(By.xpath("//tbody/tr[" + i + "]/td[4]/button")).click();
					Thread.sleep(1000);
					limpiar(nombre);
					Thread.sleep(1000);
					type("cambio de nombre", nombre);
					Thread.sleep(2000);
					click(guardar);
					Thread.sleep(2000);
					if (getText(verEliminado).equals("Campo Guardado Correctamente")) {
						Thread.sleep(1000);
						click(ok);
						f = 1;
					}

				}
			}
			if(f==0) {
				click(siguiente);
			}
		} while (f == 0);

	}

	public void eliminarCampo() throws InterruptedException {
f=0;
		click(campo);
		Thread.sleep(1000);
		do {
			lista = driver.findElements(By.xpath("//tbody/tr"));
			for (int i = 1; i < lista.size()+1; i++) {
				if (driver.findElement(By.xpath("//tbody/tr[" + i + "]/td")).getText().equals("cambio de nombre")) {
					Thread.sleep(1000);
					driver.findElement(By.xpath("//tbody/tr[" + i + "]/td[5]/button")).click();
					Thread.sleep(1000);
					if (getText(verEliminado).equals("Campo ELIMINADO Correctamente")) {
						Thread.sleep(1000);
						click(ok);
						f = 1;
					}

				}
			}
			if(f==0) {
				click(siguiente);
			}
		} while (f == 0);
	}
}
