package com.uce.edu.demo.repository.supermaxi;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.stereotype.Repository;

import com.uce.edu.demo.modelo.factura.Cliente;
@Repository
@Transactional
public class ClienteRepositoryImpl implements IClienteRepository {



	@PersistenceContext
	private EntityManager entityManager;

	@Override
	@Transactional(value = TxType.NOT_SUPPORTED)
	public Cliente buscar(String cedula) {
		TypedQuery<Cliente> myQuery = this.entityManager
				.createQuery("SELECT c FROM Cliente c WHERE c.numeroCedula = :cedula", Cliente.class);
		myQuery.setParameter("cedula", cedula);
		return myQuery.getSingleResult();
	}
}
