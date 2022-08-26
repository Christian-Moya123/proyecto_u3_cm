package com.uce.edu.demo.service.funcional;

public  class PersonaFunctionImpl implements IPersonaFunction<Integer, String>{



	@Override
	public Integer aplicar(String arg1) {
		// TODO Auto-generated method stub
		
		return arg1.length();
	}

}
