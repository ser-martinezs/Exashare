package com.exashare.Exashare.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exashare.Exashare.model.TipoUsuario;
import com.exashare.Exashare.repository.TipoUsuarioRepository;

import jakarta.transaction.Transactional;

import java.util.List;

@Service
@Transactional
public class TipoUsuarioService {

    @Autowired
    private TipoUsuarioRepository tipoUsuarioRepository;

    public List<TipoUsuario> obtenerTiposUsuario() {
        return tipoUsuarioRepository.findAll();
    }

    public TipoUsuario obtenerPorId(long id) {
        return tipoUsuarioRepository.getById(id);
    }

    public TipoUsuario guardarTipoUsuario(TipoUsuario tipoUsuario) {
        return tipoUsuarioRepository.save(tipoUsuario);
    }

    public void eliminarTipoUsuario(Long id) {
        tipoUsuarioRepository.deleteById(id);
    }

    public TipoUsuario actualizarTipoUsuario(Long id, TipoUsuario tipoUsuario) {
        TipoUsuario tipoToUpdate = tipoUsuarioRepository.findById(id).orElse(null);
        if (tipoToUpdate != null) {
            tipoToUpdate.setNombreTipoUsuario(tipoUsuario.getNombreTipoUsuario());
            tipoToUpdate.setDescripcionTipoUsuario(tipoUsuario.getDescripcionTipoUsuario());
            return tipoUsuarioRepository.save(tipoToUpdate);
        } else {
            return null;
        }
    }

    public TipoUsuario actualizarTipoUsuarioParcial(Long id, TipoUsuario tipoUsuarioParcial) {
        TipoUsuario tipoExistente = tipoUsuarioRepository.findById(id).orElse(null);
        if (tipoExistente != null) {
            if (tipoUsuarioParcial.getNombreTipoUsuario() != null) {
                tipoExistente.setNombreTipoUsuario(tipoUsuarioParcial.getNombreTipoUsuario());
            }
            if (tipoUsuarioParcial.getDescripcionTipoUsuario() != null) {
                tipoExistente.setDescripcionTipoUsuario(tipoUsuarioParcial.getDescripcionTipoUsuario());
            }
            return tipoUsuarioRepository.save(tipoExistente);
        } else {
            return null;
        }
    }

}
