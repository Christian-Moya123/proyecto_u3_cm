package com.uce.edu.demo.service.supermaxi;

import java.math.BigDecimal;
import java.util.List;

public interface IFacturaService {
	public BigDecimal compraProductos(String cedulaCliente, String numeroFactura, List<String> codigos);

}
