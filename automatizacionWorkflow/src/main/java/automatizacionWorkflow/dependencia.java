package automatizacionWorkflow;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.mashape.unirest.http.exceptions.UnirestException;

public class dependencia extends Base{
	List<WebElement> lista;
	By dependencia = By.xpath("//*[@id=\"ulSidebar\"]/li[6]/a/span");
	By nd = By.xpath("//div/span/button[2]");
	By nombre = By.name("nombre");
	By descrip = By.name("descripcion");
	By guardar = By.xpath("//div[2]/div/button");
	By ok = By.xpath("//div[3]/button[1]");
	By check = By.id("swal2-content");
	int f;
	
	

	public dependencia(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public void IngresarDependencia() throws InterruptedException, UnirestException {
		try {
		click(dependencia);
		Thread.sleep(1000);
		click(nd);
		Thread.sleep(1000);
		type("nombre", nombre);
		Thread.sleep(1000);
		type("esta es una descripcion de prueba", descrip);
		Thread.sleep(1000);
		click(guardar);
		Thread.sleep(1000);
		click(ok);
		
		}catch(Exception e) {
			DefinirError.getException(ErrorLog(e), this.getClass().toString(), "IngresarDependencia");
				}
	}

	public void actualizardependencia() throws InterruptedException, UnirestException {
		try {
		Thread.sleep(1000);
		click(dependencia);
		Thread.sleep(1000);
		do {
		lista = driver.findElements(By.xpath("//tbody/tr"));
		for (int i = 1; i < lista.size()+1; i++) {
			if (driver.findElement(By.xpath("//tbody/tr[" + i + "]/td[1]")).getText().equals("nombre")) {
				
				Thread.sleep(1000);
				driver.findElement(By.xpath("//tbody/tr[" + i + "]/td[4]/button")).click();
				Thread.sleep(1000);
				limpiar(nombre);
				Thread.sleep(1000);
				type("gggg", nombre);
				Thread.sleep(1000);
				click(guardar);
				Thread.sleep(2000);
				click(ok);
				System.out.println("se actualizo correctamente el grupo");
				f=1;
			}
		}
		if (f == 0) {
			driver.findElement(By.linkText("Siguiente")).click();
		}
	}while(f!=1);
		}catch(Exception e) {
			DefinirError.getException(ErrorLog(e), this.getClass().toString(), "actualizardependencia");
				}
	}

	public void Eliminardependencia() throws InterruptedException, UnirestException {
		try {
		Thread.sleep(1000);
		click(dependencia);
		Thread.sleep(1000);
		do {
		lista = driver.findElements(By.xpath("//tbody/tr"));
		for (int i = 1; i < lista.size()+1; i++) {
			if (driver.findElement(By.xpath("//tbody/tr[" + i + "]/td[1]")).getText().equals("gggg")) {
				
				Thread.sleep(1000);
				driver.findElement(By.xpath("//tbody/tr[" + i + "]/td[5]/div/div/button")).click();
				Thread.sleep(1000);
				if (getText(check).equals("Dependencia actualizada correctamente")) {
					click(ok);
					System.out.println("se actualizo correctamente el grupo");
				}
				
				f=1;
			}
		}
		if (f == 0) {
			driver.findElement(By.linkText("Siguiente")).click();
		}
	}while(f!=1);
		}catch(Exception e) {
			DefinirError.getException(ErrorLog(e), this.getClass().toString(), "Eliminardependencia");
				}
	}
}
