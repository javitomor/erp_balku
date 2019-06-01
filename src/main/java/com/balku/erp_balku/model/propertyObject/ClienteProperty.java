package com.balku.erp_balku.model.propertyObject;

import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleStringProperty;

public class ClienteProperty {
	private final SimpleStringProperty nombre;
	private final SimpleLongProperty id;
	private final SimpleStringProperty apellido;
	private final SimpleLongProperty dni;
	
	public ClienteProperty(Long id,String nombre, String apellido, Long dni) {
		this.id = new SimpleLongProperty(id);
		this.nombre = new SimpleStringProperty(nombre);
		this.apellido = new SimpleStringProperty(apellido);
		this.dni = new SimpleLongProperty(dni);
		
		
	};
	
	public Long getId() {
		return id.get();
	}
	
	public String getNombre() {
		return nombre.get();
	}
	
	public String getApellido() {
		return apellido.get();
	}
	
	public Long getDni() {
		return dni.get();
	}

}
