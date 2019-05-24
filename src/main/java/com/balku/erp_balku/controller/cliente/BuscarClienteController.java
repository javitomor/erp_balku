package com.balku.erp_balku.controller.cliente;

import com.balku.erp_balku.controller.ModelController;
import com.balku.erp_balku.model.Cliente;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javax.persistence.EntityManager;

public class BuscarClienteController implements Initializable {

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    @FXML
    private JFXTextField txtNumero;

    @FXML
    private JFXButton btnBuscar;

    @FXML
    private JFXButton btnCancelar;

    public void buscarCliente() {

        EntityManager man = ModelController.getEntityManager();
        Cliente cliente = (Cliente) man.find (Cliente.class, (Long.parseLong(txtNumero.getText())));
        //System.out.println(cliente);
        
        mostrarCliente(cliente);
        
        man.close();

    }

    public void mostrarCliente(Cliente cliente) {
        try {
            
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/cliente/ConsultaCliente.fxml"));
            Parent root = (Parent) loader.load();

//        scene.getStylesheets().add("/styles/Styles.css");
            ConsultaClienteController consCliCont = loader.getController();
            consCliCont.cargarDatos(cliente);

            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setTitle("Cliente Nº "+ cliente.getId().toString()+" - "+cliente.getApellido()+", "+cliente.getNombre());
            stage.setScene(new Scene(root));

            stage.showAndWait();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
