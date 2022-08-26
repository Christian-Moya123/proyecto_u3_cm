package com.uce.edu.demo.modelo.factura;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity(name="Cliente2")
@Table(name="cliente")
public class Cliente {
	
	@Id
	@Column(name="clie_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "clie_name_gerneration")
	@SequenceGenerator(name = "clie_name_gerneration",sequenceName = "clie_id_seq", allocationSize = 1)
	private Integer id;
	
	@Column(name="clie_numero_tarjeta")
	private String numeroTarjeta;
	
	@Column(name = "clie_numero_cedula")
	private String numeroCedula;

	@OneToOne
	@JoinColumn(name="clie_ciud_id")//calve foranea que viene de ciudadano
	private Ciudadano ciudadano;

	@OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Factura> facturas;
	
	//set y get
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNumeroTarjeta() {
		return numeroTarjeta;
	}

	public String getNumeroCedula() {
		return numeroCedula;
	}

	public void setNumeroCedula(String numeroCedula) {
		this.numeroCedula = numeroCedula;
	}

	public void setNumeroTarjeta(String numeroTarjeta) {
		this.numeroTarjeta = numeroTarjeta;
	}

	public Ciudadano getCiudadano() {
		return ciudadano;
	}

	public void setCiudadano(Ciudadano ciudadano) {
		this.ciudadano = ciudadano;
	}

	public List<Factura> getFacturas() {
		return facturas;
	}

	public void setFacturas(List<Factura> facturas) {
		this.facturas = facturas;
	}
	
	
	
}
