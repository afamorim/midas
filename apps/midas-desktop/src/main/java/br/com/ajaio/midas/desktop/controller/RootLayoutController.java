/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ajaio.midas.desktop.controller;

import br.com.ajaio.midas.desktop.MainApp;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;

/**
 * FXML Controller class
 *
 * @author antonio.amorim
 */
public class RootLayoutController extends BaseController {

    private MainApp         mainApp;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }    
    
    public void goToBancoForm(){
        mainApp.showBancoCrud();
    }
    
    public void goToDashBoard(){
        mainApp.showDashBoardView();
    }

    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
    }
}