package com.uce.edu.demo.repository;

import javax.management.RuntimeErrorException;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.stereotype.Repository;

import com.uce.edu.demo.repository.modelo.CuentaBancaria;
import com.uce.edu.demo.repository.modelo.Transferencia;

@Repository
@Transactional
public class TransferenciaRepositoryImpl implements ITransferenciaRepository{

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	@Transactional(value = TxType.REQUIRED)
	public void insertar(Transferencia transferencia) {
		// TODO Auto-generated method stub
		this.entityManager.persist(transferencia);
		throw new NullPointerException();
	}

	@Override
	public Transferencia buscar(Integer id) {
		// TODO Auto-generated method stub
		 return this.entityManager.find(Transferencia.class, id);
	}

}
