package com.uce.edu.demo.tarea35;

import java.util.List;

public class Cliente {
	private String nombre;
	private List<Integer> carroCompra;
	
	public Cliente(String nombre, List<Integer> carroCompra) {
		super();
		this.nombre = nombre;
		this.carroCompra = carroCompra;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public List<Integer> getCarroCompra() {
		return carroCompra;
	}
	public void setCarroCompra(List<Integer> carroCompra) {
		this.carroCompra = carroCompra;
	}
	
	
	

}
