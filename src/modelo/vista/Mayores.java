package modelo.vista;

public class Mayores extends Ser implements Subvencionable, Ahorrable, Empleable {
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


	@Override
	public float subvencionar(float subvencionEstado) {
		if (this.ahorros >= (365-subvencionEstado)) {
			this.ahorros-= 365-subvencionEstado;
		}
		else {
			this.ahorros = 0;
		}
		return this.ahorros;
	}

	public void aumentarAhorros() {
		 ahorros += getNecesidadVital() * 0.50;
	}
	public boolean edadJubilacion() {
		return this.getEdad() >= 65;
		// metodo en Estado que si este metodo es true, se elimine y cambie de
		// coleccion.
	}


	@Override
	public float subvencionar() {
		// TODO Auto-generated method stub
		return 0;
	}
}
