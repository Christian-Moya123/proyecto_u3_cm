package com.uce.edu.demo.repository.supermaxi;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import com.uce.edu.demo.modelo.factura.FacturaElectronica;

public class FacturaElectronicaRepositoryImpl implements IFacturaElectronicaRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	@Transactional(value = TxType.MANDATORY)
	public void insertar(FacturaElectronica facturaElectronica) {
		this.entityManager.persist(facturaElectronica);
		
	}
}
