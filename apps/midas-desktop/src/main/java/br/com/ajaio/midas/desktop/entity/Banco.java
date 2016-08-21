/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ajaio.midas.desktop.entity;

import br.com.ajaio.midas.core.BancoEntity;
import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author antonio.amorim
 */
public class Banco {
    
    public Banco(){}
    
    public Banco(BancoEntity aBanco){
        codigo = new SimpleLongProperty(aBanco.getCodigo());
        nome = new SimpleStringProperty(aBanco.getNome());
        numeroBanco = new SimpleStringProperty((aBanco.getNumero() != null) 
                ? aBanco.getNumero().toString() 
                : null);
    }
    
    private SimpleLongProperty      codigo;
    private SimpleStringProperty    nome;
    private SimpleStringProperty    numeroBanco;

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
}