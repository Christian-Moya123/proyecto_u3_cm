package com.uce.edu.demo.service.funcional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import org.jboss.logging.Logger;
import org.springframework.context.support.StaticApplicationContext;

import com.uce.edu.demo.ProyectoU3CmApplication;

public class MainInterfacesFuncionales {
	
	private static Logger logger = Logger.getLogger(ProyectoU3CmApplication.class);
	public static boolean prueba (Integer numero) {
		
		return numero >= 3;
	}
	public static void imprimir(String cadena) {
		logger.info("imprimir "+ cadena );
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ConsumoMetodoHighOrder consumo = new ConsumoMetodoHighOrder();
		
	
		
		
		//SUPPLIER
		//clases
		
		IPersonaSupplier<String> supplier = new PersonaSupplierImpl();
		logger.info("Supllier Clase: " + supplier.getNombre());
		
		IPersonaSupplier<String> supplierTE =  new PersonaSupplierImpl();
		logger.info("Supllier Clase 2 : " + supplierTE.getNombre());
		
		String valorHO = consumo.consumirSupplier(() -> "Hola mundo");
		logger.info("HO supplier :  " + valorHO);	
				
		String valorHO1 = consumo.consumirSupplier(() -> {
					String valorConsultado = "17200";
					return valorConsultado;}
				);
		logger.info("HO1 supplier :  " + valorHO1);
		
		//JAVA
		logger.info(" supplier hecho con java :  ");
		Stream<String> test = Stream.generate(()-> "Edison 3").limit(2);
		test.forEach(cadena -> System.out.println(cadena));
		
		
		//lambdas
		IPersonaSupplier<String> supplierLambda = () -> "Christian 2";
		logger.info("Supllier Lambda :  " + supplierLambda.getNombre());
		
		IPersonaSupplier<String> supplierLambdaTE = () -> "Daniel TE 2";
		logger.info("Supllier Lambda TE  :  " + supplierLambdaTE.getNombre());
		
	
		
		//CONSUMER
		//clases
		IPersonaConsumer<String> consumerClase = new PersonaConsumerImpl();
		consumerClase.accept("Prueba consumo");
		//metodos high order

		consumo.consumirConsumer(valor -> System.out.println(valor), 2);
		
		//lambdas
		IPersonaConsumer<String> consumerLambda = cadena -> System.out.println(cadena);
		consumerLambda.accept("Prueba consumo Lambda");
		
		//java
		logger.info("consumer hecho con java");
		List<Integer> listaNumeros = Arrays.asList(1,2,3,4,5);
		listaNumeros.forEach(valor -> System.out.println(valor));
		
		
		//PREDICATE
		//clases
		
		//lambdas
		IPersonaPredicate<String> predicateLambda = cadena -> cadena.contains("Z");
		
		logger.info("Predicate Lambda :  " + predicateLambda.evaluar("Chistian"));	
		
		boolean respuesta = consumo.consumirPredicate(cadena -> cadena.contains("Z"), "Edizon");
		logger.info("HO1 consumer :  " + respuesta);
		
		String valorFinalHO = consumo.consumirFunction(valor -> {
			String retorno = valor.toString()+"A";
			return retorno;
			
		}, 1);
		logger.info("HO1 functionr :  " + valorFinalHO);
		
		//jaava
		logger.info("predicate hecho con java");
		Stream<Integer> nuevaLista = listaNumeros.stream().filter(numero -> prueba(numero));
		nuevaLista.forEach(numero -> System.out.println(numero));
	
		//FUNCTION
		//clases
		//lambdas
		logger.info("////////////////////////////////");
		IPersonaFunction<Integer, String> functionLambda = cadena -> { 
			Integer valor = Integer.parseInt(cadena);
			Integer valorFinal = valor-2;
			return valorFinal;
		};
		logger.info("Function Lambda :  " + functionLambda.aplicar("7"));	
		
		//java
		logger.info("function hecho con java");
		Stream<String> listaCambiada =  listaNumeros.stream().map(numeroLista -> {
			Integer valor = numeroLista +1 ;
			String cadena = "num : "+ valor.toString(); 
			return cadena;
		});
		listaCambiada.forEach(valor -> imprimir(valor));
		
		//UNARYOPERATOR
		//clases
		//lambdas
		IPersonaUnaryOperator<String> unaryLambda = cadena ->{
			String valorFinal = cadena.concat("sufijo");
			return valorFinal;
		};
				
		unaryLambda.apply("Daniel");

		
	
		
		
		
		
	
	}
	

}
