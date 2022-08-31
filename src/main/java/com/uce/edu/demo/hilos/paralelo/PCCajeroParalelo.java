package com.uce.edu.demo.hilos.paralelo;

import java.util.concurrent.TimeUnit;

public class PCCajeroParalelo extends Thread{
	
	private CajeroParalelo cajero;
	
	
	public PCCajeroParalelo(CajeroParalelo cajero) {
		this.cajero = cajero;
	}
	
	//el run dispara el metodo paralelizar
	public void run() {
		this.procesar(this.cajero);
		
	}
	
	public void procesar(CajeroParalelo cajero) {
		long tiempoInicial = System.currentTimeMillis();

		System.out.println("nombre hilo processaar: " + Thread.currentThread().getName());
		System.out.println("precesando cajero: " + cajero);
		for(String cliente: cajero.getClientes()) {
			this.atenderCliente(cliente);
			
		}
		long tiempoFinal = System.currentTimeMillis();
		long tiempoTrancurrido = ( tiempoFinal - tiempoInicial)/1000;
		System.out.println("termino "  + cajero.getNombre() +" " + tiempoTrancurrido +  " seg");
		
	}
	
	private void atenderCliente(String cliente) {
		System.out.println("atendiendo cliente "+ cliente);
		//demora el metodo 10 segundos
		try {
			TimeUnit.SECONDS.sleep(5);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		

}
