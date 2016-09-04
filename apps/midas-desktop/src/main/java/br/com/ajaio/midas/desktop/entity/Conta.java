/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ajaio.midas.desktop.entity;

import br.com.ajaio.midas.core.ContaEntity;
import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author antonio.amorim
 */
public class Conta {
    
    public Conta(){}
    
    public Conta(ContaEntity c){
        nomeBanco = new SimpleStringProperty();
        setNomeBanco(c);
        
    }
    
    private SimpleLongProperty      codigo;
    private SimpleStringProperty    nomeBanco;
    private SimpleStringProperty    nomeAgencia;
    private SimpleStringProperty    nomeConta;
    private SimpleStringProperty    gerente;
    private SimpleStringProperty    telefone;
    private SimpleStringProperty    saldoAtual;

    public SimpleLongProperty getCodigo() {
        return codigo;
    }
    public void setCodigo(SimpleLongProperty codigo) {
        this.codigo = codigo;
    }

    public SimpleStringProperty getNomeBanco() {
        return nomeBanco;
    }
    public void setNomeBanco(SimpleStringProperty nome) {
        this.nomeBanco = nome;
    }
    
    public void setNomeBanco(ContaEntity c){
        nomeBanco.set(c.getBanco().getNome());
    }
}