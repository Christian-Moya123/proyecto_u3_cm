package com.uce.edu.demo.service.supermaxi;

import java.util.List;

import com.uce.edu.demo.modelo.factura.Producto;

public interface IProductoService {
	public void actualizarStock(List<Producto> productos);
}
