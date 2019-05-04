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
	DatosEstadoGlobal datosEstadoGlobal = new DatosEstadoGlobal(estado.getIndustrias().getDemanda(), estado.getIndustrias().calcularProduccionTotal(industrias), estado.getFinanzas().getFondosEstado(), crecimientoAnual);	
	DatosEstadoLocal datosEstadoLocal = new DatosEstadoLocal(estado.getIndustrias().getIndustrias().size(), estado.getIndustrias().calcularOcupacionTotal(industrias));
	DatosPoblacion datosPoblacion = new DatosPoblacion(estado.getPoblacion().getPoblacion().size(), estado.menores(), estado.trabajadores(), estado.jubilados(), estado.nacimientos(), estado.muerto(), estado.jubilaciones(), nuevosTrabajadores);
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
