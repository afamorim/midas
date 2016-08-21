/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ajaio.midas.service;

import br.com.ajaio.midas.core.BancoEntity;
import br.com.ajaio.midas.repository.BancoRepository;
import com.vortice.core.exception.AplicacaoException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author antonio.amorim
 */
public class BancoService {
    
    @Autowired
    private BancoRepository bancoRepository;
    
    public BancoEntity insert(BancoEntity aBanco) throws AplicacaoException{
        aBanco = bancoRepository.save(aBanco);
        return aBanco;
    }
    
    public void update(BancoEntity aBanco) throws AplicacaoException{
        aBanco = bancoRepository.save(aBanco);
    }
    
    public Iterable<BancoEntity> findAll(){
        return bancoRepository.findAll();
    }

    public void setBancoRepository(BancoRepository bancoRepository) {
        this.bancoRepository = bancoRepository;
    }
}