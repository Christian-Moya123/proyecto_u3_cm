package com.uce.edu.demo.repository.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.ManyToAny;

@Entity
@Table(name = "habitacion")
public class Habitacion {
	
	@Id
	@Column(name="habi_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "habi_name_gerneration")
	@SequenceGenerator(name = "habi_name_gerneration",sequenceName = "habi_id_seq", allocationSize = 1)
	private Integer id;
	
	@Column(name="habi_numero")
	private String numero;
	
	@Column(name="habi_piso")
	private String piso;
	
	@Column(name="habi_tipo")
	private String tipo;
	
	@ManyToOne
	@JoinColumn(name = "habi_id_hotel")//clave foranea
	private Hotel hotel;//relacion muchos a uno, habitacion hacia el hotel
	
	

	@Override
	public String toString() {
		return "Habitacion [id=" + id + ", numero=" + numero + ", piso=" + piso + ", tipo=" + tipo + "]";
	}

	//set y get
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getPiso() {
		return piso;
	}

	public void setPiso(String piso) {
		this.piso = piso;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Hotel getHotel() {
		return hotel;
	}

	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}
	
	

	

}
