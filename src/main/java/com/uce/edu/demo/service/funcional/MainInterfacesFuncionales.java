package com.uce.edu.demo.service.funcional;

import org.jboss.logging.Logger;

import com.uce.edu.demo.ProyectoU3CmApplication;

public class MainInterfacesFuncionales {
	
	private static Logger logger = Logger.getLogger(ProyectoU3CmApplication.class);

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//SUPPLIER
		//clases
		
		IPersonaSupplier<String> supplier = new PersonaSupplierImpl();
		logger.info("Supllier Clase: " + supplier.getNombre());
		
		IPersonaSupplier<String> supplierTE =  new PersonaSupplierImpl();
		logger.info("Supllier Clase 2 : " + supplierTE.getNombre());
		
		//lambdas
		IPersonaSupplier<String> supplierLambda = () -> "Christian 2";
		logger.info("Supllier Lambda :  " + supplierLambda.getNombre());
		
		IPersonaSupplier<String> supplierLambdaTE = () -> "Daniel TE 2";
		logger.info("Supllier Lambda TE  :  " + supplierLambdaTE.getNombre());
		
	
		
		//CONSUMER
		//clases
		IPersonaConsumer<String> consumerClase = new PersonaConsumerImpl();
		consumerClase.accept("Prueba consumo");
		
		//lambdas
		IPersonaConsumer<String> consumerLambda = cadena -> System.out.println(cadena);
		consumerLambda.accept("Prueba consumo Lambda");
		//PREDICATE
		//clases
		//lambdas
				
		
		
		//FUNCTION
		//clases
		//lambdas
				
		
		//UNARYOPERATOR
		//clases
		//lambdas
				

	}

}
