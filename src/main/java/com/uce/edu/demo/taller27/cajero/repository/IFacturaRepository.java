package com.uce.edu.demo.taller27.cajero.repository;

import java.util.List;

import com.uce.edu.demo.modelo.factura.Factura;
import com.uce.edu.demo.repository.modelo.Hotel;

public interface IFacturaRepository {
	
	
	public List<Factura> buscarFacturaInnerJoin(Integer cantidad);
	public List<Factura> buscarFacturaOuterJoinLefht(Integer cantidad);
	public List<Factura> buscarFacturalOuterJoinRigth(Integer cantidad);
	public List<Factura> buscarFacturaInnerJoin();
	public List<Factura> buscarFacturaOuterJoinLefht();
	
	public List<Factura> buscarFacturaWhereJoin(Integer cantidad);
	
	public List<Factura> buscarFacturaFetchJoin(Integer cantidad);
	
	

}
