package modelo.vista;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Censo {
	int nacimientos=0;
	private ArrayList <Ser> poblacion= new ArrayList<Ser>();
//	private PriorityQueue<Ser> poblacion=new PriorityQueue<Ser>();
	//esta coleccion se ordena segun el tiempo que lleven demandando trabajo, que serian lo que mas arriba estan. La excepcion es que la gente con menos ahorros subirá puestos en la lista obligatoriamente(consultar enunciado)
	private PriorityQueue<Mayores> demandantes= new PriorityQueue<Mayores>();
	
	public PriorityQueue<Mayores> getDemandantes() {
		return demandantes;
	}
	Comparator<Ser> comparador = new Comparator<Ser>() {
		@Override
		public int compare(Ser o1, Ser o2) {
			return o1.getEdad()-o2.getEdad();
		}
	};
	ArrayList<Ser> cosa=new ArrayList<>();
	public void prueba() {
	Mayores mayor=new Mayores("riquelme", 1, 10);
	Menor menor=new Menor("ricky", 1, 10);
	Jubilados jubilado=new Jubilados("Fernando", 5,80);
	cosa.add(menor);
	cosa.add(jubilado);
	cosa.add(mayor);
	Collections.sort(cosa, comparador);
	for (Ser mayores : cosa) {
		System.out.println(mayores.getNombre()+" "+mayores.getEdad());
	}
	}
	public void setDemandantes(PriorityQueue<Mayores> demandantes) {
		this.demandantes = demandantes;
	}
	
	
	public ArrayList <Ser> getPoblacion() {
		return poblacion;
	}
	
	public void setPoblacion(ArrayList <Ser> poblacion) {
		this.poblacion = poblacion;
	}
	public int CalcularNacimiento(float demanda,float produccion) {
		float produccionMia=produccion;
		if (produccion>demanda) {
			while (produccionMia>demanda) {
				produccionMia-=1000;
				nacimientos--;
			}
			nacimientos++;

		}else {
			while (produccionMia<=demanda) {
				produccionMia+=1000;
				nacimientos++;
			}
			nacimientos--;
		}
		if (nacimientos<=0) {
			nacimientos=0;
		}
		return nacimientos;
	}
	public void nacimiento(float demanda,float produccion) {
		for (int i = 0; i < CalcularNacimiento(demanda, produccion); i++) {
			Menor menor=new Menor(nombre, numeroIdentificacion, esperanzaVida);
			poblacion.add(menor);
		}
	}
	public void muerte(ArrayList<Ser> lista) {
		for (Ser ser : lista) {
			if (ser.morir()) {
				lista.remove(ser);
			}
		}
	}
	public void reducirNV() {
		for (Ser ser : poblacion) {
			ser.setNecesidadVital(necesidadVital);
		}
	}
	public static void main(String[] args) {
		Censo censo=new Censo();
		censo.prueba();
	}
}
