package modelo.vista;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;

public class Estado {
	float capital;
	int demanda;
	int jubilaciones;
	int nacimientos;
	final int capitalMinimo = 96725;
	ArrayDeque<Mayores> colaDemanda = new ArrayDeque<>();
//	LinkedList<Integer> lista = new LinkedList<Integer>();
	HashSet<Integer> identificacion = new HashSet<Integer>();
	ArrayList<Menor> listaMenores=new ArrayList<Menor>();
	ArrayList<Mayores> listaMayores=new ArrayList<Mayores>();
	ArrayList<Jubilados> listaJubilados=new ArrayList<Jubilados>();
	ArrayList<Mayores> listaTrabajadores=new ArrayList<Mayores>();
	ArrayList<Ser> Poblacion=new ArrayList<Ser>();

	public String crearNombre() {
		String nombre = "";
		int indice;
		for (int i = 0; i < 10; i++) {
			indice = (int) (Math.random() * (122 - 97) + 97);
			nombre = nombre + (char) (indice);
		}
		return nombre;
	}

	public int CrearIdentificacion() {
		int indice;
		do {
			indice = (int) (Math.random() * 9999999);
			System.out.println(indice);
		} while (!identificacion.add(indice));
		return indice;
	}
	public void imprimirColleccion() {
//		for (Integer i : identificacion) {
//		System.out.println(i);	
//		}
		System.out.println("poblacion");
		for (Ser ser : Poblacion) {
			System.out.println(ser.getClass());
		}
	}
	public void crearSeres() {
		//TODO
		String nombre;
		int numeroIdentificacion;
		int esperanzaVida;
		int edad=0;
		nombre=crearNombre();
		numeroIdentificacion=CrearIdentificacion();
		esperanzaVida=(int)(Math.random()*(90));
		Menor menor=new Menor(nombre, numeroIdentificacion, esperanzaVida);
	}
	
	public void agregarElementoAcoleccion(Collection<Object> coleccion,Object elemento) {
		coleccion.add(elemento);
	}
	public void repartirSubenciones() {
		capital=calcularCapital();
		if(capital<listaMenores.size()*365) {
			for (Menor menor : listaMenores) {
				menor.setNecesidadVital((int)capital/listaMenores.size());
			}
			capital=0;
		}else if(capital<colaDemanda.size()*(365f/2)+listaMenores.size()*365){
			capital-=listaMenores.size()*365;
			for (Mayores parado : colaDemanda) {
				parado.setNecesidadVital((int)capital/colaDemanda.size());
			}
			capital=0;
		}else if(capital<listaJubilados.size()*(365f/2)+colaDemanda.size()*(365f/2)+listaMenores.size()*365){
			capital-=colaDemanda.size()*365f/2;
			for (Jubilados jubilado : listaJubilados) {
				jubilado.setNecesidadVital((int)capital/listaJubilados.size());
			}
			capital=0;
		}else {
			capital-=listaJubilados.size()*(365f/2)+colaDemanda.size()*(365f/2)+listaMenores.size()*365;
		}
	}
	public void eliminarSer() {
		for (Ser ser : Poblacion) {
			if(ser.morir) {
				if(ser.getClass()==Mayores.class) {
					listaMayores.remove(ser);
					listaTrabajadores.remove(ser);
					colaDemanda.remove(ser);
					recolectarAhorros((Mayores)ser);
				}else if(ser.getClass()==Jubilados.class) {
					listaJubilados.remove(ser);
					recolectarAhorros((Jubilados)ser);
				}else if(ser.getClass()==Menor.class) {
					listaMenores.remove(ser);
				}
				Poblacion.remove(ser);
			}
		}
	}
	public void evolucionar(Ser ser) {
		if(ser.getClass()==Menor.class&&((Menor)ser).mayoriaEdad()) {
			Mayores mayor=(Mayores) convertir(ser);
			listaMenores.remove(ser);
			agregarElementoAcoleccion((Collection)listaMayores, mayor);
		}else if(ser.getClass()==Mayores.class&&((Mayores)ser).edadJubilacion()) {
			Jubilados jubilado=(Jubilados) convertir(ser);
			listaMayores.remove(ser);
			agregarElementoAcoleccion((Collection)listaJubilados, ser);
			actualizarColleccion(ser);
		}
	}
	public void actualizarColleccion(Ser ser) {
			if(!listaMayores.contains(ser)) {
				listaTrabajadores.remove(ser);
				colaDemanda.remove(ser);
			}
	}
	public Ser convertir(Ser ser) {
		int esperanzaVida=ser.getEsperanzaVida();
		String nombre=ser.getNombre();
		int numeroIdentificacion=ser.getNumeroIdentificacion();
		int edad;
		Ser serNuevo = null;
		if(ser.getClass()==Menor.class) {
			serNuevo=new Mayores(nombre, numeroIdentificacion, esperanzaVida); 
		}else if(ser.getClass()==Mayores.class) {
			serNuevo=new Jubilados(nombre, numeroIdentificacion, esperanzaVida); 
		}
		return serNuevo;
	}
	public void recolectarAhorros(Mayores ser) {
		capital+=ser.getAhorros();
	}
	public void recolectarAhorros(Jubilados ser) {
		capital+=ser.getAhorros();
	}
	
	public float calcularCapital() {
		return capital+=listaTrabajadores.size()*(1000-(365*0));
	}
//	No tocar este main es donde pruebo las cosas Tu morito Issam
//	public static void main(String[] args) {
//		Estado estado = new Estado();
//		for (String string : args) {
//			
//		}
//		Mayores mayor=new Mayores("PACO", 1, 50, 0);
////		estado.agregarElementoAcoleccion((Collection)estado.listaTrabajadores, mayor);
////		estado.listaMenores.remove(mayor);
////		estado.CrearIdentificacion();
////		estado.CrearIdentificacion();
////		estado.CrearIdentificacion();
////		estado.CrearIdentificacion();
//		Jubilados jubilado=new Jubilados("pico", 2, 87, 67);
//		jubilado.setAhorros(50);
//		estado.listaJubilados.add(jubilado);
//		System.out.println(estado.listaJubilados.contains(jubilado));
//		estado.Poblacion.add(mayor);
//		estado.Poblacion.add(jubilado);
//		estado.imprimirColleccion();
////		for (Ser ser : estado.Poblacion) {
////			System.out.println(ser.getClass());
////		}
////		estado.recolectarAhorros(jubilado);
////		System.out.println(estado.calcularCapital());
////		System.out.println(mayor.getClass()==Mayores.class);
////		System.out.println(estado.listaMenores.remove(mayor));
////		System.out.println("capital");
////		System.out.println(estado.capital);
////		estado.imprimirColleccion();
//	}
}
