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

import com.exashare.Exashare.service.ArriendoService;
import com.exashare.Exashare.model.Arriendo;

import java.util.List;

@RestController
@RequestMapping("api/v1/arriendos")
public class ArriendoController {

    @Autowired
    private ArriendoService arriendoService;

    @GetMapping
    public ResponseEntity<List<Arriendo>> listar() {
        List<Arriendo> arriendos = arriendoService.obtenerArriendos();
        if (arriendos.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(arriendos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Arriendo> buscar(@PathVariable Long id) {
        try {
            Arriendo arriendo = arriendoService.obtenerPorId(id);
            return ResponseEntity.ok(arriendo);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Arriendo> guardar(@RequestBody Arriendo arriendo) {
        Arriendo nuevoArriendo = arriendoService.guardarArriendo(arriendo);
        return ResponseEntity.status(201).body(nuevoArriendo);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        try {
            arriendoService.eliminarArriendo(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Arriendo> actualizar(@PathVariable Long id, @RequestBody Arriendo arriendo) {
        try {
            Arriendo arriendooActualizado = arriendoService.updateArriendo(id, arriendo);
            return ResponseEntity.ok(arriendooActualizado);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Arriendo> editar(@PathVariable Long id, @RequestBody Arriendo arriendo) {
        Arriendo arriendoActualizada = arriendoService.actualizarArriendoParcial(id, arriendo);
        if (arriendoActualizada == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(arriendoActualizada);
    }

}
