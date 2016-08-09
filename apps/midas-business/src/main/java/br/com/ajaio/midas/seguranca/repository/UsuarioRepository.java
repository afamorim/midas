/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ajaio.midas.seguranca.repository;

import br.com.ajaio.midas.core.UsuarioEntity;

/**
 *
 * @author afamorim
 */
public interface UsuarioRepository extends PagingAndSortingRepository<UsuarioEntity, Long>{
    
    @Query(value = "SELECT * FROM PERSON p WHERE p.name like :pattern", nativeQuery = true)
    Set<Person> searchNatively(@Param("pattern") String pattern);
}
