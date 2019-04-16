package modelo.vista;

public abstract class Ser {

	private String nombre;
	private int numeroIdentificacion; //es unico y no varía
	private int esperanzaVida; //aleatorio
	private int necesidadVital;
	private int edad;
	public Ser(String nombre, int numeroIdentificacion, int esperanzaVida, int edad) {
		super();
		this.nombre = nombre;
		this.numeroIdentificacion = numeroIdentificacion;
		this.esperanzaVida = esperanzaVida;
		this.edad = edad;
	}
	public int getEsperanzaVida() {
		return esperanzaVida;
	}
	public void setEsperanzaVida(int esperanzaVida) {
		this.esperanzaVida = esperanzaVida;
	}
	public int getNecesidadVital() {
		return necesidadVital;
	}
	public void setNecesidadVital(int necesidadVital) {
		this.necesidadVital = necesidadVital;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	public String getNombre() {
		return nombre;
	}
	public int getNumeroIdentificacion() {
		return numeroIdentificacion;
	}
	
//	public void morir() {
//		//TODO
//	}
	
}
