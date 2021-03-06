package automatizacionWorkflow;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.List;
import java.util.NoSuchElementException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Base {
	WebDriver driver;
	WebElement elemento;
	private static ChromeOptions opciones;
	String text;

	public Base(WebDriver driver) {
		this.driver = driver;

	}
//----------------------------------------Metodos Selenium---------------------
	public WebDriver iniciar() {
		System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
		opciones = new ChromeOptions();
		opciones.addArguments("start-maximized");
		driver = new ChromeDriver(opciones);
		return driver;
	}
	public void submit(By locator) {
		elemento = driver.findElement(locator);
		elemento.submit();
	}

	public WebElement findlocator(By locator) {
		return driver.findElement(locator);
	
	}
	
	public List<WebElement>obtenerlista(WebElement elemento) {
		return elemento.findElements(By.tagName("option"));
	}
	
	public void type(String input,By locator) {
		driver.findElement(locator).sendKeys(input);
	}
	
	public boolean isdisplayed(By locator) {
		try {
			return driver.findElement(locator).isDisplayed();
		}catch(NoSuchElementException e){
			return false;
		}
	}
	public void limpiar(By locator) {
		driver.findElement(locator).clear();
	}
	
	public void get(String url) {
		driver.get(url);
	}
	public void click(By locator) {
		driver.findElement(locator).click();
	}
	
	public List<WebElement> lista(By locator){
		return driver.findElements(locator);
	}
public String getText(By locator) {
	text= driver.findElement(locator).getText();
	return text;
}
//--------------------------------------------------------------------------------------------------------------------------------
//---------------------------------------Obtener Error---------------------------------------------------------------
public String ErrorLog(Exception e) {
	StringWriter errors = new StringWriter();
	e.printStackTrace(new PrintWriter(errors));
	return errors.toString();
}
//------------------------------------------------------------------------------------------------------------------

//----------------------------------------Esperas(Waits)------------------------------------------------------------
public static void EsperaNormaL() {
	try {
		Thread.sleep(1000);
	}catch (Exception e) {
		e.printStackTrace();
	}
	
}

public void  esperarElemento(By locator) {

		WebDriverWait wait = new WebDriverWait(driver, 10000);
	    WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	


}
	
}
