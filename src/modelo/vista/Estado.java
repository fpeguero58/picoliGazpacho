package modelo.vista;

import java.util.ArrayList;

public class Estado {
	private MinisterioEconomia finanzas = new MinisterioEconomia();
	private MinisterioIndustria industrias = new MinisterioIndustria();
	private MinisterioTiempo controlTiempo = new MinisterioTiempo();
	private Censo poblacion = new Censo();

	public void play() {
		poblacion.morir();
		industrias.jubilarTrabajadores();
		industrias.contratarDemandantes(poblacion.getDemandantes());
		controlTiempo.realizarCiclo(poblacion.getPoblacion());
		industrias.pagarSueldos();

	}

	public MinisterioEconomia getFinanzas() {
		return finanzas;
	}

	public MinisterioIndustria getIndustrias() {
		return industrias;
	}

	public MinisterioTiempo getControlTiempo() {
		return controlTiempo;
	}

	public Censo getPoblacion() {
		return poblacion;
	}

}
