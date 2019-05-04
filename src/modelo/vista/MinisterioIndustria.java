package modelo.vista;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
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

	public void altaTrabajador(LinkedList<Ser> demandantes) {
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

	public void bajaTrabajador(LinkedList<Ser> demandantes) {
		demandantes.add(industrias.peek().despedirTrabajador());
	}

	public float calcularOcupacionTotal() {
		float porcentajeOcupacion = 0;
		int numeroIndustrias = industrias.size();

		for (Factorias i : industrias) {
			porcentajeOcupacion += (i.getNumeroTrabajadores() * 100) / MAX_TRABAJADORES;
		}

		return porcentajeOcupacion / numeroIndustrias;
	}

	public float calcularProduccionTotal() {
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

	public int contratarDemandantes(LinkedList<Ser> demandantes) {
		float produccion = calcularProduccionTotal();
		int numeroTrabajadoresNecesarios = 0;

		if (produccion < demanda) {
			numeroTrabajadoresNecesarios = (int) ((demanda - produccion) / 1000);
			for (int i = 0; i < numeroTrabajadoresNecesarios; i++) {
				altaTrabajador(demandantes);
			}
		}
		return numeroTrabajadoresNecesarios;
	}

	public void pagarSueldos() {

		for (Factorias i : industrias) {
			Stack<Ser> trabajadores = i.getTrabajadores();
			for (Ser s : trabajadores) {
				s.setAhorros(s.getAhorros() + 730);
			}
		}
	}

	public void bajaTrabajador(PriorityQueue<Ser> demandantes) {
		demandantes.add(industrias.peek().despedirTrabajador());
	}

	public void eliminaIndustrias() {
		int numeroPlazasDisponibles = 0;
		LinkedList<Ser> trabajadoresDisponibles = new LinkedList();
		Stack<Factorias> factoriasConPuestosLibres = new Stack<Factorias>();
		for (Iterator<Factorias> iterator = industrias.iterator(); iterator.hasNext();) {
			Factorias factorias = (Factorias) iterator.next();
			numeroPlazasDisponibles += MAX_TRABAJADORES - factorias.getNumeroTrabajadores();
			if (factorias.getNumeroTrabajadores() <= numeroPlazasDisponibles) {
				trabajadoresDisponibles.addAll(factorias.getTrabajadores());
				for (int j = 0; j <= numeroPlazasDisponibles / 1000; j++) {
					for (int i = 0; factoriasConPuestosLibres.size() < MAX_TRABAJADORES
							&& !trabajadoresDisponibles.isEmpty(); i++) {
						factoriasConPuestosLibres.get(j).getTrabajadores().add(trabajadoresDisponibles.pop());
					}
					
				}
				industrias.remove(factorias);
				
			} else {
				factoriasConPuestosLibres.add(factorias);
			}
		}
		
	}

}

