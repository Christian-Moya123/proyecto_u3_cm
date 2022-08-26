package com.uce.edu.demo.repository.supermaxi;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import com.uce.edu.demo.modelo.factura.Factura;

public class FacturaRepositoryImpl implements IFacturaRepository {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@Transactional(value = TxType.REQUIRES_NEW)
	public void insertar(Factura factura) {
		this.entityManager.persist(factura);
	}

}
