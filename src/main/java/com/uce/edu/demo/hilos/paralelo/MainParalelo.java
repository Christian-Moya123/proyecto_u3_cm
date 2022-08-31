package com.uce.edu.demo.hilos.paralelo;

import java.util.Arrays;

public class MainParalelo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long tiempoInicial = System.currentTimeMillis();
		
		System.out.println("nombre hilo: " + Thread.currentThread().getName());
		CajeroParalelo cajero1 = new CajeroParalelo("edison", Arrays.asList("pepe"));
		CajeroParalelo cajero2 = new CajeroParalelo("edison 2", Arrays.asList("pepe 2"));
		CajeroParalelo cajero3 = new CajeroParalelo("edison 3", Arrays.asList("pepe 3 "));
		
		CajeroParalelo cajero4 = new CajeroParalelo("edison", Arrays.asList("juan"));
		CajeroParalelo cajero5 = new CajeroParalelo("edison 2", Arrays.asList("juan 2"));
		CajeroParalelo cajero6 = new CajeroParalelo("edison 3", Arrays.asList("juan 3"));
		
		PCCajeroParalelo gestorAtencion = new PCCajeroParalelo(cajero1);
		gestorAtencion.start();//ejectuta el procesar
		
		PCCajeroParalelo gestorAtencion2 = new PCCajeroParalelo(cajero2);
		gestorAtencion2.start();
		
		PCCajeroParalelo gestorAtencion3 = new PCCajeroParalelo(cajero3);
		gestorAtencion3.start();
		
		PCCajeroParalelo gestorAtencion4 = new PCCajeroParalelo(cajero4);
		gestorAtencion4.start();//ejectuta el procesar
		
		PCCajeroParalelo gestorAtencion5 = new PCCajeroParalelo(cajero5);
		gestorAtencion5.start();
		
		PCCajeroParalelo gestorAtencion6 = new PCCajeroParalelo(cajero6);
		gestorAtencion6.start();
		
		
		
		long tiempoFinal = System.currentTimeMillis();
		long tiempoTrancurrido = ( tiempoFinal - tiempoInicial)/1000;		
		
		System.out.println(tiempoTrancurrido+ " seg");
		
	}

}
