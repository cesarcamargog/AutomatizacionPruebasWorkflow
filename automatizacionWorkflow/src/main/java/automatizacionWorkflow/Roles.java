package automatizacionWorkflow;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.mashape.unirest.http.exceptions.UnirestException;

public class Roles extends Base{
	WebElement elemento;
	List<WebElement> lista;
	By rol = By.linkText("Roles");
	By NR = By.xpath("//span[2]/button");
	By nombre = By.name("name");
By prueba = By.xpath("//*[@value='1']");
By guardar = By.xpath("//div[3]/button[2]");
By ok = By.xpath("//div[3]/button[1]");
By localizador = By.xpath("//div/div/div[1]/h3");
By check= By.id("swal2-content");
String k;
Random d;
int x;
	public Roles(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public void ingresarRol() throws InterruptedException, UnirestException {
		try {
		click(rol);
		Thread.sleep(1000);
		click(NR);
		Thread.sleep(1000);
		type("x", nombre);
		Thread.sleep(1000);
	do {
		
		d = new Random();
		x=d.nextInt(32);
		if (x==19|| x==14) {
			
			break;
		}
	}while(x!=13||x!=14||x!=19||x!=31);
	Thread.sleep(2000);
	driver.findElement(By.xpath("//*[@value='"+x+"']")).click();
	Thread.sleep(1000);
	click(guardar);
	Thread.sleep(1000);
	if(getText(check).equals("Rol Guardado Correctamente")) {
		click(ok);
		System.out.println("Se guardo correctamente");
		
	}}catch(Exception e) {
		DefinirError.getException(ErrorLog(e), this.getClass().toString(), "ingresarRol");
	}
	
	}

	public void ActualizarRol() throws InterruptedException, UnirestException {
		try {
	Thread.sleep(1000);

	lista = driver.findElements(By.xpath("//tbody/tr"));
	for (int i = 1; i <lista.size()+1; i++) {
		if (driver.findElement(By.xpath("//tbody/tr["+i+"]/td[2]")).getText().equals("x")) {
			Thread.sleep(1000);
			driver.findElement(By.xpath("//tbody/tr["+i+"]/td[3]/button")).click();
			limpiar(nombre);
			Thread.sleep(1000);
			type("s", nombre);
			Thread.sleep(1000);
			click(guardar);
			Thread.sleep(2000);

			if(getText(check).equals("Rol Guardado Correctamente")) {
				click(ok);
				System.out.println("Se actualizo correctamente");
				
			}
		}
		
	}}catch(Exception e) {
		DefinirError.getException(ErrorLog(e), this.getClass().toString(), "actualizarRol");
	}
	
		
	}
	public void eliminarRoles() throws UnirestException {
		try {
			lista = driver.findElements(By.xpath("//tbody/tr"));
			for (int i = 1; i <lista.size()+1; i++) {
				if (driver.findElement(By.xpath("//tbody/tr["+i+"]/td[2]")).getText().equals("s")) {
					Thread.sleep(1000);
					driver.findElement(By.xpath("//tbody/tr["+i+"]/td[4]/button")).click();
					Thread.sleep(1000);
				
					if(getText(check).equals("Rol ELIMINADO Correctamente")) {
						click(ok);
						System.out.println("Se actualizo correctamente");
						
					}
				}
				
			}
		}catch(Exception e) {
			DefinirError.getException(ErrorLog(e), this.getClass().toString(), "eliminarRoles");
				}
		
	}
}
