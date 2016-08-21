/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ajaio.midas.desktop.controller;

import br.com.ajaio.midas.core.BancoEntity;
import br.com.ajaio.midas.desktop.MainApp;
import br.com.ajaio.midas.desktop.entity.Banco;
import br.com.ajaio.midas.service.BancoService;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
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
public class BancoCrudFXMLController extends BaseController {

    @FXML
    private TextField   txNome;
    
    @FXML
    private TextField   txNumero;
    
    private MainApp     mainApp;
    
    @FXML
    private TableView   tbBancos;
    
    private ApplicationContext  context;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        TableColumn nomeCol = new TableColumn("Nome Banco");
        nomeCol.setMinWidth(200);
        nomeCol.setCellValueFactory(
                new PropertyValueFactory<Banco, String>("nome"));
        
        TableColumn numeroCol = new TableColumn("Número Banco");
        nomeCol.setMinWidth(150);
        nomeCol.setCellValueFactory(
                new PropertyValueFactory<Banco, String>("numero"));
        
        tbBancos.getColumns().addAll(nomeCol, numeroCol);
        
        context = new ClassPathXmlApplicationContext("application-context.xml");
    }    
    
    public void salvar(){
        try {
            BancoService bancoService = (BancoService)context.getBean("bancoService");
            
            BancoEntity banco = new BancoEntity();
            banco.setNome(txNome.getText());
            banco.setNumero(new Integer(txNumero.getText()));
            
            if (banco.getCodigo() == null){
                banco = bancoService.insert(banco);
            }else{
                bancoService.update(banco);
            }
            
            mensagemSucesso("Banco Salvo com sucesso.");
        } catch (Exception e) {
            tratarExcecao(e);
        }
    }
    
    public void consultar(){
        try {
            BancoEntity filtro = new BancoEntity();
            BancoService bancoService = (BancoService)context.getBean("bancoService");
            
            Iterable<BancoEntity> bancos = bancoService.findAll();
            Iterator itBanco = bancos.iterator();
            ArrayList<Banco> bancosDM = new ArrayList<Banco>();
            for (BancoEntity b : bancos){
                Banco banco = new Banco(b);
                bancosDM.add(banco);
            }
            final ObservableList<Banco> data = FXCollections.observableArrayList(bancosDM);
            tbBancos.setItems(data);
        } catch (Exception e) {
            tratarExcecao(e);
        }
    }
    
    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
    }
}
