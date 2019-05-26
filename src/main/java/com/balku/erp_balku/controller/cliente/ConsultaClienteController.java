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
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
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

        Cliente cli = this.cliente;
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

        cli.setLocalidad(localidad.getSelectionModel().getSelectedItem());

        try {
            em.getTransaction().begin();
            em.merge(cli);
            em.getTransaction().commit();
            this.cancelarEditar();

            System.out.println("Se guardo el cliente con el id: " + cli.getId());

        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();

        } finally {
            em.close();
        }
    }

    public void cargarDatos() {

        Cliente cli = this.cliente;
        
        
        this.lblTitulo.setText(cli.getApellido() + ", " + cli.getNombre());
        this.txtNumeroCliente.setText("Nº " + cli.getId().toString());

        this.nombre.setText(cli.getNombre());
        this.apellido.setText(cli.getApellido());
        this.dni.setText(cli.getDni().toString());
        this.fechaNacimiento.setValue(cli.getFechaNacimiento());

        if (cli.getSexo() == "Femenino") {
            this.sexoFemenino.setSelected(true);
        } else {
            this.sexoMasculino.setSelected(true);
        }

        this.direccion.setText(cli.getDireccion());
        this.email.setText(cli.getEmail());
        this.telefono.setText(cli.getTelefono());

        this.whatsapp.setSelected(cli.isWhatsapp());
        this.estadoActivo.setSelected(cli.isEstadoActivo());

        this.usuario.setText(cli.getUsuario());
        this.contrasena.setText(cli.getContrasena());

        this.provincia.getSelectionModel().select(cli.getLocalidad().getProvincia());
        this.cargarLocalidad();

        this.localidad.getSelectionModel().select(cli.getLocalidad());

    }

}
