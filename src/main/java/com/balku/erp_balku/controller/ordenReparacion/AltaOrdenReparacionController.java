/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.balku.erp_balku.controller.ordenReparacion;

import java.net.URL;
import java.util.ResourceBundle;

import com.balku.erp_balku.controller.cliente.BuscarClienteController;
import com.balku.erp_balku.model.Cliente;
import com.balku.erp_balku.model.propertyObject.ClienteProperty;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

/**
 * FXML Controller class
 *
 * @author javiermoreno
 */
public class AltaOrdenReparacionController implements Initializable {

	/**
	 * Initializes the controller class.
	 */
	@Override
	public void initialize(URL url, ResourceBundle rb) {
		// TODO
	}

	public static final Cliente cliente = new Cliente();

	@FXML
	private JFXButton btnBuscarCliente;

	@FXML
	private Label txtNombreCliente;

	@FXML
	private Label txtDireccionCliente;

	@FXML
	private Label txtTelefonoCliente;

	@FXML
	private Label txtEmailCliente;

	@FXML
	private Label txtNumeroOrden;

	@FXML
	private JFXTextField txtNroOrdenPres;

	@FXML
	private JFXDatePicker dateRecibido;

	@FXML
	private JFXDatePicker dateEntregado;

	@FXML
	private JFXTextField txtEquipo;

	@FXML
	private JFXTextField txtMarcaEquipo;

	@FXML
	private JFXTextField txtNumeroSerieEquipo;

	@FXML
	private JFXTextField txtModeloEquipo;

	@FXML
	private JFXTextArea txtTrabajoARealizar;

	@FXML
	private JFXTextArea txtObsReparacion;

	@FXML
	private JFXTextArea txtObsCliente;

	@FXML
	private JFXTextArea txtCondServicio;

	@FXML
	private JFXButton btnGuardar;

	@FXML
	private JFXButton btnCancelar;

	public void buscarCliente() {

		BuscarClienteController busCliCont = new BuscarClienteController();
		busCliCont.mostrarListadoClistes();

	}
	
	public static void setClienteFromOut(ClienteProperty clienteProperty) {
		cliente.setId(clienteProperty.getId());
		cliente.setDni(clienteProperty.getDni());
		cliente.setNombre(clienteProperty.getNombre());
		cliente.setApellido(clienteProperty.getApellido());
	}

}
