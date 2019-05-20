package com.balku.erp_balku.main;

import com.balku.erp_balku.controller.ModelController;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javax.persistence.EntityManager;


public class MainApp extends Application {

    private static EntityManager manager;
            
    @Override
    public void start(Stage stage) throws Exception {

        
        
        
        Parent root = FXMLLoader.load(getClass().getResource("/view/cliente/AltaCliente.fxml"));
        Scene scene = new Scene(root);
//        scene.getStylesheets().add("/styles/Styles.css");
        
        stage.setTitle("Alta de Cliente");
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void init(){
    
        manager = ModelController.getEntityManager();
        
    }
    /**
     * The main() method is ignored in correctly deployed JavaFX application.
     * main() serves only as fallback in case the application can not be
     * launched through deployment artifacts, e.g., in IDEs with limited FX
     * support. NetBeans ignores main().
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
