package modelo.vista;

import static org.junit.jupiter.api.Assertions.*;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Stack;

import org.junit.jupiter.api.Test;

class CensoTest {

	@Test
	void testMorir() {
	Ser t1=new Ser("pepe", 1234, 55);
	t1.setEdad(56);
	Ser t2=new Ser("carlos", 1324, 10);
	t2.setEdad(8);
	Ser t3=new Ser("ivan", 1543, 69);
	t3.setEdad(70);
	Censo censo=new Censo();
	censo.getPoblacion().add(t1);
	censo.getPoblacion().add(t2);
	censo.getPoblacion().add(t3);
	ArrayList<Ser>muertosTest=new ArrayList<Ser>();
	muertosTest.add(t1);
	System.out.println(censo.getPoblacion().size());
	ArrayList<Ser>muertos=censo.morir();
	assertTrue(muertos.containsAll(muertosTest));
	System.out.println(censo.getPoblacion().size());
	
	}
	@Test
	void testIndustria() {
		Ser t1=new Ser("pepe", 1234, 70);
		t1.setEdad(56);
		Ser t2=new Ser("carlos", 1324, 80);
		t2.setEdad(25);
		Ser t3=new Ser("ivan", 1543, 60);
		t3.setEdad(19);
		
		Factorias f1=new Factorias(0000);
		MinisterioIndustria mI=new MinisterioIndustria();
		Stack<Factorias> Ftest=new Stack<>();
		f1.contratarTrabajador(t1);
		f1.contratarTrabajador(t2);
		f1.contratarTrabajador(t3);
		ArrayList<Ser> s=new ArrayList<>();
		s.add(t2);
		s.add(t3);
		Ftest=mI.getIndustrias();
		Ftest.add(f1);
		mI.getIndustrias().add(f1);
		assertTrue(mI.getIndustrias().get(1).getTrabajadores().containsAll(s));
		mI.eliminarTrabajadoresMuertos(s);
		System.out.println(mI.getIndustrias().get(1).getTrabajadores().containsAll(s));
		assertFalse(mI.getIndustrias().get(1).getTrabajadores().containsAll(s));
	
	}
}
