/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ajaio.midas.desktop.controller;

import br.com.ajaio.midas.core.ContaEntity;
import br.com.ajaio.midas.core.UsuarioEntity;
import br.com.ajaio.midas.desktop.MainApp;
import br.com.ajaio.midas.desktop.entity.Conta;
import br.com.ajaio.midas.service.ContaService;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Set;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.stage.Window;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * FXML Controller class
 *
 * @author afamorim
 */
public class DashBoardController implements Initializable {

    private MainApp             mainApp;
    private UsuarioEntity       usuarioLogado;
    private ApplicationContext  context;
    private Set<ContaEntity>    contas;
    private ContaService        contaService;
    
    @FXML
    private Window              contaFormDialog;
    @FXML
    private TableView           tbContas;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        context = new ClassPathXmlApplicationContext("application-context.xml");
        contaService = (ContaService)context.getBean("contaService");
    }    
    
    public void loadDashBoard(){
        populaTabelaConta();
    }
    
    private void populaTabelaConta(){
        contas = contaService.findByUsuario(usuarioLogado);
        ArrayList<Conta> contasDM = new ArrayList<Conta>();
        for (ContaEntity c : contas){
            Conta conta = new Conta(c);
            contasDM.add(conta);
        }
        final ObservableList<Conta> data = FXCollections.observableArrayList(contasDM);
        TableColumn<Conta, String> contaNomeColumn = new TableColumn<Conta, String>();
        contaNomeColumn.setCellValueFactory(new PropertyValueFactory<Conta, String>("nome"));
        tbContas.setItems(data);
        tbContas.getColumns().addAll(contaNomeColumn);
    }
    
    public void addConta() throws IOException {
        Stage stage = new Stage();
        Parent root = FXMLLoader.load(MainApp.class.getResource("view/popContaFormFXML.fxml"));
        stage.setTitle("Add new entry");
        stage.setScene(new Scene(root, 800, 600));
        stage.show();
    }
    
    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;        
    }

    public void setUsuarioLogado(UsuarioEntity usuarioLogado) {
        this.usuarioLogado = usuarioLogado;
    }
    public Set<ContaEntity> getContas() {
        return contas;
    }
}