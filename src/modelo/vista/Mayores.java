package modelo.vista;

public class Mayores extends Ser implements Subvencionable, Ahorrable, Empleable {
	private int ahorros;

	public Mayores(String nombre, int numeroIdentificacion, int esperanzaVida, int edad) {
		super(nombre, numeroIdentificacion, esperanzaVida, edad);
		// TODO Auto-generated constructor stub
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
}
