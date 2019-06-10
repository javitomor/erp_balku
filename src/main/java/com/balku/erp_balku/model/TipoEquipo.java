package com.balku.erp_balku.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "TIPO_EQUIPO")
public class TipoEquipo implements Serializable {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@Column
	private String nombre;
	
	@OneToMany(mappedBy = "tipoEquipo", fetch = FetchType.LAZY)
	private List<Equipo> equipos = new ArrayList<>();
	
	public TipoEquipo() {}
	
	
}
