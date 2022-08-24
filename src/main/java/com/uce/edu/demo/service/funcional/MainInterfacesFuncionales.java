package com.uce.edu.demo.service.funcional;

import org.jboss.logging.Logger;

import com.uce.edu.demo.ProyectoU3CmApplication;

public class MainInterfacesFuncionales {
	
	private static Logger logger = Logger.getLogger(ProyectoU3CmApplication.class);

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
		
		
		//FUNCTION
		//clases
		//lambdas
		IPersonaFunction<Integer, String> functionLambda = cadena -> { 
			Integer valor = Integer.parseInt(cadena);
			Integer valorFinal = valor-2;
			return valorFinal;
		};
		logger.info("Function Lambda :  " + functionLambda.aplicar("7"));	
		
		
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
