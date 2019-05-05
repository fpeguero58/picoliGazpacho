package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import modelo.vista.Datos;
import modelo.vista.DatosEstadoGlobal;
import modelo.vista.DatosEstadoLocal;
import modelo.vista.DatosPoblacion;
import modelo.vista.Estado;
import vista.Comunicador;
import vista.UI;

public class ParaUI extends UI {

	Estado estado = new Estado();
	// GLOBAL
	double demanda = estado.getIndustrias().getDemanda();
	double produccion = estado.getIndustrias().getProduccion();
	double capitalEstatal = estado.getFinanzas().getFondosEstado();
	double crecimientoAnual = 0; // TODO;
	// LOCAL
	int grandes = estado.getIndustrias().getIndustrias().size();
	float porcentajeGrandes = estado.getIndustrias().calcularOcupacionTotal();
	// POBLACION
	long habitantes = estado.getPoblacion().getPoblacion().size();
	long menores = estado.getPoblacion().numeroMenores();
	long trabajadores = estado.getPoblacion().numeroTrabajadores();
	long jubilados = estado.getPoblacion().numeroJubilados();
	long nacimientos = estado.getPoblacion().getNacimientos();
	long fallecimientos = estado.getPoblacion().getMuertos();
	long jubilaciones = estado.getPoblacion().getJubiladosNuevos();
	long nuevosTrabajadores = estado.getIndustrias().getNumeroTrabajadoresNecesarios();

	public ParaUI() {
		getBtnIncrementarPorcentajeProduccion().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				estado.getIndustrias().aumentarDemanda();
			}
		});
		getBtnDecrementarPorcentajeProduccion().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				estado.getIndustrias().reducirDemanda();
			}
		});
		getBtnPasarPeriodo().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				estado.play();
				DatosEstadoGlobal datosEstadoGlobal = new DatosEstadoGlobal(demanda, produccion, capitalEstatal,
						crecimientoAnual);
				DatosEstadoLocal datosEstadoLocal = new DatosEstadoLocal(grandes, porcentajeGrandes);
				DatosPoblacion datosPoblacion = new DatosPoblacion(habitantes, menores, trabajadores, jubilados,
						nacimientos, fallecimientos, jubilaciones, nuevosTrabajadores);
				setDatosEnElInterfazUsuario(datosPoblacion, datosEstadoLocal, datosEstadoGlobal);
			}
		});
	}

	public void setDatosEnElInterfazUsuario(DatosPoblacion datosPoblacion, DatosEstadoLocal datosEstadoLocal,
			DatosEstadoGlobal datosEstadoGlobal) {
		rellenarComunicador(comunicadorPoblacion, datosPoblacion);
		rellenarComunicador(comunicadorEstadoLocal, datosEstadoLocal);
		rellenarComunicador(comunicadorEstadoGlobal, datosEstadoGlobal);
	}

	public void rellenarComunicador(Comunicador comunicador, Datos datos) {
		comunicador.asignarValores(datos);
	}

}
