package modelo.vista;

import java.util.Stack;


public class Factorias {

	private int idFactoria;
	private int demanda;
	private int numeroTrabajadores;
	private Tamano tamano;
	private Stack <Mayores> trabajadores= new Stack<Mayores>(); 

	public Factorias(int demanda, int numeroTrabajadores, int idFactoria, Tamano tamano) {
		super();
		this.demanda = demanda;
		this.numeroTrabajadores = numeroTrabajadores;
		this.tamano = tamano;
		this.setIdFactoria(idFactoria);
	}

	public int getDemanda() {
		return demanda;
	}

	public void setDemanda(int demanda) {
		this.demanda = demanda;
	}

	public int getNumeroTrabajadores() {
		return numeroTrabajadores;
	}

	public void setNumeroTrabajadores(int numeroTrabajadores) {
		this.numeroTrabajadores = numeroTrabajadores;
	}

	public Tamano getTamano() {
		return tamano;
	}

	public void setTamano(Tamano tamano) {
		this.tamano = tamano;
	}

	public int getIdFactoria() {
		return idFactoria;
	}

	public void setIdFactoria(int idFactoria) {
		this.idFactoria = idFactoria;
	}

	public void contratarTrabajador(Mayores trabajador) {
		trabajadores.push(trabajador);
	}

	public Ser despedirTrabajador() {
		return trabajadores.pop();
	}

}


