/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ajaio.midas.desktop.controller;

import br.com.ajaio.midas.core.UsuarioEntity;
import br.com.ajaio.midas.desktop.MainApp;
import br.com.ajaio.midas.seguranca.service.UsuarioService;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * FXML Controller class
 *
 * @author antonio.amorim
 */
public class LoginController extends BaseController {

    @FXML
    private TextField       txLogin;
    
    @FXML
    private PasswordField   txSenha;
    
    private MainApp         mainApp;
    
    private ApplicationContext  context;
    
    private UsuarioEntity usuarioLogado;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       context = new ClassPathXmlApplicationContext("application-context.xml");
    }
    
    public void logar(){
        UsuarioService usuarioService = (UsuarioService)context.getBean("usuarioService");
        usuarioLogado = new UsuarioEntity();
        usuarioLogado.setLogin(txLogin.getText());
        usuarioLogado.setSenha(txSenha.getText());
        try {
            usuarioLogado = usuarioService.login(usuarioLogado);
        if (usuarioLogado != null){
            System.out.println("br.com.ajaio.midas.desktop.controller.LoginController.logar()");
            mainApp.setUsuarioLogado(usuarioLogado);
            mainApp.showDashBoardView();
        }
        } catch (Exception e) {
            tratarExcecao(e);
        }
    }

    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
    }

    public UsuarioEntity getUsuarioLogado() {
        return usuarioLogado;
    }
}
