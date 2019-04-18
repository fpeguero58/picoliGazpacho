package modelo.vista;

public class Menor extends Ser implements Subvencionable {

	public Menor(String nombre, int numeroIdentificacion, int esperanzaVida, int edad) {
		super(nombre, numeroIdentificacion, esperanzaVida, edad);

		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean subvencionar() {
		// TODO
		// siempre true, depende solo la cantidad
		return true;
	}

	public boolean mayoriaEdad(Menor menor) {
		return this.getEdad() >= 18;
		// metodo en Estado que si este metodo es true, se elimine y cambie de
		// coleccion.
	}

}
