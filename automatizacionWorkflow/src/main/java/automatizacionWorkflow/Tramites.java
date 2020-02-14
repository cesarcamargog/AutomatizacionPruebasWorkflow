package automatizacionWorkflow;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Tramites extends Base {
	WebElement elemento;
	List<WebElement> lista;
	String f,fol;
	int x;
	By tram = By.linkText("Tramites");
	By siguiente = By.linkText("Siguiente");
	By nombreP = By.id("InputFieldA");
	By apellidoP = By.id("InputFieldB");
	By apellido2P = By.id("InputFieldC");
	By buscar = By.xpath("//div/div[4]/button");
	By si = By.xpath("//div[3]/button[1]");
	By ok = By.xpath("//button/h5");
	By N = By.id("form3");
	By AP = By.id("form1");
	By AM= By.id("form2");
	By escritura = By.name("file1");
	By predio = By.id("file2");
	By aceptar = By.xpath("//fieldset/div/div[5]/button[2]");
	By Reporte = By.linkText("Reporte General");
	By folio = By.cssSelector("#informacion > table > tbody > tr:nth-child(1) > td");
	By finalizar = By.cssSelector("#example-vertical > div.actions.clearfix.ng-scope > ul > li:nth-child(2) > a");
	public Tramites(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public void nuevoTramite() throws InterruptedException {
		click(tram);
		Thread.sleep(1000);
		do {
			lista = driver.findElements(By.xpath("//section/div/div/div/a[1]"));
			for (int i = 1; i < lista.size() + 1; i++) {
				f = driver.findElement(By.xpath("//section/div/div[" + i + "]/div/a[1]/div/h3")).getText();
				if (f.equals("PRUEBA")) {
					driver.findElement(By.xpath("//section/div/div[" + i + "]/div/a[1]")).click();
					Thread.sleep(1000);
					type("x", nombreP);
					Thread.sleep(1000);
					click(buscar);
					Thread.sleep(1000);
					driver.findElement(By.xpath("//div[3]/div/div/table/tbody/tr[4]")).click();
					Thread.sleep(1000);
					click(si);
					Thread.sleep(2000);
					click(ok);
					Thread.sleep(1000);
					llenarTramite();
					fol =getText(folio);
					Thread.sleep(1000);
					type("xxx", N);
					Thread.sleep(1000);
					type("dcx", AM);
					Thread.sleep(1000);
					type("qweqwe", AP);
					Thread.sleep(1000);
					click(siguiente);
					Thread.sleep(1000);
					click(aceptar);
					Thread.sleep(1000);
					click(si);
					Thread.sleep(2000);
					type("C:\\Users\\Desarrollo\\Desktop\\escrituraRegistrada.pdf", escritura);
					Thread.sleep(2000);
					type("C:\\Users\\Desarrollo\\Desktop\\PagoPredial.pdf", predio);
					Thread.sleep(1000);
					click(siguiente);
					Thread.sleep(1000);
					type("C:\\Users\\Desarrollo\\Desktop\\escrituraRegistrada.pdf", escritura);
					Thread.sleep(2000);
					type("C:\\Users\\Desarrollo\\Desktop\\PagoPredial.pdf", predio);
					Thread.sleep(2000);
					click(finalizar);
					
					
					x = 1;
				}
			}
			if (x == 0) {
				click(siguiente);
			}
		} while (x == 0);

	}

	public void llenarTramite() throws InterruptedException {
		
	}
}
