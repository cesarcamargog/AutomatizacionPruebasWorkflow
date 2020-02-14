package automatizacionWorkflow;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Login extends Base {

	By loginlocator = By.xpath("//*[@id=\"principalFrame\"]/div[1]/div[2]/div[1]/h1");
	By usuario = By.id("username");
	By contraseña = By.id("password");
	By submit = By.xpath("//*[@id=\"principalFrame\"]/div[1]/div[2]/div[3]/form/div[4]/button");
	By dash = By.cssSelector("#principalFrame > section > div > div");

	public Login(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public void login() throws InterruptedException {
		Thread.sleep(1000);
		if(isdisplayed(loginlocator)) {
			type("root", usuario);
			type("root", contraseña);
			click(submit);
			Thread.sleep(1000);
		}
		
	}
	public boolean ingreso() throws InterruptedException {
		Thread.sleep(1000);
		if(isdisplayed(dash)) {
			System.out.println("Se ah ingresado correctamente al sistema");
			return true;
		}else {
			return false;
		}
	}
}
