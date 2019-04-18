package modelo.vista;

public class Jubilados extends Ser implements Subvencionable, Ahorrable {
	private int ahorros;
	
	public Jubilados(String nombre, int numeroIdentificacion, int esperanzaVida, int edad) {
		super(nombre, numeroIdentificacion, esperanzaVida, edad);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean subvencionar() {
		// TODO 
		// va a depender
		return false;
	}

	public int getAhorros() {
		return ahorros;
	}

	public void setAhorros(int ahorros) {
		this.ahorros = ahorros;
	}

}
