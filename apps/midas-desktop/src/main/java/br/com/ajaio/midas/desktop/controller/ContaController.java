/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ajaio.midas.desktop.controller;

import br.com.ajaio.midas.desktop.MainApp;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

/**
 *
 * @author antonio.amorim
 */
public abstract class ContaController extends BaseController{
    
    private MainApp     mainApp;
    
    

    public MainApp getMainApp() {
        return mainApp;
    }
    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
    }
}
