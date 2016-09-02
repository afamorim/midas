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

    public Long getCodigo() {
        return codigo.get();
    }
    public void setCodigo(Long codigo) {
        this.codigo.set(codigo);
    }
    public String getNome() {
        return nome.get();
    }
    public void setNome(String nome) {
        this.nome.set(nome);
    }
    public String getNumeroBanco() {
        return numeroBanco.get();
    }
    public void setNumeroBanco(String numeroBanco) {
        this.numeroBanco.set(numeroBanco);
    }
}