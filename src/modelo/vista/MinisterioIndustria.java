package modelo.vista;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Stack;

public class MinisterioIndustria {
	private Stack<Factorias> industrias = new Stack<Factorias>();
	private float demanda;
	private final int MIN_TRABAJADORES = 300;
	private final int MAX_TRABAJADORES = 1000;

	public MinisterioIndustria() {
		this.demanda = 96725;
		industrias.add(new Factorias(0));
	}

	public Stack<Factorias> getIndustrias() {
		return industrias;
	}

	public void setIndustrias(Stack<Factorias> industrias) {
		this.industrias = industrias;
	}

	public float getDemanda() {
		return demanda;
	}

	public void setDemanda(float demanda) {
		this.demanda = demanda;
	}

	public void aumentarDemanda() {
		demanda += demanda / 10;
	}

	public void reducirDemanda() {
		demanda -= demanda / 10;
	}

	public void reorganizarIndustrias(Stack<Factorias> industrias) {
		for (Factorias i : industrias) {
			if (i.getNumeroTrabajadores() < MIN_TRABAJADORES) {
				for (Factorias m : industrias) {
					if (m.getNumeroTrabajadores() > MIN_TRABAJADORES) {
						do {
							i.contratarTrabajador(m.despedirTrabajador());
						} while (i.getNumeroTrabajadores() >= MIN_TRABAJADORES
								|| m.getNumeroTrabajadores() <= MIN_TRABAJADORES);
					}
				}
			}
		}
	}

	public void altaTrabajador(PriorityQueue<Ser> demandantes, Stack<Factorias> industrias) {
		boolean creacion = true;

		for (Factorias i : industrias) {
			if (i.getNumeroTrabajadores() < MAX_TRABAJADORES) {
				i.contratarTrabajador(demandantes.poll());
				creacion = false;
			}
		}
		if (creacion) {
			industrias.add(new Factorias(industrias.firstElement().getIdFactoria() + 1));
		}
	}

	public void bajaTrabajador(PriorityQueue<Ser> demandantes, Stack<Factorias> industrias) {
		demandantes.add(industrias.peek().despedirTrabajador());
	}

	public float calcularOcupacionTotal(Stack<Factorias> industrias) {
		float porcentajeOcupacion = 0;
		int numeroIndustrias = industrias.size();

		for (Factorias i : industrias) {
			porcentajeOcupacion += (i.getNumeroTrabajadores() * 100) / MAX_TRABAJADORES;
		}

		return porcentajeOcupacion / numeroIndustrias;
	}

	public float calcularProduccionTotal(Stack<Factorias> industrias) {
		float produccion = 0;

		for (Factorias i : industrias) {
			produccion += i.getNumeroTrabajadores() * MAX_TRABAJADORES;
		}
		return produccion;
	}

	public void eliminarTrabajadoresMuertos(ArrayList<Ser> muertos) {
		for (Factorias empresa : industrias) {
			for (Ser ser : muertos) {
				if (empresa.getTrabajadores().contains(ser)) {
					empresa.trabajadorMuerto(ser);
				}
			}
		}
	}
}
