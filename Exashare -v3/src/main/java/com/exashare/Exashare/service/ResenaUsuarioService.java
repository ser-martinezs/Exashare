package com.exashare.Exashare.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.exashare.Exashare.repository.ResenaUsuarioRepository;
import jakarta.transaction.Transactional;
import java.util.List;
import com.exashare.Exashare.model.ResenaUsuario;

@Service
@Transactional
public class ResenaUsuarioService {


    @Autowired
    private ResenaUsuarioRepository resenaUsuarioRepository;

    public List<ResenaUsuario> obtenerResenas() {
        return resenaUsuarioRepository.findAll();
    }

    public ResenaUsuario obtenerPorId(long id) {
        return resenaUsuarioRepository.getById(id);
    }

    public ResenaUsuario guardarResena(ResenaUsuario resena) {
        return resenaUsuarioRepository.save(resena);
    }

    public void eliminarResena(Long id) {
        resenaUsuarioRepository.deleteById(id);
    }

    public ResenaUsuario actualizarResena(Long id, ResenaUsuario resena) {
        ResenaUsuario resenaToUpdate = resenaUsuarioRepository.findById(id).orElse(null);
        if (resenaToUpdate != null) {
            resenaToUpdate.setPuntuacion(resena.getPuntuacion());
            resenaToUpdate.setComentario(resena.getComentario());
            resenaToUpdate.setFecha(resena.getFecha());
            return resenaUsuarioRepository.save(resenaToUpdate);
        } else {
            return null;
        }
    }

    public ResenaUsuario actualizarResenaParcial(Long id, ResenaUsuario resenaParcial) {
        ResenaUsuario resenaExistente = resenaUsuarioRepository.findById(id).orElse(null);
        if (resenaExistente != null) {
            if (resenaParcial.getPuntuacion() != null) {
                resenaExistente.setPuntuacion(resenaParcial.getPuntuacion());
            }
            if (resenaParcial.getComentario() != null) {
                resenaExistente.setComentario(resenaParcial.getComentario());
            }
            if (resenaParcial.getFecha() != null) {
                resenaExistente.setFecha(resenaParcial.getFecha());
            }
            return resenaUsuarioRepository.save(resenaExistente);
        } else {
            return null;
        }
    }
   
}
