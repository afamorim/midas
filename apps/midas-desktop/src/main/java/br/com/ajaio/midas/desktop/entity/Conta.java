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
        nome = new SimpleStringProperty();
        setNome(c);
    }
    
    private SimpleLongProperty      codigo;
    private SimpleStringProperty    nome;

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
    
    public void setNome(ContaEntity c){
        nome.set((new StringBuilder(c.getBanco().getNome()).append(" - Ag: ")
                .append(c.getAgencia()).append(" - CC: ").append(c.getNumero())).toString());
    }
}