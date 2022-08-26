package com.uce.edu.demo.service.funcional;

public class PersonaPredicateImpl implements IPersonaPredicate<String>{

	@Override
	public boolean evaluar(String arg1) {
		// TODO Auto-generated method stub
		
		boolean nombre = arg1.contains("a");
		return nombre;
	}

}
