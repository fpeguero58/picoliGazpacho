package modelo.vista;

public enum Tamano {
	grande(1000),mediana(400),pequeña(100);
	private int capacidad;
	private Tamano(int capacidad) {
		this.capacidad = capacidad;
	}
	public int getCapacidad() {
		return capacidad;
	}
}
