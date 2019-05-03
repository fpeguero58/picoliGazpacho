package modelo.vista;

import java.util.Stack;

public class Factorias {

	private int idFactoria;
	private Stack<Ser> trabajadores = new Stack<Ser>();

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

	public void contratarTrabajador(Ser trabajador) {
		trabajadores.push(trabajador);
	}
	public void trabajadorMuerto(Ser ser) {
		trabajadores.remove(ser);
	}

	public Stack<Ser> getTrabajadores() {
		return trabajadores;
	}

	public Ser despedirTrabajador() {
		return trabajadores.pop();
	}

}
