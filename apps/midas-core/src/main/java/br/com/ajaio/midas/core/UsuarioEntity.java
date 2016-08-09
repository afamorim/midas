/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ajaio.midas.core;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 *
 * @author antonio.amorim
 */
@Entity
public class UsuarioEntity {
    
    private Long    codigo;
    private String  login;
    private String  senha;

    @Id @GeneratedValue
    public Long getCodigo() {
        return codigo;
    }
    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }
    
    @Column(name="login")
    public String getLogin() {
        return login;
    }
    public void setLogin(String login) {
        this.login = login;
    }
    
    @Column(name="senha")
    public String getSenha() {
        return senha;
    }
    public void setSenha(String senha) {
        this.senha = senha;
    }
}