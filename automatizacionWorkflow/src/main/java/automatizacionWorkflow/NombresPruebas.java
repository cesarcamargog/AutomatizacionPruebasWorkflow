package automatizacionWorkflow;

public class NombresPruebas {

	String[][] ingresar, grupos, estructuras, dependencias;

	public String[][] setPartner() {
		ingresar = new String[4][6];
		ingresar[0][0] = "Cesar";
		ingresar[0][1] = "Camargo";
		ingresar[0][2] = "Godinez";
		ingresar[0][3] = "19091998";
		ingresar[0][4] = "CAGC1909199834";
		ingresar[0][5] = "CesarCamargo";
		ingresar[1][0] = "Jose";
		ingresar[1][1] = "Jimenez";
		ingresar[1][2] = "Garcia";
		ingresar[1][3] = "20112000";
		ingresar[1][4] = "JHJ2011200032";
		ingresar[1][5] = "JavierG";
		ingresar[2][0] = "Rosario";
		ingresar[2][1] = "perez";
		ingresar[2][2] = "Lopez";
		ingresar[2][3] = "08081998";
		ingresar[2][4] = "SAJE0808199841";
		ingresar[2][5] = "rosapl";
		ingresar[3][0] = "Julio";
		ingresar[3][1] = "Rodriguez";
		ingresar[3][2] = "Flores";
		ingresar[3][3] = "03082003";
		ingresar[3][4] = "JFR0308200312";
		ingresar[3][5] = "JulioRF";
		return ingresar;
	}

	public String[][] setgrupos() {
		grupos = new String[4][3];
		grupos[0][0] = "Desarrollo";
		grupos[0][1] = "SD";
		grupos[0][2] = "Bancomer";
		grupos[1][0] = "RH";
		grupos[1][1] = "Tabares";
		grupos[1][2] = "Marmol";
		grupos[2][0] = "Contaduria";
		grupos[2][1] = "Celulandia";
		grupos[2][2] = "Carranza";
		grupos[3][0] = "Logistica";
		grupos[3][1] = "SD";
		grupos[3][2] = "Pto.aereo";
		return grupos;
	}

	public String[][] setEstructura() {
		return estructuras;
	}
}
