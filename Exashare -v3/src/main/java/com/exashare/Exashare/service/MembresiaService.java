package com.exashare.Exashare.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.exashare.Exashare.repository.MembresiaRepository;
import jakarta.transaction.Transactional;
import java.util.List;
import com.exashare.Exashare.model.Membresia;

@Service
@Transactional
public class MembresiaService {


    @Autowired
    private MembresiaRepository membresiaRepository;

    public List<Membresia> obtenerMembresias(){
        return membresiaRepository.findAll();
    }

     public Membresia obetenerPorId(long id) {
        return membresiaRepository.getById(id);
    }

    public Membresia guardarMembresia(Membresia membresia) {
        return membresiaRepository.save(membresia);
    }

    public void eliminarMembresia(Long id) {
        membresiaRepository.deleteById(id);
    }

    public Membresia updateMembresia(Long id, Membresia membresia) {
        Membresia membresiaToUpdate = membresiaRepository.findById(id).orElse(null);
        if (membresiaToUpdate != null) {
            membresiaToUpdate.setTipo(membresia.getTipo());
            membresiaToUpdate.setFechaInicio(membresia.getFechaInicio());
            membresiaToUpdate.setFechaFin(membresia.getFechaFin());
            membresiaToUpdate.setBeneficios(membresia.getBeneficios());
            return membresiaRepository.save(membresiaToUpdate);
        } else {
            return null;
        }
    }

    public Membresia actualizarMembresiaParcial(Long id, Membresia membresiaParcial) {
        Membresia membresiaExistente = membresiaRepository.findById(id).orElse(null);
        if (membresiaExistente != null) {
            if (membresiaParcial.getTipo() != null) {
                membresiaExistente.setTipo(membresiaParcial.getTipo());
            }
            if (membresiaParcial.getFechaInicio() != null) {
                membresiaExistente.setFechaInicio(membresiaParcial.getFechaInicio());
            }
            if (membresiaParcial.getFechaFin() != null) {
                membresiaExistente.setFechaFin(membresiaParcial.getFechaFin());
            }
            if (membresiaParcial.getBeneficios() != null) {
                membresiaExistente.setBeneficios(membresiaParcial.getBeneficios());
            }
            return membresiaRepository.save(membresiaExistente);
        } else {
            return null;
        }
    }

}
