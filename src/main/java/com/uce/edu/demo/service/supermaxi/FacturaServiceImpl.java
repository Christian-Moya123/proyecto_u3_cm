package com.uce.edu.demo.service.supermaxi;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.modelo.factura.Cliente;
import com.uce.edu.demo.modelo.factura.DetalleFactura;
import com.uce.edu.demo.modelo.factura.Factura;
import com.uce.edu.demo.modelo.factura.FacturaElectronica;
import com.uce.edu.demo.modelo.factura.Producto;
import com.uce.edu.demo.repository.supermaxi.IClienteRepository;
import com.uce.edu.demo.repository.supermaxi.IFacturaElectronicaRepository;
import com.uce.edu.demo.repository.supermaxi.IFacturaRepository;
import com.uce.edu.demo.repository.supermaxi.IProductoRepository;

@Service
public class FacturaServiceImpl  implements IFacturaService {
	
	@Autowired
	private IFacturaRepository facturaRepository;
	
	@Autowired
	private IClienteRepository clienteRepository;
	
	@Autowired
	private IProductoRepository productoRepository;
	
	@Autowired
	private IProductoService productoService;
	
	@Autowired
	private IFacturaElectronicaRepository facturaElectronicaRepository;
	

	@Override
	@Transactional(value = TxType.REQUIRES_NEW)
	public BigDecimal compraProductos(String cedulaCliente, String numeroFactura, List<String> codigos) {
		// TODO Auto-generated method stub
		BigDecimal totalPagar = new BigDecimal(0);
		Cliente cliente = this.clienteRepository.buscar(cedulaCliente);
		
		Factura fact = new Factura();
		fact.setCliente(cliente);
		fact.setFecha(LocalDateTime.now());
		fact.setNumero(numeroFactura);
		
		List<DetalleFactura> detalles = new ArrayList<>();
		
		for (String codigoProducto : codigos) {
			DetalleFactura deta = new DetalleFactura();
		
			deta.setCantidad(1);
			deta.setFactura(fact);
			Producto producto = this.productoRepository.buscar(codigoProducto);
			deta.setProducto(producto);
			deta.setSubtotal(deta.getProducto().getPrecio());
			totalPagar.add(deta.getSubtotal());
			
			producto.setCantidad(producto.getCantidad()- deta.getCantidad());
			this.productoRepository.actualizar(producto);
			detalles.add(deta);
		}
		fact.setDetalles(detalles);
		
		this.facturaRepository.insertar(fact);
		return totalPagar;
		
	}
}
