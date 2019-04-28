package modelo.vista;


public class Mayores extends Ser implements Subvencionable, Ahorrable, Empleable {
	private float ahorros;

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


	@Override
	public int compareTo(Ser o) {
			if (this.equals(o)) {
				return 0;
			}else {
				//quitar luego el int
				return (int)(this.getNecesidadVital()-o.getNecesidadVital());
			}
	}

}
