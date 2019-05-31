/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.balku.erp_balku.controller;

import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import javafx.fxml.Initializable;

import com.balku.erp_balku.model.Cliente;
import com.balku.erp_balku.model.ClienteProperty;
import com.jfoenix.controls.JFXButton;
import java.io.IOException;

import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author javiermoreno
 */
public class IndexController implements Initializable {

	/**
	 * Initializes the controller class.
	 */
	@Override
	public void initialize(URL url, ResourceBundle rb) {

		loadDataTableViewCliente();
	}

	ObservableList<ClienteProperty> dataCliente = FXCollections.observableArrayList();

	@FXML
	private JFXButton btnNuevoCliente;

	@FXML
	private AnchorPane ordenesAnchorPane;

	@FXML
	private AnchorPane rootPane;

	@FXML
	private AnchorPane clienteAnchorPane;

	@FXML
	private AnchorPane indexAnchorPane;

	@FXML
	private JFXButton btnConsultarCliente;

	@FXML
	private TableView<ClienteProperty> tableViewCliente;

	@FXML
	private TableColumn<ClienteProperty, String> tabColId;

	@FXML
	private TableColumn<ClienteProperty, String> tabColNombre;

	@FXML
	private TableColumn<ClienteProperty, String> tabColApellido;

	@FXML
	private TableColumn<ClienteProperty, String> tabColDni;

	@FXML

	public void cargarVentanaConsultarCliente() {

		try {
			Parent root = FXMLLoader.load(getClass().getResource("/view/cliente/BuscarCliente.fxml"));
			Scene scene = new Scene(root);
//        scene.getStylesheets().add("/styles/Styles.css");
			Stage stage = new Stage();
			stage.initModality(Modality.APPLICATION_MODAL);
			stage.setTitle("Buscar Cliente");
			stage.setScene(scene);
			stage.showAndWait();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void cargarVentanaNuevoCliente(ActionEvent event) throws IOException {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("/view/cliente/AltaCliente.fxml"));
			Scene scene = new Scene(root);
//        scene.getStylesheets().add("/styles/Styles.css");
			Stage stage = new Stage();
			stage.initModality(Modality.APPLICATION_MODAL);
			stage.setTitle("Alta de Cliente");
			stage.setScene(scene);
			stage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void loadDataTableViewCliente() {

		tabColId.setCellValueFactory(new PropertyValueFactory<>("Id"));
		tabColNombre.setCellValueFactory(new PropertyValueFactory<>("Nombre"));
		tabColApellido.setCellValueFactory(new PropertyValueFactory<>("Apellido"));
		tabColDni.setCellValueFactory(new PropertyValueFactory<>("Dni"));
		tableViewCliente.setItems(dataCliente);
		
		try {
		
			EntityManager man = ModelController.getEntityManager();
			List<Cliente> clientes = new ArrayList<>();
			clientes = man.createQuery("FROM Cliente").getResultList();

			for (Cliente cli : clientes) {
				dataCliente.add(new ClienteProperty(cli.getId(), cli.getNombre(), cli.getApellido(), cli.getDni()));
			}
		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
