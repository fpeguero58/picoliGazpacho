package modelo.vista;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;


public class Censo {
	private ArrayList<Ser> poblacion = new ArrayList<Ser>();
	private LinkedList<Ser> demandantes = new LinkedList<Ser>();
	private HashSet<Integer> identificacion = new HashSet<Integer>();
	private Comparator<Ser> comparador = new Comparator<Ser>() {
		@Override
		public int compare(Ser o1, Ser o2) {
			return o1.getEdad() - o2.getEdad();
		}
	};
	private Comparator<Ser> comparadorNV = new Comparator<Ser>() {

		@Override
		
		public int compare(Ser o1, Ser o2) {
			double cosa=o1.getAhorros()*100000;
			double cosaDos=o2.getAhorros()*100000;
			if (o1.getAhorros()==o2.getAhorros()) {
				return o1.hashCode()-o2.hashCode();
			}
			return (int)cosa-(int)(cosaDos);
		}
	};

	public Queue<Ser> getDemandantes() {
		return demandantes;
	}
	
	public void organizarColeccionciones() {
		Collections.sort(demandantes, comparadorNV);
		Collections.sort(demandantes, comparadorNV);
	}

	public void setDemandantes(LinkedList<Ser> demandantes) {
		this.demandantes = demandantes;
	}

	public ArrayList<Ser> getPoblacion() {
		return poblacion;
	}

	public void setPoblacion(ArrayList<Ser> poblacion) {
		this.poblacion = poblacion;
	}

	public void nacimiento() {
		Menor menor = new Menor(crearNombre(), CrearIdentificacion(), (int) (Math.random() * (90)));
		poblacion.add(menor);
	}

	public ArrayList<Ser> morir() {
		ArrayList<Ser> trabajadoresMuertos = new ArrayList<>();
		for (Ser ser : poblacion) {
			if (ser.getEdad() > ser.getEsperanzaVida()) {
				if (demandantes.contains(ser) && ser.getEdad() > 17 && ser.getEdad() < 65) {
					trabajadoresMuertos.add(ser);
				}
				poblacion.remove(ser);
				demandantes.remove(ser);
			}
		}
		return trabajadoresMuertos;
	}

	public int CrearIdentificacion() {
		int indice;
		do {
			indice = (int) (Math.random() * 9999999);
			System.out.println(indice);
		} while (!identificacion.add(indice));
		return indice;
	}

	public String crearNombre() {
		String nombre = "";
		int indice;
		for (int i = 0; i < 10; i++) {
			indice = (int) (Math.random() * (122 - 97) + 97);
			nombre = nombre + (char) (indice);
		}
		return nombre;
	}

	public void reducirEV() {
		float reduccion;
		for (Ser ser : poblacion) {
			reduccion = (ser.getNecesidadVital() - ser.getAhorros()) / ser.getNecesidadVital();
			if (reduccion < 0) {
				if (reduccion >= 0.5) {
					reduccion = 0.5f;
				}
				ser.setEsperanzaVida(ser.getEsperanzaVida() - reduccion);
			}
		}
	}

}
