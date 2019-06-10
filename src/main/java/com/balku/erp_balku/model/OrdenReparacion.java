package com.balku.erp_balku.model;

import java.io.Serializable;
import java.time.LocalDate;

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
@Table(name = "ORDEN_REPARACION")
public class OrdenReparacion implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne(cascade = {CascadeType.DETACH}, fetch = FetchType.EAGER)
	@JoinColumn(name="cliente_id")
	private Cliente cliente;
	
	@ManyToOne(cascade = {CascadeType.DETACH}, fetch = FetchType.EAGER)
	@JoinColumn(name = "equipo_id")
	private Equipo equipo;
	
	
	@Column
	private int nroOrdenPresupuesto;
	
	@Column
	private LocalDate fechaRecibido;
	
	@Column
	private LocalDate fechaEntrega;
	
	@Column
	private LocalDate fechaAlta;
	
	@Column
	private String trabajoARealizar;
	
	@Column
	private String obsRecepcion;
	
	@Column
	private String obsCliente;
	
	@Column
	private String condServicio;
	
	
}
