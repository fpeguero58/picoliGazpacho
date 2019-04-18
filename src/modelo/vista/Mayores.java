package modelo.vista;

public class Mayores extends Ser implements Subvencionable, Ahorrable, Empleable {
	private int ahorros;

	public Mayores(String nombre, int numeroIdentificacion, int esperanzaVida, int edad) {
		super(nombre, numeroIdentificacion, esperanzaVida, edad);
		// TODO Auto-generated constructor stub
	}
	

	public int getAhorros() {
		return ahorros;
	}


	public void setAhorros(int ahorros) {
		this.ahorros = ahorros;
	}


	@Override
	public boolean subvencionar() {
		// TODO
		// va a depender
		return false;
	}

	public void aumentarAhorros() {
		 ahorros += getNecesidadVital() * 0.50;
	}
	public boolean edadJubilacion() {
		return this.getEdad() >= 65;
		// metodo en Estado que si este metodo es true, se elimine y cambie de
		// coleccion.
	}
}
