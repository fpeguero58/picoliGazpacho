package modelo.vista;

public class Jubilados extends Ser implements Subvencionable, Ahorrable {
	private float ahorros;
	
	public Jubilados(String nombre, int numeroIdentificacion, int esperanzaVida) {
		super(nombre, numeroIdentificacion, esperanzaVida);
		this.setNecesidadVital(365f/2);
		this.setEdad(65);
	}

	@Override
	public float subvencionar() {
		float retorno=0f;
		if (this.ahorros < this.getNecesidadVital()) {
			retorno = this.getNecesidadVital() - this.ahorros;
		}
		return retorno;
	}

	public float getAhorros() {
		return ahorros;
	}

	public void setAhorros(int ahorros) {
		this.ahorros = ahorros;
	}

	@Override
	public float subvencionar(float x) {
		// TODO Auto-generated method stub
		return 0;
	}

}
