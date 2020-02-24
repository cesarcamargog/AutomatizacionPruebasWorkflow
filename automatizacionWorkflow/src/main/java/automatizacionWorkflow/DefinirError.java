package automatizacionWorkflow;

import com.mashape.unirest.http.exceptions.UnirestException;

public class DefinirError {
public static void getException(String e,String clase,String metodo) throws UnirestException {
	if (e.contains("NoSuchElementException")) {
		ErrorJira.run("No se encuentra el elemento", e, clase, metodo);
	}
	if(e.contains("ElementNotVisibleException")) {
		ErrorJira.run("El elemento no se encuentra visible", e, clase, metodo);
	}
	if(e.contains("ElementNotSelectableException")) {
		ErrorJira.run("El elemento no puede ser seleccionado", e, clase, metodo);
	}
	if(e.contains("InvalidSelectorException")) {
		ErrorJira.run("el selector usado no retorna un elemento", e, clase, metodo);
	}
	if(e.contains("NoSuchFrameException")) {
		ErrorJira.run("el frame seleccionado es invalido", e, clase, metodo);
	}
	if(e.contains("SessionNotFoundException")) {
		ErrorJira.run("El navegador no se encuentra", e, clase, metodo);
	}
	
}
}
