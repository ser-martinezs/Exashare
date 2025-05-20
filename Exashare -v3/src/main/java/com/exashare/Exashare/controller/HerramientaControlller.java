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

import com.exashare.Exashare.service.HerramientaService;
import com.exashare.Exashare.model.Herramienta;

import java.util.List;

@RestController
@RequestMapping("api/v1/herramientas")
public class HerramientaControlller {
    @Autowired
    private HerramientaService HerramientaService;

    @GetMapping
    public ResponseEntity<List<Herramienta>> listar() {
        List<Herramienta> Herramientas = HerramientaService.obtenerHerramientas();
        if (Herramientas.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(Herramientas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Herramienta> buscar(@PathVariable Long id) {
        try {
            Herramienta Herramienta = HerramientaService.obtenerPorId(id);
            return ResponseEntity.ok(Herramienta);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Herramienta> guardar(@RequestBody Herramienta Herramienta) {
        Herramienta nuevoHerramienta = HerramientaService.guardarHerramienta(Herramienta);
        return ResponseEntity.status(201).body(nuevoHerramienta);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        try {
            HerramientaService.eliminarHerramienta(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Herramienta> actualizar(@PathVariable Long id, @RequestBody Herramienta Herramienta) {
        try {
            Herramienta HerramientaoActualizado = HerramientaService.updateHerramienta(id, Herramienta);
            return ResponseEntity.ok(HerramientaoActualizado);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Herramienta> editar(@PathVariable Long id, @RequestBody Herramienta Herramienta) {
        Herramienta HerramientaActualizada = HerramientaService.actualizarHerramientaParcial(id, Herramienta);
        if (HerramientaActualizada == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(HerramientaActualizada);
    }

}
