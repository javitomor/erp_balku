/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.balku.erp_balku.controller.cliente;

import com.jfoenix.controls.JFXButton;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.stage.Stage;

/**
 *
 * @author javiermoreno
 */
public class SimpleClienteController implements Initializable{

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
    }
        @FXML
    private JFXButton btnAceptar;
    
    public void accionAceptar(){
    
        Stage currentStage = (Stage) btnAceptar.getScene().getWindow();
        currentStage.close();
    }
    
}
