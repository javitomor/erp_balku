/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.balku.erp_balku.controller;

import com.balku.erp_balku.model.Cliente;
import com.balku.erp_balku.model.Localidad;
import com.balku.erp_balku.model.Provincia;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.controls.JFXToggleButton;
import java.util.List;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javax.persistence.EntityManager;

/**
 * FXML Controller class
 *
 * @author javiermoreno
 */
public class AltaClienteController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        EntityManager man = ModelController.getEntityManager();
        List<Provincia> provincias = (List<Provincia>) man.createQuery("FROM Provincia").getResultList();
        for (Provincia prov : provincias) {
            provincia.getItems().add(prov);
        }
        man.close();
    }

    @FXML
    private JFXTextField nombre;

    @FXML
    private JFXTextField apellido;

    @FXML
    private JFXTextField dni;

    @FXML
    private JFXComboBox<Provincia> provincia;

    @FXML
    private JFXComboBox<String> localidad;

    @FXML
    private JFXDatePicker fechaNacimiento;

    @FXML
    private RadioButton sexoMasculino;

    @FXML
    private ToggleGroup GroupSexo;

    @FXML
    private RadioButton sexoFemenino;

    @FXML
    private JFXTextField direccion;

    @FXML
    private JFXTextField telefono;

    @FXML
    private JFXToggleButton whatsapp;

    @FXML
    private JFXTextField email;

    @FXML
    private JFXTextField usuario;

    @FXML
    private JFXPasswordField contrasena;

    @FXML
    private JFXToggleButton estadoActivo;

    @FXML
    private JFXButton btnGuardar;

    @FXML
    private JFXButton btnCancelar;

    public void guardarCliente() {

        EntityManager em = ModelController.getEntityManager();

        Cliente cli = new Cliente();
        cli.setNombre(this.nombre.getText());
        cli.setApellido(this.apellido.getText());
        cli.setDni(Long.parseLong(this.dni.getText()));
        cli.setFechaNacimiento(this.fechaNacimiento.getValue());

        RadioButton selectedRadioButton = (RadioButton) this.GroupSexo.getSelectedToggle();
        cli.setSexo(selectedRadioButton.getText());

        cli.setDireccion(this.direccion.getText());
        cli.setTelefono(this.telefono.getText());
        cli.setWhatsapp(this.whatsapp.isSelected());
        cli.setEmail(this.email.getText());
        cli.setEstadoActivo(this.estadoActivo.isSelected());

        em.getTransaction().begin();
        em.persist(cli);
        em.getTransaction().commit();
        em.close();

    }

    public void cargarLocalidad(ActionEvent envt) {

        List<Localidad> localidades = provincia.getSelectionModel().getSelectedItem().getLocalidad();

        localidad.getItems().remove(0, localidad.getItems().size());

        for (Localidad loc : localidades) {
            localidad.getItems().add(loc.getNombre());
        }
        
        //AGREGAR ORDER BY O BUSQUEDA DENTRO DEL COMBO

    }
}
