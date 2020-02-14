package automatizacionWorkflow;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Procesos extends Base {
	WebElement elemento;
	List<WebElement> lista;
	By pro = By.xpath("//*[@id=\"ulSidebar\"]/li[7]/a/span");
	By np = By.xpath("//div/span/button[2]");
	By serie = By.name("serie");
	By nombre = By.name("nombre");
	By descripcion = By.name("descripcion");
	By dependendia = By.className("dependenciaId");
	By guardar = By.xpath("//div/div[2]/button");
	By ok = By.xpath("//div[5]/div/div[3]/button[1]");
	By todos = By.xpath("//div/div[1]/button[4]");
	By siguiente = By.linkText("Siguiente");
	By inactivos = By.xpath("//div/div[1]/button[3]");
	By guardados = By.xpath("//div[2]/div[1]/div/div[1]/button[1]");
	int g;

	public Procesos(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public void IngresarProceso() throws InterruptedException {
		click(pro);
		Thread.sleep(1000);
		click(np);
		Thread.sleep(1000);
		type("xxx", serie);
		Thread.sleep(1000);
		type("nombreprueba", nombre);
		Thread.sleep(1000);
		type("esta es solo una descripcion de prueba", descripcion);
		Thread.sleep(1000);
		elemento = findlocator(dependendia);
		lista = obtenerlista(elemento);
		for (int i = 0; i < lista.size() + 1; i++) {
			if (lista.get(i).getText().equals("PROTECCIÓN CIVIL")) {
				lista.get(i).click();
			}
		}
		Thread.sleep(1000);
		click(guardar);
		Thread.sleep(1000);
		click(ok);

	}

	public void actualizar() throws InterruptedException {
		click(pro);
		Thread.sleep(1000);
		click(todos);
		Thread.sleep(1000);
		do {
			lista = driver.findElements(By.xpath("//tbody/tr"));
			for (int i = 1; i < lista.size() + 1; i++) {
				if (driver.findElement(By.xpath("//tbody/tr[" + i + "]/td[1]")).getText().equals("f")) {
					Thread.sleep(1000);
					driver.findElement(By.xpath("//tbody/tr[" + i + "]/td[6]")).click();
					Thread.sleep(1000);
					limpiar(serie);
					Thread.sleep(1000);
					type("qwerty", serie);
					Thread.sleep(1000);
					limpiar(nombre);
					Thread.sleep(1000);
					type("nuevo nombre", nombre);
					Thread.sleep(1000);
					click(guardar);
					Thread.sleep(1000);
					click(ok);
					g = 1;
				}

			}
			if (g == 0) {
				click(siguiente);
			}
		} while (g == 0);

	}

	public void eliminar() throws InterruptedException {
		click(pro);
		Thread.sleep(1000);
		click(guardados);
		Thread.sleep(1000);
		do {
			lista = driver.findElements(By.xpath("//tbody/tr"));
			for (int i = 1; i < lista.size() + 1; i++) {
				if (driver.findElement(By.xpath("//tbody/tr[" + i + "]/td[1]")).getText().equals("qwerty")) {
					Thread.sleep(1000);
					driver.findElement(By.xpath("//tbody/tr[" + i + "]/td[8]")).click();
					Thread.sleep(1000);
					click(ok);
					g = 1;
				}

			}
			if (g == 0) {
				click(siguiente);
			}
		} while (g == 0);
		if(g==1) {
			click(inactivos);
			Thread.sleep(1000);
			do {
				lista = driver.findElements(By.xpath("//tbody/tr"));
				for (int i = 1; i < lista.size() + 1; i++) {
					if (driver.findElement(By.xpath("//tbody/tr[" + i + "]/td[1]")).getText().equals("qwerty")) {
						Thread.sleep(1000);
					System.out.println("Se elimino correctamente");
						g = 1;
					}

				}
				if (g == 0) {
					click(siguiente);
				}
			} while (g == 0);
		}
		
	}
}
