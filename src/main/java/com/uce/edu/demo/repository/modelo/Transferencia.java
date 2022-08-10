package com.uce.edu.demo.repository.modelo;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "transferencia")
public class Transferencia {

	@Id
	@Column(name="tran_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tran_name_gerneration")
	@SequenceGenerator(name = "tran_name_gerneration",sequenceName = "tran_id_seq", allocationSize = 1)
	private Integer id;

	@Column(name="tran_fecha")
	private LocalDateTime fecha;
	
	@Column(name="tran_monto")
	private BigDecimal monto;
	
	@ManyToOne
	@JoinColumn(name = "tran_id_origen")
	private CuentaBancaria cuentaOrigen;
	
	@ManyToOne
	@JoinColumn(name = "tran_id_destino")
	private CuentaBancaria cuentaDestino;

	
	//get y set
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public LocalDateTime getFecha() {
		return fecha;
	}

	public void setFecha(LocalDateTime fecha) {
		this.fecha = fecha;
	}

	public BigDecimal getMonto() {
		return monto;
	}

	public void setMonto(BigDecimal monto) {
		this.monto = monto;
	}

	public CuentaBancaria getCuentaOrigen() {
		return cuentaOrigen;
	}

	public void setCuentaOrigen(CuentaBancaria cuentaOrigen) {
		this.cuentaOrigen = cuentaOrigen;
	}

	public CuentaBancaria getCuentaDestino() {
		return cuentaDestino;
	}

	public void setCuentaDestino(CuentaBancaria cuentaDestino) {
		this.cuentaDestino = cuentaDestino;
	}
	
	
	
	
	
}
