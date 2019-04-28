package modelo.vista;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Stack;

public class Censo {
	private ArrayList <Ser> poblacion= new ArrayList<Ser>();
//	private PriorityQueue<Ser> poblacion=new PriorityQueue<Ser>();
	//esta coleccion se ordena segun el tiempo que lleven demandando trabajo, que serian lo que mas arriba estan. La excepcion es que la gente con menos ahorros subirá puestos en la lista obligatoriamente(consultar enunciado)
	private PriorityQueue<Mayores> demandantes= new PriorityQueue<Mayores>();
	
	public PriorityQueue<Mayores> getDemandantes() {
		return demandantes;
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
}
