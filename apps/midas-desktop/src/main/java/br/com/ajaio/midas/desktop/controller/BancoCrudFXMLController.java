/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ajaio.midas.desktop.controller;

import br.com.ajaio.midas.desktop.MainApp;
import br.com.ajaio.midas.desktop.entity.Banco;
import br.com.ajaio.midas.desktop.entity.Conta;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author antonio.amorim
 */
public class BancoCrudFXMLController extends BaseController {

    @FXML
    private TextField   txNome;
    
    @FXML
    private TextField   txNumero;
    
    private MainApp     mainApp;
    
    @FXML
    private TableView   tbBancos;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        TableColumn nomeCol = new TableColumn("Nome Banco");
        nomeCol.setMinWidth(100);
        nomeCol.setCellValueFactory(
                new PropertyValueFactory<Banco, String>("nome"));
        
        TableColumn numeroCol = new TableColumn("Número Banco");
        nomeCol.setMinWidth(100);
        nomeCol.setCellValueFactory(
                new PropertyValueFactory<Banco, String>("numero"));
        
        tbBancos.getColumns().addAll(nomeCol, numeroCol);
    }    
    
    public void salvar(){
        try {
            mensagemSucesso("Banco Salvo com sucesso.");
            System.out.println("TESTE DO SALVAR");
        } catch (Exception e) {
            tratarExcecao(e);
        }
    }
    
    public void consultar(){
        System.out.println("TESTE DO CONSULTAR");
    }
    
    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
    }
}
