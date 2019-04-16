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

	

}
