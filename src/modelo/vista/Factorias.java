package modelo.vista;

public class Factorias {
	
	private int idFactoria;
	private int demanda;
	private int numeroTrabajadores;
	private Tamano tamano;
	public Factorias(int demanda, int numeroTrabajadores, int idFactoria, Tamano tamano) {
		super();
		this.demanda = demanda;
		this.numeroTrabajadores = numeroTrabajadores;
		this.tamano = tamano;
		this.setIdFactoria(idFactoria);
	}

	
}
