/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ajaio.midas.desktop.controller;

import br.com.ajaio.midas.core.ContaEntity;
import br.com.ajaio.midas.core.UsuarioEntity;
import br.com.ajaio.midas.desktop.MainApp;
import br.com.ajaio.midas.service.ContaService;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Set;
import javafx.fxml.Initializable;
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
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        context = new ClassPathXmlApplicationContext("application-context.xml");
        contaService = (ContaService)context.getBean("contaService");
    }    
    
    public void loadDashBoard(){
        contas = contaService.findByUsuario(usuarioLogado);
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