package com.uce.edu.demo.repository.supermaxi;

import com.uce.edu.demo.modelo.factura.Producto;

public interface IProductoRepository {
	public void actualizar(Producto producto);

	public Producto buscar(String codigo);
}
