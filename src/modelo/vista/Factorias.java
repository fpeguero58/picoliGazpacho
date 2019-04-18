package modelo.vista;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Factorias {
	private int demanda;
	private int numeroTrabajadores;
	private Tamano tamano;
	Stack<Ser> trabajador=new Stack<Ser>();
	public Factorias(int demanda, int numeroTrabajadores, Tamano tamano) {
		super();
		this.demanda = demanda;
		this.numeroTrabajadores = numeroTrabajadores;
		this.tamano = tamano;
	}
}
