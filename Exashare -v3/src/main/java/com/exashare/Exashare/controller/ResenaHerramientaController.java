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

import com.exashare.Exashare.model.ResenaHerramienta;
import com.exashare.Exashare.service.ResenaHerramientaService;

import java.util.List;

@RestController
@RequestMapping("api/v1/resenasherramientas")
public class ResenaHerramientaController {

    @Autowired
    private ResenaHerramientaService resenaHerramientaService;

    @GetMapping
    public ResponseEntity<List<ResenaHerramienta>> listar() {
        List<ResenaHerramienta> resenas = resenaHerramientaService.obtenerResenas();
        if (resenas.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(resenas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResenaHerramienta> buscar(@PathVariable Long id) {
        try {
            ResenaHerramienta resena = resenaHerramientaService.obtenerPorId(id);
            return ResponseEntity.ok(resena);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<ResenaHerramienta> guardar(@RequestBody ResenaHerramienta resena) {
        ResenaHerramienta nuevaResena = resenaHerramientaService.guardarResena(resena);
        return ResponseEntity.status(201).body(nuevaResena);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        try {
            resenaHerramientaService.eliminarResena(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<ResenaHerramienta> actualizar(@PathVariable Long id, @RequestBody ResenaHerramienta resena) {
        try {
            ResenaHerramienta resenaActualizada = resenaHerramientaService.actualizarResena(id, resena);
            return ResponseEntity.ok(resenaActualizada);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PatchMapping("/{id}")
    public ResponseEntity<ResenaHerramienta> editar(@PathVariable Long id, @RequestBody ResenaHerramienta resena) {
        ResenaHerramienta resenaActualizada = resenaHerramientaService.actualizarResenaParcial(id, resena);
        if (resenaActualizada == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(resenaActualizada);
    }

}
