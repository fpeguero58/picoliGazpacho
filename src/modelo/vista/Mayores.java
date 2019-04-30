package modelo.vista;

public class Mayores extends Ser {
	private float ahorros;
	private float sueldo;

	public Mayores(String nombre, int numeroIdentificacion, int esperanzaVida) {
		super(nombre, numeroIdentificacion, esperanzaVida);
		this.setEdad(18);
	}

	public float getAhorros() {
		return ahorros;
	}

	public void setAhorros(int ahorros) {
		this.ahorros = ahorros;
	}

	public float getSueldo() {
		return sueldo;
	}

	public void setSueldo(float sueldo) {
		this.sueldo = sueldo;
	}

	public void aumentarAhorros() {
		ahorros += getNecesidadVital() * 0.50;
	}

}
