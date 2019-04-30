package modelo.vista;

public class Jubilados extends Ser {
	private float ahorros;

	public Jubilados(String nombre, int numeroIdentificacion, int esperanzaVida) {
		super(nombre, numeroIdentificacion, esperanzaVida);
		this.setNecesidadVital(365f / 2);
		this.setEdad(65);
	}

	public float getAhorros() {
		return ahorros;
	}

	public void setAhorros(int ahorros) {
		this.ahorros = ahorros;
	}
}
