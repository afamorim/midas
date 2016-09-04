/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ajaio.midas.desktop.controller;

import br.com.ajaio.midas.desktop.entity.Banco;
import br.com.ajaio.midas.desktop.entity.Conta;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * FXML Controller class
 *
 * @author antonio.amorim
 */
public class ContaCrudFXMLController extends ContaController {

    @FXML
    private TextField   txNumero;
    
    @FXML
    private TextField   txAgencia;
    
    @FXML
    private TableView   tbContas;
    
    @FXML
    private ComboBox    cbBanco;
    
    @FXML
    private TextField   txGerente;
    
    @FXML
    private TextField   txTelefone;
    
    @FXML
    private TextField   txSaldoAtual;
    
    private ApplicationContext  context;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        TableColumn nomeBancoCol = new TableColumn("Banco");
        nomeBancoCol.setMinWidth(200);
        nomeBancoCol.setCellValueFactory(
                new PropertyValueFactory<Conta, String>("nomeBanco"));
        
        TableColumn agenciaCol = new TableColumn("Agência");
        agenciaCol.setMinWidth(200);
        agenciaCol.setCellValueFactory(
                new PropertyValueFactory<Conta, String>("agencia"));
        
        TableColumn contaCol = new TableColumn("Conta");
        contaCol.setMinWidth(200);
        contaCol.setCellValueFactory(
                new PropertyValueFactory<Conta, String>("conta"));
        
        TableColumn saldoCol = new TableColumn("Saldo Atual");
        saldoCol.setMinWidth(200);
        saldoCol.setCellValueFactory(
                new PropertyValueFactory<Conta, String>("saldoAtual"));
        
        TableColumn editar = new TableColumn("Editar");
        
        TableColumn apagar = new TableColumn("Apagar");
        
        tbContas.getColumns().addAll(nomeBancoCol, agenciaCol, contaCol, saldoCol, editar, apagar);
        
        context = new ClassPathXmlApplicationContext("application-context.xml");
    }    
    
}
