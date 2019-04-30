package modelo.vista;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

public class MinisterioEconomia {
	private float fondosEstado;

	public float getFondosEstado() {
		return fondosEstado;
	}

	public void setFondosEstado(float fondosEstado) {
		this.fondosEstado = fondosEstado;
	}
	
	public void cobrarImpuestos(Stack <Mayores> trabajadores) {
		for(Mayores m: trabajadores) {
			fondosEstado+=m.getSueldo()/4;
			m.setSueldo(m.getSueldo()/4);
		}
	}
	
	public void pagarSubvenciones(ArrayList <Ser> subvencionables) {
		
	}
	
}
