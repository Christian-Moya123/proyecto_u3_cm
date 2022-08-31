package com.uce.edu.demo.hilos.tradicional;

import java.util.concurrent.TimeUnit;

public class PCCajero {
	public void procesar(Cajero cajero) {
		System.out.println("nombre hilo processaar: " + Thread.currentThread().getName());
		System.out.println("precesando cajero: " + cajero);
		for(String cliente: cajero.getClientes()) {
			this.atenderCliente(cliente);
			
		}
		
	}
	
	private void atenderCliente(String cliente) {
		System.out.println("atendiendo cliente "+ cliente);
		//demora el metodo 10 segundos
		try {
			TimeUnit.SECONDS.sleep(10);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		

}
