package com.uce.edu.demo.service.funcional;

public class PersonaUnaryOperator implements IPersonaUnaryOperator<String>{

	@Override
	public String apply(String arg1) {
		// TODO Auto-generated method stub
		String a="";
		String valorFinal = arg1.concat(arg1);
		return valorFinal;
	}

	

}
