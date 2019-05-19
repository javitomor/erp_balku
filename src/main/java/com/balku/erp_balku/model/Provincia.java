/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.balku.erp_balku.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author javiermoreno
 */
@Entity
@Table(name = "PROVINCIAS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Provincia.findAll", query = "SELECT p FROM Provincia p")
    , @NamedQuery(name = "Provincia.findById", query = "SELECT p FROM Provincia p WHERE p.id = :id")
    , @NamedQuery(name = "Provincia.findByProvinciaNombre", query = "SELECT p FROM Provincia p WHERE p.provinciaNombre = :provinciaNombre")})
public class Provincia implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id", nullable = false)
    private Long id;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "provincia_nombre", nullable = false, length = 50)
    private String provinciaNombre;

    @OneToMany(mappedBy = "provincia", cascade = CascadeType.ALL, fetch = FetchType.EAGER) //nombre del campo en el Objeto Localidad que se corresponde
    private List<Localidad> localidad = new ArrayList<>();

    public Provincia() {
    }

    public Provincia(Long id) {
        this.id = id;
    }

    public Provincia(Long id, String provinciaNombre) {
        this.id = id;
        this.provinciaNombre = provinciaNombre;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProvinciaNombre() {
        return provinciaNombre;
    }

    public void setProvinciaNombre(String provinciaNombre) {
        this.provinciaNombre = provinciaNombre;
    }

    public List<Localidad> getLocalidad() {
        return localidad;
    }

    public void setLocalidad(List<Localidad> localidad) {
        this.localidad = localidad;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Provincia)) {
            return false;
        }
        Provincia other = (Provincia) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return provinciaNombre;
    }

}
