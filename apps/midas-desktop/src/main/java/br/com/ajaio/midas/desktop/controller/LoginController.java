/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ajaio.midas.desktop.controller;

import br.com.ajaio.midas.desktop.MainApp;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author antonio.amorim
 */
public class LoginController implements Initializable {

    @FXML
    private TextField       txLogin;
    
    @FXML
    private PasswordField   txSenha;
    
    private MainApp         mainApp;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
    
    public void logar(){
        if ("admin".equals(txLogin.getText()) 
                && "admin".equals(txSenha.getText())){
            System.out.println("br.com.ajaio.midas.desktop.controller.LoginController.logar()");
            mainApp.showDashBoardView();
        }
    }

    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
    }    
}
