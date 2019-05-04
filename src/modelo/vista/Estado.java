package modelo.vista;

import java.util.ArrayList;

public class Estado {
    private MinisterioEconomia finanzas = new MinisterioEconomia();
    private MinisterioIndustria industrias = new MinisterioIndustria();
    private MinisterioTiempo controlTiempo= new MinisterioTiempo();
    private Censo poblacion = new Censo();

    public void play() {
        poblacion.morir();
        industrias.jubilarTrabajadores();
        industrias.contratarDemandantes(poblacion.getDemandantes());
        controlTiempo.realizarCiclo(poblacion.getPoblacion());
        industrias.pagarSueldos();
        

    }
    public int nacimientos() {
    	return poblacion.getNacimientos();
    }
    public int muerto() {
    	return poblacion.getNacimientos();
    }
    public int jubilaciones() {
    	int posFinal=0;
    	int posInicial=0;
    	
    		for (int i = 0; i < poblacion.getPoblacion().size(); i++) {
    			if (poblacion.getPoblacion().get(i).getEdad()<65) {
					posInicial=i;
				}
    			if (poblacion.getPoblacion().get(i).getEdad()==65) {
    				posFinal=i;
    			}
    		}
    	return posFinal-posInicial;
    }
    public int jubilados() {
    	int posInicial=0;
    	for (int i = 0; i < poblacion.getPoblacion().size(); i++) {
			if (poblacion.getPoblacion().get(i).getEdad()<65) {
				posInicial=i;
			}
    	}
		return poblacion.getPoblacion().size()-posInicial;
	}
    public int menores() {
    	int posInicial=0;
    	for (int i = 0; i < poblacion.getPoblacion().size(); i++) {
			if (poblacion.getPoblacion().get(i).getEdad()<18) {
				posInicial=i;
			}
    	}
		return posInicial;
	}
    public int trabajadores() {
    	int total=0;
    	for (int i = 0; i < poblacion.getPoblacion().size(); i++) {
			if (poblacion.getPoblacion().get(i).getEdad()>17 && poblacion.getPoblacion().get(i).getEdad()<65) {
				total++;
			}
    	}
		return total-poblacion.getDemandantes().size();
	}

}
