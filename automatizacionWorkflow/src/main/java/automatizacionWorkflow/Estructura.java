package automatizacionWorkflow;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.mashape.unirest.http.exceptions.UnirestException;

public class Estructura extends Base {
	WebElement elemento;
	List<WebElement> lista;
	String [][] grupos;
	int gg;
	NombresPruebas s;
	Grupo g;
	By menu = By.xpath("//*[@id=\"ulSidebar\"]/li[5]/ul");
	By estructura = By.linkText("Estructura");
	By EG = By.xpath("//*[@id=\"ulSidebar\"]/li[5]/ul/li[1]/a/span");
	By ne = By.xpath("//span/button[2]");
	By nombre = By.name("nombre");
	By guardar = By.xpath("//div[2]/div/button");
	By ok = By.xpath("//div[3]/button[1]");
	By Ep = By.xpath("//*[@id=\"ulSidebar\"]/li[5]/ul/li[2]/a/span");
	By ED = By.xpath("//*[@id=\"ulSidebar\"]/li[5]/ul/li[4]/a/span");
	By Epos = By.xpath("//*[@id=\"ulSidebar\"]/li[5]/ul/li[3]/a/span");
	By EA = By.xpath("//*[@id=\"ulSidebar\"]/li[5]/ul/li[5]/a/span");
	By bb= By.xpath("//div/label/span");
	By Fi = By.name("fechaInicio");
	By Ff= By.name("fechaFin");
	By check = By.id("swal2-content");
	String hg;
	int f,x;

	public Estructura(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public void abrirmenu() throws InterruptedException, UnirestException {

		Thread.sleep(1000);
		if (!isdisplayed(menu)) {
			click(estructura);
		}
		s = new NombresPruebas();
		g= new Grupo(driver);
		grupos=s.setgrupos();
		gg= g.setgrup();
		Thread.sleep(1000);
		for (int i = 1; i < 6; i++) {
			IngresarEstructuras(i);
		}
		for (int i = 1; i < 6; i++) {
			Actualizar(i);
		}
		for (int i = 1; i < 6; i++) {
			Eliminar(i);
		}
		
	}

	public void IngresarEstructuras(int h) throws InterruptedException, UnirestException {
		try {
		Thread.sleep(1000);
		switch (h) {
		case 1:
			Thread.sleep(1000);
			click(EG);
			Thread.sleep(1000);
			click(ne);
			Thread.sleep(1000);
			type("xxx", nombre);
			Thread.sleep(1000);
			elemento = driver.findElement(By.name("grupoEmpresa"));
			elemento.click();
			Thread.sleep(1000);
			lista=elemento.findElements(By.tagName("option"));
			for (int i = 0; i < lista.size(); i++) {
				if(lista.get(i).getText().equals("asd")){
					lista.get(i).click();
				}
			}
			Thread.sleep(1000);
			click(guardar);
			Thread.sleep(1000);
			if(getText(check).equals("Estructra Grupo agregada correctamente")) {
				click(ok);
				Thread.sleep(2000);
			}
		
			break;
			//<----------------------------------------------------------------->
		case 2:
			Thread.sleep(1000);
			click(Ep);
			Thread.sleep(1000);
			click(ne);
			Thread.sleep(2000);
			type("sss", nombre);
			Thread.sleep(1000);
			elemento = driver.findElement(By.name("grupoEmpresa"));
			Thread.sleep(1000);
			lista=elemento.findElements(By.tagName("option"));
			for (int i = 0; i < lista.size(); i++) {
				if(lista.get(i).getText().equals("asd")){
					lista.get(i).click();
				}
			}
			Thread.sleep(1000);
			elemento = driver.findElement(By.name("puestoEscalamiento"));
			Thread.sleep(1000);
			lista=elemento.findElements(By.tagName("option"));
			for (int i = 0; i < lista.size(); i++) {
				if(lista.get(i).getText().equals("x")){
					lista.get(i).click();
				}
			}
			Thread.sleep(1000);
			click(guardar);
			Thread.sleep(1000);
			if(getText(check).equals("Estructura Puesto agregada correctamente")) {
				click(ok);
				Thread.sleep(2000);
			}
			break;
			//<------------------------------------------------------------------->
		case 3:
			Thread.sleep(1000);
			click(ED);
			Thread.sleep(1000);
			click(ne);
			Thread.sleep(1000);
			type("xxx", nombre);
			Thread.sleep(1000);
			elemento = driver.findElement(By.name("grupoEmpresa"));
			elemento.click();
			Thread.sleep(1000);
			lista=elemento.findElements(By.tagName("option"));
			for (int i = 0; i < lista.size(); i++) {
				if(lista.get(i).getText().equals("asd")){
					lista.get(i).click();
				}
			}
			Thread.sleep(1000);
			click(guardar);
			Thread.sleep(1000);
			if(getText(check).equals("Estructura Departamento agregada correctamente")) {
				click(ok);
				Thread.sleep(2000);
			}
			break;
			//<---------------------------------------------------------------->
		case 4:
			Thread.sleep(1000);
			click(Epos);
			Thread.sleep(1000);
			click(ne);
			Thread.sleep(2000);
			type("asdwe", nombre);
			Thread.sleep(1000);
			elemento = driver.findElement(By.name("estructuraPuesto"));
			elemento.click();
			Thread.sleep(1000);
			lista=elemento.findElements(By.tagName("option"));
			for (int i = 0; i < lista.size(); i++) {
				if(lista.get(i).getText().equals("x")){
					lista.get(i).click();
				}
			}
			Thread.sleep(1000);
			elemento = driver.findElement(By.name("estructuraDepartamento"));
			elemento.click();
			Thread.sleep(1000);
			lista=elemento.findElements(By.tagName("option"));
			for (int i = 0; i < lista.size(); i++) {
				if(lista.get(i).getText().equals("xxx")){
					lista.get(i).click();
				}
			}
			Thread.sleep(1000);
			elemento = driver.findElement(By.name("estructuraGrupo"));
			elemento.click();
			Thread.sleep(1000);
			lista=elemento.findElements(By.tagName("option"));
			for (int i = 0; i < lista.size(); i++) {
				if(lista.get(i).getText().equals("xxx")){
					lista.get(i).click();
				}
			}
			Thread.sleep(1000);
			elemento = driver.findElement(By.name("grupoSucursal"));
			elemento.click();
			Thread.sleep(1000);
			lista=elemento.findElements(By.tagName("option"));
			for (int i = 0; i < lista.size(); i++) {
				if(lista.get(i).getText().equals("x")){
					lista.get(i).click();
				}
			}
			Thread.sleep(1000);
			click(guardar);
			Thread.sleep(1000);
			if(getText(check).equals("Estructura Posicion agregada correctamente")) {
				click(ok);
				Thread.sleep(2000);
			}
			break;
			//<---------------------------------------------------------------------->
		case 5:
			Thread.sleep(1000);
			click(EA);
			Thread.sleep(1000);
			click(ne);
			Thread.sleep(2000);
			type("qwerty", nombre);
			Thread.sleep(1000);
			elemento = driver.findElement(By.name("grupoEmpresa"));
			elemento.click();
			Thread.sleep(1000);
			lista=elemento.findElements(By.tagName("option"));
			for (int i = 0; i < lista.size(); i++) {
				if(lista.get(i).getText().equals("asdwe")){
					lista.get(i).click();
				}
			}
			Thread.sleep(1000);
			elemento = driver.findElement(By.xpath("//div[3]/div/div/select"));
			elemento.click();
			Thread.sleep(1000);
			lista=elemento.findElements(By.tagName("option"));
			for (int i = 0; i < lista.size(); i++) {
				if(lista.get(i).getText().equals("RICARDO")){
					lista.get(i).click();
				}
			}
			Thread.sleep(1000);
			click(bb);
			Thread.sleep(1000);
			type("19092000", Fi);
			Thread.sleep(1000);
			type("19092010", Ff);
			Thread.sleep(1000);
			click(guardar);
			Thread.sleep(1000);
			if(getText(check).equals("Estructura Asignacion agregada correctamente")) {
				click(ok);
				Thread.sleep(2000);
			}
			break;
		}}catch(Exception e) {
	DefinirError.getException(ErrorLog(e), this.getClass().toString(), "IngresarEstructura");
	e.printStackTrace();
		}
	}

	public void Actualizar(int h) throws InterruptedException, UnirestException {
		try {
		switch(h) {
		case 1:
			click(EG);
			Thread.sleep(1000);
			  do {
				lista = driver.findElements(By.xpath("//tbody/tr"));
				for (int i = 1; i < lista.size()+1; i++) {
				//	System.out.println(driver.findElement(By.xpath("//tbody/tr[" + i + "]/td[2]")).getText());
					if (driver.findElement(By.xpath("//tbody/tr[" + i + "]/td[2]")).getText().equals("xxx")) {
						
						Thread.sleep(1000);
						driver.findElement(By.xpath("//tbody/tr[" + i + "]/td[4]/button")).click();
						Thread.sleep(1000);
						limpiar(nombre);
						Thread.sleep(1000);
						type("gggg", nombre);
						Thread.sleep(1000);
						click(guardar);
						Thread.sleep(2000);
						if(getText(check).equals("Estructra Grupo agregada correctamente")) {
							click(ok);
							Thread.sleep(2000);
							f=1;
						}
					}
				}
				if (f == 0) {
					driver.findElement(By.linkText("Siguiente")).click();
				}
			}while(f!=1);
			
			break;
			//<-------------------------------------------------------->
		case 2:

			click(Ep);
			Thread.sleep(1000);
			lista = driver.findElements(By.xpath("//tbody/tr"));
			do {
				for (int i = 1; i < lista.size()+1; i++) {
					//System.out.println(driver.findElement(By.xpath("//tbody/tr[" + i + "]/td[2]")).getText());
					if (driver.findElement(By.xpath("//tbody/tr[" + i + "]/td[2]")).getText().equals("sss")) {
						
						Thread.sleep(1000);
						driver.findElement(By.xpath("//tbody/tr[" + i + "]/td[5]/button")).click();
						Thread.sleep(2000);
						limpiar(nombre);
						Thread.sleep(1000);
						type("gggg", nombre);
						Thread.sleep(1000);
						click(guardar);
						Thread.sleep(2000);
						if(getText(check).equals("Estructura Puesto agregada correctamente")) {
							click(ok);
							Thread.sleep(2000);
							f=1;
						}
					}
				}
				if (f == 0) {
					driver.findElement(By.linkText("Siguiente")).click();
				}
			}while(f!=1);
			
			break;
			//<----------------------------------------------------------->
		case 3:

			click(ED);
			Thread.sleep(1000);
			do {
			lista = driver.findElements(By.xpath("//tbody/tr"));
			for (int i = 1; i < lista.size()+1; i++) {
				//System.out.println(driver.findElement(By.xpath("//tbody/tr[" + i + "]/td[2]")).getText());
				if (driver.findElement(By.xpath("//tbody/tr[" + i + "]/td[2]")).getText().equals("xxx")) {
					
					Thread.sleep(1000);
					driver.findElement(By.xpath("//tbody/tr[" + i + "]/td[4]/button")).click();
					Thread.sleep(2000);
					limpiar(nombre);
					Thread.sleep(1000);
					type("gggg", nombre);
					Thread.sleep(1000);
					click(guardar);
					Thread.sleep(2000);
					if(getText(check).equals("Estructura Departamento agregada correctamente")) {
						click(ok);
						Thread.sleep(2000);
						f=1;
					}
				}
			}
			if (f == 0) {
				driver.findElement(By.linkText("Siguiente")).click();
			}
		}while(f!=1);
			break;
			//<--------------------------------------------------------->
		case 4:
			
			click(Epos);
			Thread.sleep(1000);
			
			
					do {
						lista = driver.findElements(By.xpath("//tbody/tr"));
						for (int i = 1; i < lista.size()+1; i++) {
							//System.out.println(driver.findElement(By.xpath("//tbody/tr[" + i + "]/td[2]")).getText());
							if (driver.findElement(By.xpath("//tbody/tr[" + i + "]/td[2]")).getText().equals("asdwe")) {
								
								Thread.sleep(1000);
								driver.findElement(By.xpath("//tbody/tr[" + i + "]/td[8]/button")).click();
								Thread.sleep(2000);
								hg = getText(By.xpath("//section/div/div/div[1]/h3"));
								if(hg.equals("EDITAR ESTRUCTURA POSICION")) {
									Thread.sleep(1000);
									limpiar(nombre);
									Thread.sleep(1000);
									type("gggg", nombre);
									Thread.sleep(1000);
									click(guardar);
									Thread.sleep(2000);
									
								}
								
								if(getText(check).equals("Estructura Posicion agregada correctamente")) {
									click(ok);
									Thread.sleep(2000);
									f=1;
								}
							}
						
						if (f == 0) {
							driver.findElement(By.linkText("Siguiente")).click();
						}}
					}while(f!=1);
				
			
			
			break;
			//<--------------------------------------------------------->
		case 5:
			
			Thread.sleep(1000);
			click(EA);
		Thread.sleep(1000);
		do {
		lista = driver.findElements(By.xpath("//tbody/tr"));
		for (int i = 1; i < lista.size()+1; i++) {
			//System.out.println(driver.findElement(By.xpath("//tbody/tr[" + i + "]/td[2]")).getText());
			if (driver.findElement(By.xpath("//tbody/tr[" + i + "]/td[2]")).getText().equals("qwerty")) {
				
				Thread.sleep(1000);
				driver.findElement(By.xpath("//tbody/tr[" + i + "]/td[8]/button")).click();
				Thread.sleep(2000);
				limpiar(nombre);
				Thread.sleep(1000);
				type("gggg", nombre);
				Thread.sleep(1000);
				click(guardar);
				Thread.sleep(2000);
				if(getText(check).equals("Estructura Asignacion agregada correctamente")) {
					click(ok);
					Thread.sleep(2000);
					//System.out.println(getText(check));
					f=1;
				}
			}
		}
		if (f == 0) {
			driver.findElement(By.linkText("Siguiente")).click();
		}
	}while(f!=1);
			break;
		}}catch(Exception e) {
	DefinirError.getException(ErrorLog(e), this.getClass().toString(), "Actualizar");
	e.printStackTrace();
		}
		
	}

	public void Eliminar(int h) throws InterruptedException, UnirestException {
		try {
		switch(h) {
		case 5:
			Thread.sleep(2000);
			click(EG);
			Thread.sleep(1000);
			do {
			lista = driver.findElements(By.xpath("//tbody/tr"));
			for (int i = 1; i < lista.size()+1; i++) {
				//System.out.println(driver.findElement(By.xpath("//tbody/tr[" + i + "]/td[2]")).getText());
				if (driver.findElement(By.xpath("//tbody/tr[" + i + "]/td[2]")).getText().equals("gggg")) {
					
					Thread.sleep(1000);
					driver.findElement(By.xpath("//tbody/tr[" + i + "]/td[5]/button")).click();
					Thread.sleep(1000);
					if(getText(check).equals("Estructura Grupo eliminada correctamente")) {
						click(ok);
						Thread.sleep(2000);
						f=1;
					}
				}
			}
			if (f == 0) {
				driver.findElement(By.linkText("Siguiente")).click();
			}
		}while(f!=1);
			break;
		case 4:
			Thread.sleep(2000);
			click(Ep);
			Thread.sleep(1000);
			do {
			lista = driver.findElements(By.xpath("//tbody/tr"));
			for (int i = 1; i < lista.size()+1; i++) {
				//System.out.println(driver.findElement(By.xpath("//tbody/tr[" + i + "]/td[2]")).getText());
				if (driver.findElement(By.xpath("//tbody/tr[" + i + "]/td[2]")).getText().equals("gggg")) {
					
					Thread.sleep(1000);
					driver.findElement(By.xpath("//tbody/tr[" + i + "]/td[6]/button")).click();
					Thread.sleep(1000);
					if(getText(check).equals("Estructura Puesto eliminada correctamente")) {
						click(ok);
						Thread.sleep(2000);
						f=1;
					}
				}
			}
			if (f == 0) {
				driver.findElement(By.linkText("Siguiente")).click();
			}
		}while(f!=1);
			break;
		case 3:
			Thread.sleep(2000);
			click(ED);
			Thread.sleep(1000);
			lista = driver.findElements(By.xpath("//tbody/tr"));
			for (int i = 1; i < lista.size()+1; i++) {
				//System.out.println(driver.findElement(By.xpath("//tbody/tr[" + i + "]/td[2]")).getText());
				if (driver.findElement(By.xpath("//tbody/tr[" + i + "]/td[2]")).getText().equals("gggg")) {
					
					Thread.sleep(1000);
					driver.findElement(By.xpath("//tbody/tr[" + i + "]/td[5]/button")).click();
					Thread.sleep(1000);
					if(getText(check).equals("Estructura Departamento eliminada correctamente")) {
						click(ok);
						Thread.sleep(2000);
						f=1;
					}
				}
			}
			break;
		case 2:
			Thread.sleep(2000);
			click(Epos);
			Thread.sleep(1000);
			lista = driver.findElements(By.xpath("//tbody/tr"));
			for (int i = 1; i < lista.size()+1; i++) {
				//System.out.println(driver.findElement(By.xpath("//tbody/tr[" + i + "]/td[2]")).getText());
				if (driver.findElement(By.xpath("//tbody/tr[" + i + "]/td[2]")).getText().equals("gggg")) {
					
					Thread.sleep(1000);
					driver.findElement(By.xpath("//tbody/tr[" + i + "]/td[9]/button")).click();
					Thread.sleep(1000);
					if(getText(check).equals("Estructura Posicion eliminada correctamente")) {
						click(ok);
						Thread.sleep(2000);
						f=1;
					}
				}
			}
			break;
		case 1:
			Thread.sleep(2000);
			Thread.sleep(1000);
			click(EA);
			Thread.sleep(1000);
			lista = driver.findElements(By.xpath("//tbody/tr"));
			for (int i = 1; i < lista.size()+1; i++) {
				Thread.sleep(1000);
				//System.out.println(driver.findElement(By.xpath("//tbody/tr[" + i + "]/td[2]")).getText());
				if (driver.findElement(By.xpath("//tbody/tr[" + i + "]/td[2]")).getText().equals("gggg")) {
					
					Thread.sleep(1000);
					driver.findElement(By.xpath("//tbody/tr[" + i + "]/td[9]/button")).click();
					Thread.sleep(1000);
					if(getText(check).equals("Estructura Asignacion eliminada correctamente")) {
						click(ok);
						Thread.sleep(2000);
						f=1;
					}				}
			}
			break;
		}
	}catch(Exception e) {
		DefinirError.getException(ErrorLog(e), this.getClass().toString(), "IC");
		e.printStackTrace();
	}
}}
