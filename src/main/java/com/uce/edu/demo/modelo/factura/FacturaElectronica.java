package com.uce.edu.demo.modelo.factura;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="factura_electronica")
public class FacturaElectronica {

	@Id
	@Column(name ="fael_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "fael_name_gerneration")
	@SequenceGenerator(name = "fael_name_gerneration",sequenceName = "fael_id_seq", allocationSize = 1)
	private Integer id;
	
	@Column(name ="fael_numero")
	private Integer numero;
	
	@Column(name ="fael_fecha_creacion")
	private Integer fechaCreacion;
	
	@Column(name ="fael_monto_factura")
	private BigDecimal montoFactura;
	
	@Column(name ="fael_numero_item")
	private Integer numeroItem;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public Integer getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Integer fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public BigDecimal getMontoFactura() {
		return montoFactura;
	}

	public void setMontoFactura(BigDecimal montoFactura) {
		this.montoFactura = montoFactura;
	}

	public Integer getNumeroItem() {
		return numeroItem;
	}

	public void setNumeroItem(Integer numeroItem) {
		this.numeroItem = numeroItem;
	}
	
	
	
	
	
}
