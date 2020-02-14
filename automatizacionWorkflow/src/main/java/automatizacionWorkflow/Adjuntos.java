package automatizacionWorkflow;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Adjuntos extends Base {
	WebElement elemento;
	List<WebElement> lista;
	String f;
	int x;
	By adj = By.linkText("Categorias Adjuntos");
	By NA = By.xpath("//span/button[2]");
	By nombre = By.name("nombre");
	By desc = By.name("descripcion");
	By ext = By.name("extensionAceptada");
	By guardar = By.xpath("//div[2]/div/button");
	By ok = By.xpath("//div[3]/button[1]");
	By siguiente = By.linkText("Siguiente");

	public Adjuntos(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public void ingresarAdjunto() {
		try {
			click(adj);
			Thread.sleep(1000);
			click(NA);
			Thread.sleep(1000);
			limpiar(nombre);
			type("nombre prueba", nombre);
			Thread.sleep(1000);
			type("descripcion de prueba de documento", desc);
			Thread.sleep(1000);
			type("Aplicattion/pdf", ext);
			Thread.sleep(1000);
			click(guardar);
			Thread.sleep(1000);
			click(ok);
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public void actualizarAdjunto() throws InterruptedException {
		Thread.sleep(1000);
		click(adj);
		Thread.sleep(1000);
		do {
			lista = driver.findElements(By.xpath("//tbody/tr"));
			for (int i = 1; i < lista.size() + 1; i++) {
				Thread.sleep(1000);
				f = driver.findElement(By.xpath("//tbody/tr[" + i + "]/td[1]")).getText();
				System.out.println(f);
				if (f.equals("nombre prueba")) {
					driver.findElement(By.xpath("//tbody/tr[" + i + "]/td[4]//button")).click();
					Thread.sleep(1000);
					limpiar(nombre);
					Thread.sleep(1000);
					type("Cambio de nombre", nombre);
					Thread.sleep(1000);
					limpiar(desc);
					Thread.sleep(1000);
					type("cambo de descripcion de prueba", desc);
					Thread.sleep(1000);
					limpiar(ext);
					Thread.sleep(1000);
					type("aplicattion/xml", ext);
					Thread.sleep(1000);
					click(guardar);
					Thread.sleep(1000);
					click(ok);
					x = 1;
				}
			}
			if (x == 0) {
				click(siguiente);
			}
		} while (x == 0);

	}

	public void eliminarAdjunto() throws InterruptedException {
Thread.sleep(1000);
click(adj);
Thread.sleep(1000);
do {
	lista = driver.findElements(By.xpath("//tbody/tr"));
	for (int i = 1; i < lista.size() + 1; i++) {
		Thread.sleep(1000);
		f = driver.findElement(By.xpath("//tbody/tr[" + i + "]/td[1]")).getText();
		System.out.println(f);
		if (f.equals("Cambio de nombre")) {
			driver.findElement(By.xpath("//tbody/tr[" + i + "]/td[5]/div/div/button")).click();
			Thread.sleep(1000);
			click(ok);
			x = 1;
		}
	}
	if (x == 0) {
		click(siguiente);
	}
} while (x == 0);
	}
}
