package com.uce.edu.demo.hilos.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

public class MainStreamParalelo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long tiempoInicial = System.currentTimeMillis();
		List<Integer> listaNumeroAlumnos = new ArrayList<>();
		for(int i= 1; i<5000;i++) {
			listaNumeroAlumnos.add(i);
		}
		List<String> listaProcesada = listaNumeroAlumnos.parallelStream().map(numero -> convertirIdAlumnos(numero)).
				collect(Collectors.toList());
		listaProcesada.forEach(cadena -> System.out.println(cadena));
		
		long tiempoFinal = System.currentTimeMillis();
		long tiempoTrancurrido = ( tiempoFinal - tiempoInicial)/1000;		
		
		System.out.println(tiempoTrancurrido+ " seg");

	}
	
	private static String convertirIdAlumnos(Integer id) {
		try {
			TimeUnit.MILLISECONDS.sleep(10);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "id" + id.toString();
	}
	

}
