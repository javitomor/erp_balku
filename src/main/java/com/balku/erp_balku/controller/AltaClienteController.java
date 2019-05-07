/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.balku.erp_balku.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.controls.JFXToggleButton;
import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
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
        // TODO
    } 
    
    
    @FXML
    private JFXTextField nombre;

    @FXML
    private JFXTextField apellido;

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
    
}
