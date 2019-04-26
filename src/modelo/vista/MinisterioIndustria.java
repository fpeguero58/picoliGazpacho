package modelo.vista;

import java.util.Stack;

public class MinisterioIndustria {
	private Stack <Factorias> industrias= new Stack<Factorias>();

	public Stack <Factorias> getIndustrias() {
		return industrias;
	}

	public void setIndustrias(Stack <Factorias> industrias) {
		this.industrias = industrias;
	} 
}
