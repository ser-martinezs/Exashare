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

import com.exashare.Exashare.service.MembresiaService;
import com.exashare.Exashare.model.Membresia;

import java.util.List;

@RestController
@RequestMapping("api/v1/membresias")
public class MembresiaController {


    @Autowired
    private MembresiaService membresiaService;

    @GetMapping
    public ResponseEntity<List<Membresia>> listar() {
        List<Membresia> arriendos = membresiaService.obtenerMembresias();
        if (arriendos.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(arriendos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Membresia> buscar(@PathVariable Long id) {
        try {
            Membresia membresia = membresiaService.obetenerPorId(id);
            return ResponseEntity.ok(membresia);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Membresia> guardar(@RequestBody Membresia membresia) {
        Membresia nuevaMembresia = membresiaService.guardarMembresia(membresia);
        return ResponseEntity.status(201).body(nuevaMembresia);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        try {
            membresiaService.eliminarMembresia(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Membresia> actualizar(@PathVariable Long id, @RequestBody Membresia membresia) {
        try {
            Membresia arriendooActualizado = membresiaService.updateMembresia(id, membresia);
            return ResponseEntity.ok(arriendooActualizado);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Membresia> editar(@PathVariable Long id, @RequestBody Membresia membresia) {
        Membresia membresiaActualizada = membresiaService.actualizarMembresiaParcial(id, membresia);
        if (membresiaActualizada == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(membresiaActualizada);
    }
}
