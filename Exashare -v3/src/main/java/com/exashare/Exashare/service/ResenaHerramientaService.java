package com.exashare.Exashare.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.exashare.Exashare.repository.ResenaHerramientaRepository;
import jakarta.transaction.Transactional;
import java.util.List;
import com.exashare.Exashare.model.ResenaHerramienta;

@Service
@Transactional
public class ResenaHerramientaService {


    @Autowired
    private ResenaHerramientaRepository resenaHerramientaRepository;

    public List<ResenaHerramienta> obtenerResenas() {
        return resenaHerramientaRepository.findAll();
    }

    public ResenaHerramienta obtenerPorId(long id) {
        return resenaHerramientaRepository.getById(id);
    }

    public ResenaHerramienta guardarResena(ResenaHerramienta resena) {
        return resenaHerramientaRepository.save(resena);
    }

    public void eliminarResena(Long id) {
        resenaHerramientaRepository.deleteById(id);
    }

    public ResenaHerramienta actualizarResena(Long id, ResenaHerramienta resena) {
        ResenaHerramienta resenaToUpdate = resenaHerramientaRepository.findById(id).orElse(null);
        if (resenaToUpdate != null) {
            resenaToUpdate.setPuntuacion(resena.getPuntuacion());
            resenaToUpdate.setComentario(resena.getComentario());
            resenaToUpdate.setFecha(resena.getFecha());
            return resenaHerramientaRepository.save(resenaToUpdate);
        } else {
            return null;
        }
    }

    public ResenaHerramienta actualizarResenaParcial(Long id, ResenaHerramienta resenaParcial) {
        ResenaHerramienta resenaExistente = resenaHerramientaRepository.findById(id).orElse(null);
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
            return resenaHerramientaRepository.save(resenaExistente);
        } else {
            return null;
        }
    }

}
