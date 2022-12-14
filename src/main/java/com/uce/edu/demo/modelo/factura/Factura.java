package com.uce.edu.demo.modelo.factura;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="factura")
public class Factura {
	

	@Id
	@Column(name ="fact_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "fact_name_gerneration")
	@SequenceGenerator(name = "fact_name_gerneration",sequenceName = "fact_id_seq", allocationSize = 1)
	private Integer id;
	
	@Column(name ="fact_fecha")
	private LocalDateTime fecha;
	
	@Column(name ="fact_numero")
	private String numero;
	
	@Column(name = "fact_monto")
	private BigDecimal monto;
	
	@ManyToOne
	@JoinColumn(name = "fact_clie_id")//clave foranea que viene de cliente
	private Cliente  cliente;
	
	@OneToMany(mappedBy = "factura", cascade =  CascadeType.ALL, fetch = FetchType.LAZY)
	private List<DetalleFactura> detalles;

	
	
	
	
	public BigDecimal getMonto() {
		return monto;
	}

	public void setMonto(BigDecimal monto) {
		this.monto = monto;
	}

	@Override
	public String toString() {
		return "Factura [id=" + id + ", fecha=" + fecha + ", numero=" + numero + ", detalles=" + detalles + "]";
	}

	//set y get
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

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<DetalleFactura> getDetalles() {
		return detalles;
	}

	public void setDetalles(List<DetalleFactura> detalles) {
		this.detalles = detalles;
	}
	
	
	

}
