package modelo.vista;

import java.util.ArrayList;

public class Estado {
	private MinisterioEconomia finanzas = new MinisterioEconomia();
	private MinisterioIndustria industrias = new MinisterioIndustria();
	private MinisterioTiempo controlTiempo = new MinisterioTiempo();
	private Censo poblacion = new Censo();
	
	public Estado() {
		
	}

	public void play() {
		industrias.eliminarTrabajadoresMuertos(poblacion.morir());
//		industrias.jubilarTrabajadores();
		controlTiempo.realizarCiclo(poblacion.getPoblacion());
		industrias.contratarDemandantes(poblacion.getDemandantes());
		industrias.eliminarTrabajadoresMuertos(poblacion.morir());
		industrias.pagarSueldos();
		finanzas.pagarSubvenciones(poblacion.getDemandantes(), poblacion.getPoblacion());
		
		for(Factorias i: industrias.getIndustrias()) {
			finanzas.cobrarImpuestos(i.getTrabajadores());
		}

		industrias.reorganizarIndustrias();
		industrias.eliminaIndustrias();
		poblacion.organizarColeccionciones();
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
