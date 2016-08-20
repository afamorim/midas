/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ajaio.midas.desktop.controller;

import com.vortice.core.exception.AplicacaoException;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;

/**
 *
 * @author antonio.amorim
 */
public abstract class BaseController implements Initializable{
    
    public void tratarExcecao(Exception e){
        Alert alertaErro = new Alert(Alert.AlertType.ERROR);
        alertaErro.setTitle("Erro no sistema");
        if (e instanceof AplicacaoException){
            alertaErro.setContentText(e.getMessage());
        }else{
            alertaErro.setContentText("ERRO NO SISTEMA, ENTRE EM CONTATO COM O ADMINISTRADOR");
        }
        e.printStackTrace();
        alertaErro.showAndWait();
    }
    
    public void mensagemSucesso(String mensagemSucesso){
        Alert alertaSucesso = new Alert(Alert.AlertType.INFORMATION);
        alertaSucesso.setTitle("Mensagem de Sucesso");
        alertaSucesso.setHeaderText(mensagemSucesso);
        
        alertaSucesso.showAndWait();
    }
}
