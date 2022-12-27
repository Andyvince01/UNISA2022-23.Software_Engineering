/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML.java to edit this template
 */
package project_se;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

/**
 *
 * @author andyv
 */
public class Project_SE extends Application {
    
    
    /** 
     * @param stage
     * @throws Exception
     * Start the application, give it a title and an icon, also the "FXML" file is loaded
     */
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        
        Scene scene = new Scene(root);
        
        stage.setTitle("Paint");
        stage.getIcons().add(new Image("https://upload.wikimedia.org/wikipedia/commons/thumb/2/2b/Microsoft_Paint.svg/600px-Microsoft_Paint.svg.png"));
        stage.setScene(scene);
        stage.show();
    }

    /**
     * @param args the command line arguments
     * It launchs the program.
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
