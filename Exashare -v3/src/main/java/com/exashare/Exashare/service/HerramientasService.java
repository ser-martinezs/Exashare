package com.exashare.Exashare.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import com.exashare.Exashare.repository.HerramientasRepository;
import jakarta.transaction.Transactional;
import com.exashare.Exashare.model.Herramientas;

@Service
@Transactional
public class HerramientasService {

    @Autowired
    private HerramientasRepository HerramientasRepository;

    public List<Herramientas> obtenerHerramientas() {
        return HerramientasRepository.findAll();
    }

    public Herramientas obtenerPorId(long id) {
        return HerramientasRepository.getById(id);
    }
}