package com.uce.edu.demo.service.supermaxi;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.modelo.factura.FacturaElectronica;
import com.uce.edu.demo.modelo.factura.Producto;
import com.uce.edu.demo.repository.supermaxi.IFacturaElectronicaRepository;
import com.uce.edu.demo.repository.supermaxi.IProductoRepository;

@Service
public class ProductoServiceImpl implements IProductoService {

	@Autowired
	private IProductoRepository productoRepository;
	
	@Autowired
	private IFacturaService facturaService;
	
	@Autowired
	private IFacturaElectronicaService facturaElectronicaService;

	
	
	@Transactional(value = TxType.REQUIRED)
	public void registrarCompraProducto(String cedula, String numeroFactura, List<String> codigos) {
		BigDecimal totalPagar = this.facturaService.compraProductos(cedula, numeroFactura, codigos);
		
		this.facturaElectronicaService.procesarElectronica(numeroFactura, codigos.size(), totalPagar);
	
		
		
		
	}
}
