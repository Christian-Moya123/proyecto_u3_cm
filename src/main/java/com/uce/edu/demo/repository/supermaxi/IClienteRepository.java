package com.uce.edu.demo.repository.supermaxi;

import com.uce.edu.demo.modelo.factura.Cliente;

public interface IClienteRepository {
	public Cliente buscar(String cedula);
}
