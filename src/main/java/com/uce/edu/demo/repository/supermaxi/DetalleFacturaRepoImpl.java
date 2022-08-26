package com.uce.edu.demo.repository.supermaxi;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.uce.edu.demo.modelo.factura.DetalleFactura;

@Repository
@Transactional
public class DetalleFacturaRepoImpl implements IDetalleFacturaRepo {

	@PersistenceContext
	private EntityManager entityManager;


	@Override
	public void insertar(DetalleFactura detalleFactura) {
		// TODO Auto-generated method stub
		this.entityManager.persist(detalleFactura);
	}

}
