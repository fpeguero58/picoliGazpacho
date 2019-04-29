package modelo.vista;

import java.util.ArrayList;

public class MinisterioTiempo {

	public void realizarCiclo(ArrayList<Ser> poblacion) {
		// TODO //FALTAN COSAS??
		for (Ser ser : poblacion) {
			ser.setEdad(ser.getEdad() + 1);
		}
	}

	public void aumentarDemanda(float demanda) {
		// TODO LE ENTRA LA DEMANDA DE ESTADO (?)
		demanda += demanda / 10; 
	}
	public void disminuirDemanda(float demanda) {
		// TODO LE ENTRA LA DEMANDA DE ESTADO (?)
		demanda -= demanda / 10; 
	}

}
