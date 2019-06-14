package com.balku.erp_balku.controller.cliente;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javax.persistence.EntityManager;

import com.balku.erp_balku.controller.ModelController;
import com.balku.erp_balku.controller.ordenReparacion.AltaOrdenReparacionController;
import com.balku.erp_balku.model.Cliente;
import com.balku.erp_balku.model.propertyObject.ClienteProperty;
import com.jfoenix.controls.JFXButton;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class ElegirClienteListaController implements Initializable{

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		loadTableViewElegirClientes();
		
	}
	
	ObservableList<ClienteProperty> dataCliente = FXCollections.observableArrayList();

    @FXML
    private TableView<ClienteProperty> tblClientes;
    
    @FXML
    private TableColumn<ClienteProperty, String> txtNroCliente;

    @FXML
    private TableColumn<ClienteProperty, String> txtNombreCliente;

    @FXML
    private TableColumn<ClienteProperty, String> txtApellidoCliente;

    @FXML
    private TableColumn<ClienteProperty, String> txtDniCliente;

    @FXML
    private JFXButton btnCargar;

    @FXML
    private JFXButton bntCancelar;
    
	
	public void loadTableViewElegirClientes() {
		txtNroCliente.setCellValueFactory(new PropertyValueFactory<>("Id"));
		txtNombreCliente.setCellValueFactory(new PropertyValueFactory<>("Nombre"));
		txtApellidoCliente.setCellValueFactory(new PropertyValueFactory<>("Apellido"));
		txtDniCliente.setCellValueFactory(new PropertyValueFactory<>("Dni"));
		tblClientes.setItems(dataCliente);
		
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
	
	public void seleccionarCliente() {
		ClienteProperty cliente = tblClientes.getSelectionModel().getSelectedItem();
		AltaOrdenReparacionController.setClienteFromOut(cliente);
		
		Stage currentStage = (Stage) btnCargar.getScene().getWindow();
		currentStage.close();
	}
	
	public void closeButtonAction() {
		Stage currentStage = (Stage) bntCancelar.getScene().getWindow();
		currentStage.close();
	}

}
