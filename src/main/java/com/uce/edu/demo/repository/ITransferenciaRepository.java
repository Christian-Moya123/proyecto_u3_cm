package com.uce.edu.demo.repository;

import com.uce.edu.demo.repository.modelo.CuentaBancaria;
import com.uce.edu.demo.repository.modelo.Transferencia;

public interface ITransferenciaRepository {
	
	public void insertar(Transferencia transferencia);
	public Transferencia buscar(Integer id);

}


