/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ajaio.midas.core;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *
 * @author antonio.amorim
 */
@Entity(name = "conta")
public class ContaEntity {
    
    private Long            codigo;
    private UsuarioEntity   usuario;
    private BancoEntity     banco;
    private String          agencia;
    private String          numero;
    private Double          saldo;
    private String          gerente;
    private String          telefone;

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getCodigo() {
        return codigo;
    }
    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    @ManyToOne
    @JoinColumn(name="usuario_codigo")
    public UsuarioEntity getUsuario() {
        return usuario;
    }
    public void setUsuario(UsuarioEntity usuario) {
        this.usuario = usuario;
    }

    @ManyToOne
    @JoinColumn(name = "banco_codigo")
    public BancoEntity getBanco() {
        return banco;
    }
    public void setBanco(BancoEntity banco) {
        this.banco = banco;
    }

    @Column(name = "agencia")
    public String getAgencia() {
        return agencia;
    }
    public void setAgencia(String agencia) {
        this.agencia = agencia;
    }

    @Column(name="numero")
    public String getNumero() {
        return numero;
    }
    public void setNumero(String numero) {
        this.numero = numero;
    }

    @Column(name="saldo")
    public Double getSaldo() {
        return saldo;
    }
    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    @Column(name="gerente")
    public String getGerente() {
        return gerente;
    }
    public void setGerente(String gerente) {
        this.gerente = gerente;
    }

    @Column(name="telefone")
    public String getTelefone() {
        return telefone;
    }
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    
}
