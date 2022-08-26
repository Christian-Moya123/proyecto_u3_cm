package com.uce.edu.demo.service.funcional;

import org.jboss.logging.Logger;

import com.uce.edu.demo.ProyectoU3CmApplication;

public class Main2Funcionales {

	private static Logger logger = Logger.getLogger(ProyectoU3CmApplication.class);

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ConsumoMetodoHighOrder consumo = new ConsumoMetodoHighOrder();

		//SUPPLIER
		//clase
		IPersonaSupplier<String> supplierClase = new PersonaSupplierImpl();
		logger.info("Supplier Clase: " + supplierClase.getNombre());
		
		//lambdas
		IPersonaSupplier<String> supplierLambda = () -> "Christian";
		logger.info("Supllier Lambda :  " + supplierLambda.getNombre());
		
		//High Order
		String supplierHighOrder = consumo.consumirSupplier(() -> "Alexander " );
		logger.info("Supllier High Order :  " + supplierHighOrder);
		
		logger.info("////////////////////////////////");
		//CONSUMER
		//clase
		IPersonaConsumer<String> consumerClase = new PersonaConsumerImpl();
		consumerClase.accept("Comporovacion consumo");
		
		//lambdas
		IPersonaConsumer<String> consumerLambda = cadena -> System.out.println(cadena);
		consumerLambda.accept("Prueba consumo Lambda");
		
		//High Order
		 consumo.consumirConsumer(nombre -> System.out.println(nombre), "mia");
		 logger.info("////////////////////////////////");
		 
		//Predicate
		//clase
		 IPersonaPredicate<String> predicateClase = new PersonaPredicateImpl();
		 String nombre = "Christian";
		 predicateClase.evaluar(nombre);
		 logger.info("Predicate Lambda :  " + predicateClase.evaluar("Chistian"));	
		 
		//lambdas
		 IPersonaPredicate<String> predicateLambda = cadena -> cadena.contains("Z");
		 logger.info("Predicate Lambda :  " + predicateLambda.evaluar("Chistian"));	
			
		//High Order
		 boolean respuesta = consumo.consumirPredicate(cadena -> cadena.contains("s"), "Edizon");
		logger.info("HO1 consumer :  " + respuesta);
		logger.info("////////////////////////////////");	
		
		//FUNCTION
		//clases
		IPersonaFunction<Integer, String> personaFunction = new PersonaFunctionImpl();
		String nombre1 = "Abel";
		logger.info("Function clase :  " + personaFunction.aplicar(nombre1));
			
		//lambdas
		IPersonaFunction<Integer, String> functionLambda = cadena -> { 
			Integer valor = Integer.parseInt(cadena);
			Integer valorFinal = valor-2;
			return valorFinal;
		};
		logger.info("Function Lambda :  " + functionLambda.aplicar("7"));	
			
		//High Order
		String valorFinalHO = consumo.consumirFunction(valor -> {
			String retorno = valor.toString()+"A";
			return retorno;
			
		}, 1);
		logger.info("HO1 functionr :  " + valorFinalHO);
		logger.info("////////////////////////////////");
		
		//UNARYOPERATOR
		//clases
		IPersonaUnaryOperator<String> unaryClase = new PersonaUnaryOperator();
		String nombre2 = "ejemplo";
		logger.info(" unary Clase perator :  " + unaryClase.apply(nombre2));
		
		//lambdas
		IPersonaUnaryOperator<String> unaryLambda = cadena ->{
			String valorFinal = cadena.concat("auxiliar");
			return valorFinal;
		};
		logger.info(" unary Clase lambda:  " + unaryLambda.apply("Daniel"));
		
		//High Order
		 String a = consumo.consumirUnaryOperator(cadena ->{
			String valorFinal = cadena.concat("auxiliar");
			return valorFinal;
		}, "Abhel");
		logger.info(" unary High Order:  " + a);
	}

}
