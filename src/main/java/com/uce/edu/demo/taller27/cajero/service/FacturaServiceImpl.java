package com.uce.edu.demo.taller27.cajero.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.modelo.factura.Factura;
import com.uce.edu.demo.repository.modelo.Hotel;
import com.uce.edu.demo.taller27.cajero.repository.IFacturaRepository;

@Service
public class FacturaServiceImpl implements IFacturaService{

	@Autowired
	private IFacturaRepository facturaRepository;

	@Override
	public List<Factura> buscarFacturaInnerJoin(Integer cantidad) {
		// TODO Auto-generated method stub
		return this.facturaRepository.buscarFacturaInnerJoin(cantidad);
	}

	@Override
	public List<Factura> buscarFacturaOuterJoinLefht(Integer cantidad) {
		// TODO Auto-generated method stub
		return this.facturaRepository.buscarFacturaOuterJoinLefht(cantidad);
	}

	@Override
	public List<Factura> buscarFacturalOuterJoinRigth(Integer cantidad) {
		// TODO Auto-generated method stub
		return this.facturaRepository.buscarFacturaOuterJoinLefht(cantidad);
	}

	@Override
	public List<Factura> buscarFacturaWhereJoin(Integer cantidad) {
		// TODO Auto-generated method stub
		return this.facturaRepository.buscarFacturaWhereJoin(cantidad);
	}

	@Override
	public List<Factura> buscarFacturaFetchJoin(Integer cantidad) {
		// TODO Auto-generated method stub
		return this.facturaRepository.buscarFacturaFetchJoin(cantidad);
	}

	@Override
	public List<Factura> buscarFacturaInnerJoin() {
		// TODO Auto-generated method stub
		return this.facturaRepository.buscarFacturaInnerJoin();
	}

	@Override
	public List<Factura> buscarFacturaOuterJoinLefht() {
		// TODO Auto-generated method stub
		return this.facturaRepository.buscarFacturaOuterJoinLefht();
	}

	
	


}
