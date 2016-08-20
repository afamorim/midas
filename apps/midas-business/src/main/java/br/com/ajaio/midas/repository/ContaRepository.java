/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ajaio.midas.repository;

import br.com.ajaio.midas.core.ContaEntity;
import br.com.ajaio.midas.core.UsuarioEntity;
import java.util.Set;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author antonio.amorim
 */
@Repository
public interface ContaRepository extends CrudRepository<ContaEntity, Long>{
    
    public Set<ContaEntity> findByUsuario(UsuarioEntity aUsuario);
}
