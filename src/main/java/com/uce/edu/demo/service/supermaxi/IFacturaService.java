package com.uce.edu.demo.service.supermaxi;

import java.util.List;

public interface IFacturaService {
	public void compraProductos(String cedulaCliente, String numeroFactura, List<String> codigos);

}
