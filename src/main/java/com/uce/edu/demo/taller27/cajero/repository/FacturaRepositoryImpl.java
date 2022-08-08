package com.uce.edu.demo.taller27.cajero.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.uce.edu.demo.modelo.factura.Factura;
import com.uce.edu.demo.repository.modelo.Hotel;



@Repository
@Transactional
public class FacturaRepositoryImpl implements IFacturaRepository{
	
	@PersistenceContext
	private EntityManager entityManager;

	
	@Override
	public List<Factura> buscarFacturaInnerJoin(Integer cantidad) {
		// TODO Auto-generated method stub
		TypedQuery<Factura> myQuery = this.entityManager.createQuery("SELECT f FROM Factura f INNER JOIN f.detalles de WHERE de.cantidad = :datoCantidad", Factura.class);
		myQuery.setParameter("datoCantidad",cantidad);
		return myQuery.getResultList();
	}

	@Override
	public List<Factura> buscarFacturaOuterJoinLefht(Integer cantidad) {
		// TODO Auto-generated method stub
		TypedQuery<Factura> myQuery = this.entityManager.createQuery("SELECT f FROM Factura f LEFT JOIN f.detalles de WHERE de.cantidad = :datoCantidad", Factura.class);
		myQuery.setParameter("datoCantidad",cantidad);
		return myQuery.getResultList();
	}

	@Override
	public List<Factura> buscarFacturalOuterJoinRigth(Integer cantidad) {
		// TODO Auto-generated method stub
		TypedQuery<Factura> myQuery = this.entityManager.createQuery("SELECT f FROM Factura f RIGHT JOIN f.detalles de WHERE de.cantidad = :datoCantidad", Factura.class);
		myQuery.setParameter("datoCantidad",cantidad);
		return myQuery.getResultList();
	}

	@Override
	public List<Factura> buscarFacturaInnerJoin() {
		// TODO Auto-generated method stub
		TypedQuery<Factura> myQuery = this.entityManager.createQuery("SELECT f FROM Factura f INNER JOIN f.detalles de", Factura.class);
		
		return myQuery.getResultList();
	}

	@Override
	public List<Factura> buscarFacturaOuterJoinLefht() {
		// TODO Auto-generated method stub
		TypedQuery<Factura> myQuery = this.entityManager.createQuery("SELECT f FROM Factura f LEFT JOIN f.detalles de", Factura.class);
		
		return myQuery.getResultList();
	}
	
	//WHERE JOIN
	@Override
	public List<Factura> buscarFacturaWhereJoin(Integer cantidad) {
		// TODO Auto-generated method stub
		TypedQuery<Factura> myQuery = this.entityManager.createQuery("SELECT f FROM Factura f, DetalleFactura df WHERE f = df.factura AND df.cantidad  = :datoCantidad", Factura.class);
		myQuery.setParameter("datoCantidad",cantidad);
		return myQuery.getResultList();
	}

	//FECHT JOIN
	@Override
	public List<Factura> buscarFacturaFetchJoin(Integer cantidad) {
		// TODO Auto-generated method stub
		TypedQuery<Factura> myQuery = this.entityManager.createQuery("SELECT f FROM Factura f JOIN FETCH  f.detalles de WHERE de.cantidad = :datoCantidad", Factura.class);
		myQuery.setParameter("datoCantidad",cantidad);
		return myQuery.getResultList();
	}



	

}
