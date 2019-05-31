/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.balku.erp_balku.controller.cliente;

import com.balku.erp_balku.controller.ModelController;
import com.balku.erp_balku.model.Cliente;
import com.balku.erp_balku.model.Localidad;
import com.balku.erp_balku.model.Provincia;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.controls.JFXToggleButton;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javax.persistence.EntityManager;

/**
 * FXML Controller class
 *
 * @author javiermoreno
 */
public class ConsultaClienteController implements Initializable {

    public static Cliente cliente = new Cliente();

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
        this.estadoActivo.setDisable(editar);

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
        this.estadoActivo.setDisable(editar);

    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void cargarLocalidad() {
        List<Localidad> localidades = provincia.getSelectionModel().getSelectedItem().getLocalidad();
        localidad.getItems().remove(0, localidad.getItems().size());
        for (Localidad loc : localidades) {
            localidad.getItems().add(loc);
        }
    }

    public void closeButtonAction() {
        Stage currentStage = (Stage) btnCancelar.getScene().getWindow();
        currentStage.close();
    }

    public void updateCliente() {
        EntityManager em = ModelController.getEntityManager();
        boolean success = false;
        this.cliente.setNombre(this.nombre.getText());
        this.cliente.setApellido(this.apellido.getText());
        this.cliente.setDni(Long.parseLong(this.dni.getText()));
        this.cliente.setFechaNacimiento(this.fechaNacimiento.getValue());

        RadioButton selectedRadioButton = (RadioButton) this.GroupSexo.getSelectedToggle();
        this.cliente.setSexo(selectedRadioButton.getText());

        this.cliente.setDireccion(this.direccion.getText());
        this.cliente.setTelefono(this.telefono.getText());
        this.cliente.setWhatsapp(this.whatsapp.isSelected());
        this.cliente.setEmail(this.email.getText());
        this.cliente.setEstadoActivo(this.estadoActivo.isSelected());

        this.cliente.setLocalidad(localidad.getSelectionModel().getSelectedItem());

        try {
            em.getTransaction().begin();
            em.merge(this.cliente);
            em.getTransaction().commit();
            this.cancelarEditar();

            success = true;
            System.out.println("Se guardo el cliente con el id: " + this.cliente.getId());

        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();

        } finally {
            mostrarMensajeUpdate(success);
            em.close();
        }
    }

    public void cargarDatos() {

        this.lblTitulo.setText(this.cliente.getApellido() + ", " + this.cliente.getNombre());
        this.txtNumeroCliente.setText("Nº " + this.cliente.getId().toString());
        this.nombre.setText(this.cliente.getNombre());
        this.apellido.setText(this.cliente.getApellido());
        this.dni.setText(this.cliente.getDni().toString());
        this.fechaNacimiento.setValue(this.cliente.getFechaNacimiento());
        if (this.cliente.getSexo().equals(new String("Femenino"))) {
            this.sexoFemenino.setSelected(true);
        } else {
            this.sexoMasculino.setSelected(true);
        }
        this.direccion.setText(this.cliente.getDireccion());
        this.email.setText(this.cliente.getEmail());
        this.telefono.setText(this.cliente.getTelefono());
        this.whatsapp.setSelected(this.cliente.isWhatsapp());
        this.estadoActivo.setSelected(this.cliente.isEstadoActivo());
        this.usuario.setText(this.cliente.getUsuario());
        this.contrasena.setText(this.cliente.getContrasena());
        this.provincia.getSelectionModel().select(this.cliente.getLocalidad().getProvincia());
        this.cargarLocalidad();
        this.localidad.getSelectionModel().select(this.cliente.getLocalidad());

    }

    public void mostrarMensajeUpdate(boolean success) {
        try {
            String view;
            if (success) {
                view = "/view/cliente/UpdateClienteSuccess.fxml";
            } else {
                view = "/view/cliente/UpdateClienteFail.fxml";
            }
            FXMLLoader loader = new FXMLLoader(getClass().getResource(view));
            Parent root = (Parent) loader.load();
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(new Scene(root));
            stage.showAndWait();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
