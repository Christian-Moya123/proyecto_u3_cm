package com.uce.edu.demo.tarea35;

import java.util.concurrent.TimeUnit;

public class Banco extends Thread{
	
	private String nombre;
	private Cliente cliente;
	private long tiempoInicial;
	
	
	
	
	public Banco(String nombre, Cliente cliente, long tiempoInicial) {
		super();
		this.nombre = nombre;
		this.cliente = cliente;
		this.tiempoInicial = tiempoInicial;
	}

	public void run() {
		System.out.println("la cajera  " + this.nombre + "  comienza a procesar el cliente"
				+this.cliente.getNombre()+ " en el tiempo"
				+(System.currentTimeMillis()-this.tiempoInicial)/1000
				+ " seg");
		
		for (Integer clienteA: cliente.getCarroCompra()) { 
			this.esperarXSegundo(clienteA); 
			System.out.println("Procesado el producto " 
			+ " del cliente " + this.cliente.getNombre() + "->Tiempo: " 
			+ (System.currentTimeMillis() - this.tiempoInicial) / 1000 
			+ "seg");
		}

		System.out.println("La cajera " + this.nombre + " HA TERMINADO DE PROCESAR " 
						+ this.cliente.getNombre() + " EN EL TIEMPO: " 
						+ (System.currentTimeMillis() - this.tiempoInicial) / 1000 
						+ "seg");
		
	}
	
	private void esperarXSegundo(int segundos) {
		System.out.println("atendiendo cliente "+ cliente.getNombre());
		//demora el metodo 10 segundos
		try {
			TimeUnit.SECONDS.sleep(5);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
