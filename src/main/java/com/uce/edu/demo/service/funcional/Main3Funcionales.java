package com.uce.edu.demo.service.funcional;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.jboss.logging.Logger;

import com.uce.edu.demo.ProyectoU3CmApplication;


public class Main3Funcionales {
	
	private static Logger logger = Logger.getLogger(ProyectoU3CmApplication.class);

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//supplier
		logger.info(" supplier hecho con java :  ");
		 Stream.generate(new Random()::nextInt)
		    .limit(5).forEach(System.out::println);
		 
		 //consumer
		 logger.info("consumer hecho con java :  ");
		 List<String> collected = 
				  Stream.of("a", "b", "c")
				  .map(string -> string.toUpperCase())   
				  .collect(Collectors.toList());
		 assertEquals(Arrays.asList("A", "B", "C"), collected); 
		 collected.forEach(valor->System.out.println(valor));
		 
		 //predicate
		 List<String> listaNombres = new ArrayList<String>();
		 logger.info("predicate hecho con java :  ");
		 listaNombres.add("Pedro");
		 listaNombres.add("Miguel");
		 listaNombres.add("Ana");
		 listaNombres.add("Isabel");
		 listaNombres.add("MariaPilar");
		
		 Predicate<String> filtro7 = (nombre) -> nombre.length() <= 7;
		 
		 listaNombres.stream().filter(filtro7).forEach(nombre -> System.out.println(nombre));
		
		//FUNCTION
		 logger.info("function hecho con java");
		 List<Integer> listaNumeros = Arrays.asList(1,2,3,4,5);
			Stream<String> listaCambiada =  listaNumeros.stream().map(numeroLista -> {
				Integer valor = numeroLista +1 ;
				String cadena = "num : "+ valor.toString(); 
				return cadena;
			});
			listaCambiada.forEach(valor -> System.out.println(valor));
			
		//UNARYOPERATOR
		logger.info("UNARYOPERATOR hecho con java");
		List<String> listaNombre = Arrays.asList("ana","abel","monica","rafael");
		Stream<String> listaCambiada2 =  listaNombre.stream().map(numeroLista -> {
			String valor = numeroLista + " apellido" ;
			String cadena = "num : "+ valor.toString(); 
			return cadena;
		});
		listaCambiada2.forEach(valor -> System.out.println(valor));
		
	}
	
	
	

}
