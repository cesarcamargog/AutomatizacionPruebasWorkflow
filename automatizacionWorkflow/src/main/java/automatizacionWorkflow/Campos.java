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
	String k;

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

		click(ok);
		System.out.println("Se elimino correctamente");

	}

	public void actualizarCampo() throws InterruptedException {
		Thread.sleep(1000);
		click(campo);
		Thread.sleep(1000);
		click(guardar);

		click(ok);
		System.out.println("Se elimino correctamente");

	}

}
