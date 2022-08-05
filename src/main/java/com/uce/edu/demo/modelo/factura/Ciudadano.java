package com.uce.edu.demo.modelo.factura;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity(name="Ciudadano2")//le doy un nombre cuando tengo dos o mas clases con el mismo nombro ya que JPA no puide crear, con esto no cambiamos el nombre de la clase
@Table(name="ciudadano2")
public class Ciudadano {
	
	@Id
	@Column(name="ciud_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ciud2_name_gerneration")
	@SequenceGenerator(name = "ciud2_name_gerneration",sequenceName = "ciud_id_seq2", allocationSize = 1)
	private Integer id;
	
	@Column(name="ciud_nombre")
	private String nombre;
	
	@Column(name="ciud_apellido")
	private String apellido;
	
	@OneToOne(mappedBy =  "ciudadano")
	private Cliente cliente;

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

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	

}
