/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ajaio.midas.seguranca.service;

import br.com.ajaio.midas.core.UsuarioEntity;
import br.com.ajaio.midas.seguranca.repository.UsuarioRepository;
import com.vortice.core.exception.AplicacaoException;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author antonio.amorim
 */
public class UsuarioService {
    
    @Autowired
    private UsuarioRepository   usuarioRepository;
    
    public UsuarioEntity insert(UsuarioEntity aUsuario) throws AplicacaoException{
        return usuarioRepository.save(aUsuario);
    }
    
    public UsuarioEntity login(UsuarioEntity aUsuario) throws AplicacaoException{
        UsuarioEntity retorno = usuarioRepository.findByLoginAndSenha(aUsuario.getLogin(), aUsuario.getSenha());
        if (retorno != null)
            return retorno;
        else throw new AplicacaoException("Os dados informados, login ou senha, não são válidos.");
    }

    public void setUsuarioRepository(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }
}
