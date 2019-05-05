package modelo.vista;

import java.util.ArrayList;
import java.util.Stack;

public class Estado {
	private MinisterioEconomia finanzas = new MinisterioEconomia();
	private MinisterioIndustria industrias = new MinisterioIndustria();
	private MinisterioTiempo controlTiempo = new MinisterioTiempo();
	private Censo poblacion = new Censo();
	
	public Estado() {
		
	}

	public void play() {
//		industrias.jubilarTrabajadores();
		industrias.contratarDemandantes(poblacion.getDemandantes());
		finanzas.pagarSubvenciones(poblacion.getDemandantes(), poblacion.getPoblacion());
		
		for(Factorias i: industrias.getIndustrias()) {
			finanzas.cobrarImpuestos(i.getTrabajadores());
		}

		industrias.reorganizarIndustrias();
		industrias.eliminaIndustrias();
		poblacion.jubiladosNuevos();
		industrias.eliminaIndustrias();
		industrias.despedirTrabajadores(poblacion.getDemandantes());
		poblacion.nacimiento(industrias.getDemanda(), industrias.calcularProduccionTotal());
		controlTiempo.realizarCiclo(poblacion.getPoblacion());
		Stack<Ser> trabajadores= new Stack<>();
		for (Factorias factoria : industrias.getIndustrias()) {
			trabajadores.addAll(factoria.getTrabajadores());
		}
		poblacion.actualizarDemandantes(trabajadores);
		poblacion.organizarColeccionciones();
		industrias.eliminarTrabajadoresMuertos(poblacion.morir());
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
