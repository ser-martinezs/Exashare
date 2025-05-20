package com.exashare.Exashare.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exashare.Exashare.service.HerramientasService;
import com.exashare.Exashare.model.Herramientas;

import java.util.List;

@RestController
@RequestMapping("api/v1/herramientaspuente")
public class HerramientasController {
    @Autowired
    private HerramientasService HerramientasService;

    @GetMapping
    public ResponseEntity<List<Herramientas>> listar() {
        List<Herramientas> Herramientas = HerramientasService.obtenerHerramientas();
        if (Herramientas.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(Herramientas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Herramientas> buscar(@PathVariable Long id) {
        try {
            Herramientas Herramienta = HerramientasService.obtenerPorId(id);
            return ResponseEntity.ok(Herramienta);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
}