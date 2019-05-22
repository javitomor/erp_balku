/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.balku.erp_balku.controller.cliente;

import com.balku.erp_balku.model.Cliente;
import com.balku.erp_balku.model.Localidad;
import com.balku.erp_balku.model.Provincia;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.controls.JFXToggleButton;
import java.awt.event.MouseEvent;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author javiermoreno
 */
public class ConsultaClienteController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    @FXML
    private ImageView imgTitulo;

    @FXML
    private Text lblTitulo;

    @FXML
    private Text txtNumeroCliente;

    @FXML
    private JFXTextField nombre;

    @FXML
    private JFXTextField dni;

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
    private JFXTextField usuario;

    @FXML
    private JFXToggleButton estadoActivo;

    @FXML
    private JFXTextField apellido;

    @FXML
    private JFXComboBox<Provincia> provincia;

    @FXML
    private JFXComboBox<Localidad> localidad;

    @FXML
    private JFXTextField telefono;

    @FXML
    private JFXToggleButton whatsapp;

    @FXML
    private JFXTextField email;

    @FXML
    private JFXPasswordField contrasena;

    @FXML
    private JFXButton btnGuardar;

    @FXML
    private JFXButton btnCancelar;

    @FXML
    private JFXButton btnEditar;

    @FXML
    private JFXButton btnCancelarEditar;

    public void habilitarEditar() {

        boolean editar = false;
        this.btnCancelarEditar.setDisable(editar);
        this.btnGuardar.setDisable(editar);
        this.nombre.setDisable(editar);
        this.apellido.setDisable(editar);
        this.dni.setDisable(editar);
        this.provincia.setDisable(editar);
        this.localidad.setDisable(editar);
        this.fechaNacimiento.setDisable(editar);
        this.telefono.setDisable(editar);
        this.whatsapp.setDisable(editar);
        this.sexoFemenino.setDisable(editar);
        this.sexoMasculino.setDisable(editar);
        this.direccion.setDisable(editar);
        this.email.setDisable(editar);
        this.btnCancelar.setDisable(!editar);
        this.btnEditar.setDisable(!editar);

    }

    public void cancelarEditar() {

        boolean editar = true;
        this.btnCancelarEditar.setDisable(editar);
        this.btnGuardar.setDisable(editar);
        this.nombre.setDisable(editar);
        this.apellido.setDisable(editar);
        this.dni.setDisable(editar);
        this.provincia.setDisable(editar);
        this.localidad.setDisable(editar);
        this.fechaNacimiento.setDisable(editar);
        this.telefono.setDisable(editar);
        this.whatsapp.setDisable(editar);
        this.sexoFemenino.setDisable(editar);
        this.sexoMasculino.setDisable(editar);
        this.direccion.setDisable(editar);
        this.email.setDisable(editar);
        this.btnCancelar.setDisable(!editar);
        this.btnEditar.setDisable(!editar);

    }

    public void cargarLocalidad() {

    }

    public void closeButtonAction() {
        Stage currentStage = (Stage) btnCancelar.getScene().getWindow();
        currentStage.close();
    }

    public void guardarCliente() {

    }

    public void cargarDatos(Cliente cli) {
        this.nombre.setText(cli.getNombre());
        this.lblTitulo.setText(cli.getApellido() + ", " + cli.getNombre());
        this.txtNumeroCliente.setText(cli.getId().toString());

    }

}
