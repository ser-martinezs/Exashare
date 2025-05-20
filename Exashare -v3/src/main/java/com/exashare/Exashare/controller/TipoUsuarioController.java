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

import com.exashare.Exashare.model.TipoUsuario;
import com.exashare.Exashare.service.TipoUsuarioService;

import java.util.List;

@RestController
@RequestMapping("api/v1/tiposusuario")
public class TipoUsuarioController {

        @Autowired
    private TipoUsuarioService tipoUsuarioService;

    @GetMapping
    public ResponseEntity<List<TipoUsuario>> listar() {
        List<TipoUsuario> tipos = tipoUsuarioService.obtenerTiposUsuario();
        if (tipos.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(tipos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TipoUsuario> buscar(@PathVariable Long id) {
        try {
            TipoUsuario tipo = tipoUsuarioService.obtenerPorId(id);
            return ResponseEntity.ok(tipo);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<TipoUsuario> guardar(@RequestBody TipoUsuario tipo) {
        TipoUsuario nuevoTipo = tipoUsuarioService.guardarTipoUsuario(tipo);
        return ResponseEntity.status(201).body(nuevoTipo);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        try {
            tipoUsuarioService.eliminarTipoUsuario(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<TipoUsuario> actualizar(@PathVariable Long id, @RequestBody TipoUsuario tipo) {
        try {
            TipoUsuario tipoActualizado = tipoUsuarioService.actualizarTipoUsuario(id, tipo);
            return ResponseEntity.ok(tipoActualizado);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PatchMapping("/{id}")
    public ResponseEntity<TipoUsuario> editar(@PathVariable Long id, @RequestBody TipoUsuario tipo) {
        TipoUsuario tipoActualizado = tipoUsuarioService.actualizarTipoUsuarioParcial(id, tipo);
        if (tipoActualizado == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(tipoActualizado);
    }

}
