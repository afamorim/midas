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
public class Banco {
    private SimpleLongProperty      codigo;
    private SimpleStringProperty    nome;
    private SimpleStringProperty    numeroBanco;
    private Usuario                 usuario;

    public SimpleLongProperty getCodigo() {
        return codigo;
    }
    public void setCodigo(SimpleLongProperty codigo) {
        this.codigo = codigo;
    }
    public SimpleStringProperty getNome() {
        return nome;
    }
    public void setNome(SimpleStringProperty nome) {
        this.nome = nome;
    }
    public SimpleStringProperty getNumeroBanco() {
        return numeroBanco;
    }
    public void setNumeroBanco(SimpleStringProperty numeroBanco) {
        this.numeroBanco = numeroBanco;
    }   
    public Usuario getUsuario() {
        return usuario;
    }
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}