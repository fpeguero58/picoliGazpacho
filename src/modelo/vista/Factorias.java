package modelo.vista;

import java.util.Stack;


public class Factorias {
	
	private int idFactoria;
	private Stack <Mayores> trabajadores= new Stack<Mayores>(); 
	
	public Factorias(int idFactoria) {
		super();
		this.setIdFactoria(idFactoria);
	}

	public int getNumeroTrabajadores() {
		return trabajadores.size();
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
	
	public Mayores despedirTrabajador() {
		return trabajadores.pop();
	}
	
}
