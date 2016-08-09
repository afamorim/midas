/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ajaio.midas.desktop;

import br.com.ajaio.midas.desktop.controller.DashBoardController;
import br.com.ajaio.midas.desktop.controller.LoginController;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 *
 * @author afamorim
 */
public class MainApp extends Application {
    private BorderPane rootLayout;
    
    private Stage primaryStage; 
    
    @Override
    public void start(Stage stage) throws Exception {
        primaryStage = stage;
        
//        rootLayout = FXMLLoader.load(getClass().getResource("mainAppFXML.fxml"));
//        
//        Scene scene = new Scene(rootLayout);
//        
//        primaryStage.setScene(scene);
//        primaryStage.show();
        initRootLayout();
        
        showLoginView();
    }
    
    public void initRootLayout(){
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/rootLayoutFXML.fxml"));
            System.out.println(MainApp.class.getResource("view/rootLayoutFXML.fxml"));
            rootLayout = (BorderPane) loader.load();
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private void showLoginView(){
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/loginFXML.fxml"));
            AnchorPane loginview = (AnchorPane) loader.load();
            
            LoginController controller = loader.getController();
            controller.setMainApp(this);
            
            rootLayout.setCenter(loginview);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void showDashBoardView(){
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/dashBoardFXML.fxml"));
            AnchorPane dashBoardOverview = (AnchorPane) loader.load();
            
            DashBoardController controller = loader.getController();
            controller.setMainApp(this);
            
            rootLayout.setCenter(dashBoardOverview);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}