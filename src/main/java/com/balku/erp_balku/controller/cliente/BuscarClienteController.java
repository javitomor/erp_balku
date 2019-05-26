package com.balku.erp_balku.controller.cliente;

import com.balku.erp_balku.controller.ModelController;
import com.balku.erp_balku.model.Cliente;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javax.persistence.EntityManager;
import javax.persistence.Query;

public class BuscarClienteController implements Initializable {

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    @FXML
    private JFXTextField txtNumero;

    @FXML
    private JFXTextField txtDni;

    @FXML
    private JFXButton btnBuscar;

    @FXML
    private JFXButton btnCancelar;

    public void buscarCliente() {
        EntityManager man = ModelController.getEntityManager();
        List<Cliente> clientes = new ArrayList<>();
        if (!this.txtNumero.getText().isEmpty()) {
            Query query = man.createQuery("FROM Cliente where id = :id");
            query.setParameter("id", Long.parseLong(this.txtNumero.getText()));
            clientes = (List<Cliente>) query.getResultList();
        } else {
            if (!this.txtDni.getText().isEmpty()) {
                Query query = man.createQuery("FROM Cliente where dni = :dni");
                query.setParameter("dni", Long.parseLong(this.txtDni.getText()));
                clientes = (List<Cliente>) query.getResultList();
            }
        }
        
        Cliente cliente = new Cliente();
        if (!clientes.isEmpty()) {
            for (Cliente cli : clientes) {
                cliente = cli;
            }

            mostrarCliente(cliente);

        } else {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/cliente/NotFoundCliente.fxml"));
                Parent root = (Parent) loader.load();
                Stage stage = new Stage();
                stage.initModality(Modality.APPLICATION_MODAL);
                stage.setScene(new Scene(root));
                stage.showAndWait();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        man.close();
    }

    public void mostrarCliente(Cliente cliente) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/cliente/ConsultaCliente.fxml"));
            Parent root = (Parent) loader.load();
//        scene.getStylesheets().add("/styles/Styles.css");
            ConsultaClienteController consCliCont = loader.getController();
            consCliCont.setCliente(cliente);
            consCliCont.cargarDatos();
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setTitle("Cliente Nº " + cliente.getId().toString() + " - " + cliente.getApellido() + ", " + cliente.getNombre());
            stage.setScene(new Scene(root));
            stage.showAndWait();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void closeButtonAction() {
        Stage currentStage = (Stage) btnCancelar.getScene().getWindow();
        currentStage.close();
    }

}
