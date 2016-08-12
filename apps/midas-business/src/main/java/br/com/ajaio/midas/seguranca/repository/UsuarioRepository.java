/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ajaio.midas.seguranca.repository;

import br.com.ajaio.midas.core.UsuarioEntity;
import java.io.Serializable;
import java.util.List;
import java.util.Set;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author afamorim
 */
public interface UsuarioRepository extends CrudRepository<UsuarioEntity, Long>{//PagingAndSortingRepository<UsuarioEntity, Long>{
    
    @Query(value = "SELECT * FROM PERSON p WHERE p.name like :pattern", nativeQuery = true)
    Set<UsuarioEntity> searchNatively(@Param("pattern") String pattern);
    
    Set<UsuarioEntity> findByLoginAndSenha(@Param("login") String login, @Param("senha") String senha);
}
