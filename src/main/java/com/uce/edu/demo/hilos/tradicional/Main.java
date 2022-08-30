package com.uce.edu.demo.hilos.tradicional;

import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long tiempoInicial = System.currentTimeMillis();
		
		Cajero cajero1 = new Cajero("edison", Arrays.asList("pepe","juan", "daniela", "pedro"));
		Cajero cajero2 = new Cajero("edison 2", Arrays.asList("pepe 2","juan 2", "daniela 2"));
		Cajero cajero3 = new Cajero("edison 3", Arrays.asList("pepe 3 ", "pedro 3"));
		
		PCCajero gestorAtencion = new PCCajero();
		gestorAtencion.procesar(cajero1);
		gestorAtencion.procesar(cajero2);
		gestorAtencion.procesar(cajero3);
		
		long tiempoFinal = System.currentTimeMillis();
		long tiempoTrancurrido = ( tiempoFinal - tiempoInicial)/1000;		
		
		System.out.println(tiempoTrancurrido+ " seg");
		
	}

}
