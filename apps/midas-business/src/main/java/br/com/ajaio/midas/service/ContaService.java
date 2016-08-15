/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ajaio.midas.service;

import br.com.ajaio.midas.core.ContaEntity;
import br.com.ajaio.midas.core.UsuarioEntity;
import br.com.ajaio.midas.repository.ContaRepository;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author antonio.amorim
 */
public class ContaService {
    
    @Autowired
    private ContaRepository contaRepository;

    public Set<ContaEntity> findByUsuario(UsuarioEntity aUsuario){
        return contaRepository.findByUsuario(aUsuario.getCodigo());
    }
    
    public void setContaRepository(ContaRepository contaRepository) {
        this.contaRepository = contaRepository;
    }
}