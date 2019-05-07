/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.balku.erp_balku.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author javiermoreno
 */
@Entity
@Table(name="CLIENTE")
public class Cliente implements Serializable{

    @Id
    private Long id;
    
    @Column
    private String nombre;

    @Column
    private String apellido;

    @Column
    private Long dni;

    @Column
    private Date fechaNacimiento;

    @Column
    private boolean sexoMasculino;

    @Column
    private boolean sexoFemenino;

    @Column
    private String direccion;

    @Column
    private String telefono;

    @Column
    private boolean whatsapp;

    @Column
    private String email;

    @Column
    private String usuario;

    @Column
    private String contrasena;

    @Column
    private boolean estadoActivo;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public Long getDni() {
        return dni;
    }

    public void setDni(Long dni) {
        this.dni = dni;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public boolean isSexoMasculino() {
        return sexoMasculino;
    }

    public void setSexoMasculino(boolean sexoMasculino) {
        this.sexoMasculino = sexoMasculino;
    }

    public boolean isSexoFemenino() {
        return sexoFemenino;
    }

    public void setSexoFemenino(boolean sexoFemenino) {
        this.sexoFemenino = sexoFemenino;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public boolean isWhatsapp() {
        return whatsapp;
    }

    public void setWhatsapp(boolean whatsapp) {
        this.whatsapp = whatsapp;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public boolean isEstadoActivo() {
        return estadoActivo;
    }

    public void setEstadoActivo(boolean estadoActivo) {
        this.estadoActivo = estadoActivo;
    }

    public Cliente() {
    }

    public Cliente(String nombre, String apellido, Long dni, Date fechaNacimiento, boolean sexoMasculino, boolean sexoFemenino, String direccion, String telefono, boolean whatsapp, String email, String usuario, String contrasena, boolean estadoActivo) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.fechaNacimiento = fechaNacimiento;
        this.sexoMasculino = sexoMasculino;
        this.sexoFemenino = sexoFemenino;
        this.direccion = direccion;
        this.telefono = telefono;
        this.whatsapp = whatsapp;
        this.email = email;
        this.usuario = usuario;
        this.contrasena = contrasena;
        this.estadoActivo = estadoActivo;
    }

    @Override
    public String toString() {
        return "Cliente{" + "id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", dni=" + dni + ", fechaNacimiento=" + fechaNacimiento + ", sexoMasculino=" + sexoMasculino + ", sexoFemenino=" + sexoFemenino + ", direccion=" + direccion + ", telefono=" + telefono + ", whatsapp=" + whatsapp + ", email=" + email + ", usuario=" + usuario + ", contrasena=" + contrasena + ", estadoActivo=" + estadoActivo + '}';
    }
     
    
}
