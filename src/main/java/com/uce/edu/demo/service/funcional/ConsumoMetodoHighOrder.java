package com.uce.edu.demo.service.funcional;

public class ConsumoMetodoHighOrder {
	
	public String consumirSupplier(IPersonaSupplier<String> funcion) {
		/*String valor = funcion.getNombre();
		Integer numero = Integer.parseInt(valor);
		return numero;*/
		return funcion.getNombre() + "se proceso el dato";
	}
	
	public void consumirConsumer(IPersonaConsumer<Integer> funcion, Integer valor) {
		funcion.accept(valor);
	}
	
	public boolean consumirPredicate(IPersonaPredicate<String> funcion , String valor) {
		return funcion.evaluar(valor);
	}
	
	public String consumirFunction(IPersonaFunction<String, Integer> funcion, Integer valor ) {
		return funcion.aplicar(valor);
	}
	
	public void consumirConsumer(IPersonaConsumer<String> funcion, String valor) {
		funcion.accept(valor);
	}
	
	public String consumirUnaryOperator(IPersonaUnaryOperator<String> funcion, String valor) {
		return funcion.apply(valor);
	}
}
