package com.exashare.Exashare.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.exashare.Exashare.repository.HerramientaRepository;
import jakarta.transaction.Transactional;
import java.util.List;
import com.exashare.Exashare.model.Herramienta;


@Service
@Transactional
public class HerramientaService {

    @Autowired
    private HerramientaRepository HerramientaRepository;

    public List<Herramienta> obtenerHerramientas() {
        return HerramientaRepository.findAll();
    }

    public Herramienta obtenerPorId(long id) {
        return HerramientaRepository.getById(id);
    }

    public Herramienta guardarHerramienta(Herramienta Herramienta) {
        return HerramientaRepository.save(Herramienta);
    }

    public void eliminarHerramienta(Long id) {
        HerramientaRepository.deleteById(id);
    }

    public Herramienta updateHerramienta(Long id, Herramienta Herramienta) {
        Herramienta HerramientaToUpdate = HerramientaRepository.findById(id).orElse(null);
        if (HerramientaToUpdate != null) {
            HerramientaToUpdate.setNombre(Herramienta.getNombre());
            HerramientaToUpdate.setDescripcion(Herramienta.getDescripcion());
            HerramientaToUpdate.setCategoria(Herramienta.getCategoria());
            HerramientaToUpdate.setEstado(Herramienta.getEstado());
            HerramientaToUpdate.setUbicacion(Herramienta.getUbicacion());
            HerramientaToUpdate.setPrecioHerramienta(Herramienta.getPrecioHerramienta());
            return HerramientaRepository.save(HerramientaToUpdate);
        } else {
            return null;
        }
    }

   public Herramienta actualizarHerramientaParcial(Long id, Herramienta herramientaParcial) {
        Herramienta herramientaExistente = HerramientaRepository.findById(id).orElse(null);
        if (herramientaExistente != null) {
            if (herramientaParcial.getNombre() != null) {
                herramientaExistente.setNombre(herramientaParcial.getNombre());
            }
            if (herramientaParcial.getDescripcion() != null) {
                herramientaExistente.setDescripcion(herramientaParcial.getDescripcion());
            }
            if (herramientaParcial.getCategoria() != null) {
                herramientaExistente.setCategoria(herramientaParcial.getCategoria());
            }
            if (herramientaParcial.getUbicacion() != null) {
                herramientaExistente.setUbicacion(herramientaParcial.getUbicacion());
            }
            if (herramientaParcial.getPrecioHerramienta() != null) {
                herramientaExistente.setPrecioHerramienta(herramientaParcial.getPrecioHerramienta());
            }
            return HerramientaRepository.save(herramientaExistente);
        } else {
            return null;
        }
    }
}