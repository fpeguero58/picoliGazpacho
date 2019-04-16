package modelo.vista;

import java.util.ArrayList;
import java.util.List;

public class Factorias {
	private int demanda;
	private int numeroTrabajadores;
	private Tamano tamano;
	List trabajadores=new ArrayList<Integer>();
	public Factorias(int demanda, int numeroTrabajadores, Tamano tamano) {
		super();
		this.demanda = demanda;
		this.numeroTrabajadores = numeroTrabajadores;
		this.tamano = tamano;
	}
}
