package com.uce.edu.demo.tarea35;

import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long tiempoInicial = System.currentTimeMillis();
		
		Cliente cliente1 = new Cliente("Cliente 1", Arrays.asList(2, 2, 1, 5, 2, 3));
		Cliente cliente2 = new Cliente("Cliente 2", Arrays.asList( 1, 3, 5, 1, 1));
		Cliente cliente3 = new Cliente("Cliente 3", Arrays.asList( 1, 2,3));
		Cliente cliente4 = new Cliente("Cliente 4", Arrays.asList( 1, 3, 1,2));
		Cliente cliente5 = new Cliente("Cliente 5", Arrays.asList( 5, 1, 1));

		// Tiempo inicial de referencia
		long initialTime = System.currentTimeMillis();
		Banco cajera1 = new Banco("Cajera 1", cliente1, initialTime);
		Banco cajera2 = new Banco("Cajera 2", cliente2, initialTime);
		Banco cajera3 = new Banco("Cajera 3", cliente3, initialTime);
		Banco cajera4 = new Banco("Cajera 4", cliente4, initialTime);
		Banco cajera5 = new Banco("Cajera 5", cliente5, initialTime);

		cajera1.start();
		cajera2.start();
		cajera3.start();
		cajera4.start();
		cajera5.start();
		
		long tiempoFinal = System.currentTimeMillis();
		long tiempoTrancurrido = ( tiempoFinal - tiempoInicial)/1000;		
		
		System.out.println(tiempoTrancurrido+ " seg");

	}

}
