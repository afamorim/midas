/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ajaio.midas.desktop.entity;

import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author antonio.amorim
 */
public class Usuario {

    public Usuario(){
        login = new SimpleStringProperty();
        senha = new SimpleStringProperty();
    }
    
    private SimpleLongProperty      codigo;
    private SimpleStringProperty    login;
    private SimpleStringProperty    senha;

    public SimpleLongProperty getCodigo() {
        return codigo;
    }
    public void setCodigo(SimpleLongProperty codigo) {
        this.codigo = codigo;
    }
    public SimpleStringProperty getLogin() {
        return login;
    }
    public void setLogin(SimpleStringProperty login) {
        this.login = login;
    }
    public SimpleStringProperty getSenha() {
        return senha;
    }
    public void setSenha(SimpleStringProperty senha) {
        this.senha = senha;
    }   
}