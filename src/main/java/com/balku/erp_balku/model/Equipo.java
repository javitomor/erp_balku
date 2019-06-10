package com.balku.erp_balku.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "EQUIPO")
public class Equipo implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne(cascade = { CascadeType.DETACH }, fetch = FetchType.EAGER)
	@JoinColumn(name = "tipoEquipo_id")
	private TipoEquipo tipoEquipo;

	@ManyToOne(cascade = { CascadeType.DETACH }, fetch = FetchType.EAGER)
	@JoinColumn(name = "cliente_id")
	private Cliente cliente;

//	@Column
//	private Long tipoEquipo_id;

//	@Column
//	private Long cliente_id;

	@Column
	private String marca;

	@Column
	private String serie;

	@Column
	private String modelo;

	public Equipo() {
	}

	public Equipo(String marca, String serie, String modelo, TipoEquipo tipoEquipo) {
		this.marca = marca;
		this.serie = serie;
		this.modelo = modelo;
		this.tipoEquipo = tipoEquipo;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
//
//	public Long getCliente_id() {
//		return cliente_id;
//	}
//
//	public void setCliente_id(Long cliente_id) {
//		this.cliente_id = cliente_id;
//	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public TipoEquipo getTipoEquipo() {
		return tipoEquipo;
	}

	public void setTipoEquipo(TipoEquipo tipoEquipo) {
		this.tipoEquipo = tipoEquipo;
	}

//	public Long getTipoEquipo_id() {
//		return tipoEquipo_id;
//	}
//
//	public void setTipoEquipo_id(Long tipoEquipo_id) {
//		this.tipoEquipo_id = tipoEquipo_id;
//	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getSerie() {
		return serie;
	}

	public void setSerie(String serie) {
		this.serie = serie;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	@Override
	public String toString() {
		return "Equipo [id=" + id + ", tipoEquipo=" + tipoEquipo + ", marca="
				+ marca + ", serie=" + serie + ", modelo=" + modelo + "]";
	}

}
