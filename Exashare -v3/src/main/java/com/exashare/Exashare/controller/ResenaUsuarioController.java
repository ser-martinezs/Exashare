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

import com.exashare.Exashare.model.ResenaUsuario;
import com.exashare.Exashare.service.ResenaUsuarioService;

import java.util.List;

@RestController
@RequestMapping("api/v1/resenasusuarios")
public class ResenaUsuarioController {

    @Autowired
    private ResenaUsuarioService resenaUsuarioService;

    @GetMapping
    public ResponseEntity<List<ResenaUsuario>> listar() {
        List<ResenaUsuario> resenas = resenaUsuarioService.obtenerResenas();
        if (resenas.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(resenas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResenaUsuario> buscar(@PathVariable Long id) {
        try {
            ResenaUsuario resena = resenaUsuarioService.obtenerPorId(id);
            return ResponseEntity.ok(resena);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<ResenaUsuario> guardar(@RequestBody ResenaUsuario resena) {
        ResenaUsuario nuevaResena = resenaUsuarioService.guardarResena(resena);
        return ResponseEntity.status(201).body(nuevaResena);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        try {
            resenaUsuarioService.eliminarResena(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<ResenaUsuario> actualizar(@PathVariable Long id, @RequestBody ResenaUsuario resena) {
        try {
            ResenaUsuario resenaActualizada = resenaUsuarioService.actualizarResena(id, resena);
            return ResponseEntity.ok(resenaActualizada);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PatchMapping("/{id}")
    public ResponseEntity<ResenaUsuario> editar(@PathVariable Long id, @RequestBody ResenaUsuario resena) {
        ResenaUsuario resenaActualizada = resenaUsuarioService.actualizarResenaParcial(id, resena);
        if (resenaActualizada == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(resenaActualizada);
    }

}
