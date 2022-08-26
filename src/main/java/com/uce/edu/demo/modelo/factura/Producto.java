package com.uce.edu.demo.modelo.factura;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="producto")
public class Producto {

	@Id
	@Column(name ="prod_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "prod_name_gerneration")
	@SequenceGenerator(name = "prod_name_gerneration",sequenceName = "prod_id_seq", allocationSize = 1)
	private Integer id;
	
	@Column(name ="prod_nombre")
	private String nombre;
	
	@Column(name ="prod_precio")
	private BigDecimal precio;
	
	@Column(name = "prod_codigo_barras")
	private String codigoBarras;

	@Column(name = "prod_cantidad")
	private Integer cantidad;
	
	@OneToMany(mappedBy = "producto")
	private List<DetalleFactura> detalles;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public BigDecimal getPrecio() {
		return precio;
	}

	public void setPrecio(BigDecimal precio) {
		this.precio = precio;
	}

	public List<DetalleFactura> getDetalles() {
		return detalles;
	}

	public void setDetalles(List<DetalleFactura> detalles) {
		this.detalles = detalles;
	}

	public String getCodigoBarras() {
		return codigoBarras;
	}

	public void setCodigoBarras(String codigoBarras) {
		this.codigoBarras = codigoBarras;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}
	
	
	
	
}
