package modelo.vista;

public class Menor extends Ser implements Subvencionable {

	public Menor(String nombre, int numeroIdentificacion, int esperanzaVida) {
		super(nombre, numeroIdentificacion, esperanzaVida);
	}

	@Override
	public float subvencionar() {
		// TODO
		//esto ya lo ha hecho Issam en Estado directametne. 
		return 0f;
	}

	public boolean mayoriaEdad() {
		return this.getEdad() >= 18;
		// metodo en Estado que si este metodo es true, se elimine y cambie de
		// coleccion.
	}

	@Override
	public float subvencionar(float x) {
		// TODO Auto-generated method stub
		return 0;
	}

}
