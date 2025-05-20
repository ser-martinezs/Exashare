package com.exashare.Exashare.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.exashare.Exashare.repository.UsuarioRepository;
import jakarta.transaction.Transactional;
import java.util.List;
import com.exashare.Exashare.model.Usuario;

@Service
@Transactional
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<Usuario> obtenerUsuarios() {
        return usuarioRepository.findAll();
    }

    public Usuario obtenerPorId(long id) {
        return usuarioRepository.getById(id);
    }

    public Usuario guardarUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public void eliminarUsuario(Long id) {
        usuarioRepository.deleteById(id);
    }

    public Usuario actualizarUsuario(Long id, Usuario usuario) {
        Usuario usuarioToUpdate = usuarioRepository.findById(id).orElse(null);
        if (usuarioToUpdate != null) {
            usuarioToUpdate.setNombreUsuario(usuario.getNombreUsuario());
            usuarioToUpdate.setEmail(usuario.getEmail());
            usuarioToUpdate.setContraseña(usuario.getContraseña());
            usuarioToUpdate.setDireccion(usuario.getDireccion());
            usuarioToUpdate.setTelefono(usuario.getTelefono());
            return usuarioRepository.save(usuarioToUpdate);
        } else {
            return null;
        }
    }

    public Usuario actualizarUsuarioParcial(Long id, Usuario usuarioParcial) {
        Usuario usuarioExistente = usuarioRepository.findById(id).orElse(null);
        if (usuarioExistente != null) {
            if (usuarioParcial.getNombreUsuario() != null) {
                usuarioExistente.setNombreUsuario(usuarioParcial.getNombreUsuario());
            }
            if (usuarioParcial.getEmail() != null) {
                usuarioExistente.setEmail(usuarioParcial.getEmail());
            }
            if (usuarioParcial.getContraseña() != null) {
                usuarioExistente.setContraseña(usuarioParcial.getContraseña());
            }
            if (usuarioParcial.getDireccion() != null) {
                usuarioExistente.setDireccion(usuarioParcial.getDireccion());
            }
            if (usuarioParcial.getTelefono() != null) {
                usuarioExistente.setTelefono(usuarioParcial.getTelefono());
            }
            return usuarioRepository.save(usuarioExistente);
        } else {
            return null;
        }
    }
    

}
