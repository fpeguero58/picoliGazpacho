package modelo.vista;

import static org.junit.jupiter.api.Assertions.*;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Stack;

import org.ietf.jgss.Oid;
import org.junit.Ignore;
import org.junit.jupiter.api.Test;

class CensoTest {

	@Ignore
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
	censo.organizarColeccionciones();
	int posFinal=0;
	for (int i = 0; i < censo.getPoblacion().size(); i++) {
		if (censo.getPoblacion().get(i).getEdad()<18) {
			posFinal=i;
		}
	}
	Ser[] seres=new Ser[5];
	for (int i = 0; i < 5; i++) {
		Ser ser =new Ser("PACO "+i, i, 67+i);
		seres[i]=ser;
		ser.setAhorros(460);
		ser.setNecesidadVital(365);
		censo.getPoblacion().add(ser);
	}
	System.out.println("antes de los cambios");
	for (int i = 0; i < seres.length; i++) {
		System.out.println("esperanza de vida: "+seres[i].getEsperanzaVida());
		System.out.println("ahorros: "+seres[i].getAhorros());
	}
	censo.reducirEV();
	System.out.println("despues de los cambios");
	for (int i = 0; i < seres.length; i++) {
		System.out.println("esperanza de vida: "+seres[i].getEsperanzaVida());
		System.out.println("ahorros: "+seres[i].getAhorros());
	}

	System.out.println("????????????????");
	System.out.println(censo.numeroTrabajadores());
	System.out.println(censo.numeroJubilados());
	Censo cesi=new Censo();
	System.out.println(cesi.getPoblacion().size());
//	System.out.println(posFinal);
	
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
//		System.out.println(mI.getIndustrias().get(1).getTrabajadores().containsAll(s));
		assertFalse(mI.getIndustrias().get(1).getTrabajadores().containsAll(s));
		//eliminar Industrias
		
		//elementos
		
		Factorias fE1=new Factorias(1);
		Factorias fE2=new Factorias(2);
		Factorias fE3=new Factorias(3);
		ArrayList<Factorias> facArrayList=new ArrayList<Factorias>();
		
		Factorias[] listaFactorias= {fE1,fE2,fE3};
		for (int i = 0; i < 400; i++) {
			Ser ser=new Ser("paco", i, 67);
			fE1.contratarTrabajador(ser);
		}
		for (int i = 0; i < 400; i++) {
			Ser ser=new Ser("juanjo", i, 67);
			fE2.contratarTrabajador(ser);
		}
		for (int i = 0; i < 400; i++) {
			Ser ser=new Ser("jesus", i, 67);
			fE3.contratarTrabajador(ser);
		}
		mI.getIndustrias().clear();
		for (int i = 0; i < listaFactorias.length; i++) {
			mI.getIndustrias().add(listaFactorias[i]);
			facArrayList.add(listaFactorias[i]);
		}
//		System.out.println(mI.getIndustrias().size());
		System.out.println("<=============================>");
		System.out.println();
//		System.out.println(fE1.getTrabajadores().size(
		assertTrue(mI.getIndustrias().containsAll(facArrayList));
		mI.eliminaIndustrias();
		assertFalse(mI.getIndustrias().containsAll(facArrayList));
		mI.pagarSueldos();
		Censo censo=new Censo();
		System.out.println(censo.numeroMenores());
		//		System.out.println(mI.getIndustrias().size());
		Estado estado =new Estado();
//		System.out.println(estado.getPoblacion().numeroTrabajadores());
			estado.getPoblacion().getPoblacion().size();
			System.out.println("SSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSS");
			for (Factorias factorias : estado.getIndustrias().getIndustrias()) {
				System.out.println(factorias.getNumeroTrabajadores());
			}
			estado.play();
			System.out.println("SSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSS");
			for (Factorias factorias : estado.getIndustrias().getIndustrias()) {
				System.out.println(factorias.getNumeroTrabajadores());
			}
//		System.out.println(estado.getIndustrias().getDemanda());
//		estado.getIndustrias().aumentarDemanda();
//		System.out.println(estado.getIndustrias().getDemanda());

//		for (Ser ser : estado.getPoblacion().getPoblacion()) {
//			System.out.println(ser.getNombre());
//		}
	}
}
