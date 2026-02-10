package com.campuscamara.gestionasignaturas.controller;

import com.campuscamara.gestionasignaturas.model.Ce;
import com.campuscamara.gestionasignaturas.service.CeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ces") // URL Base: /api/ces
public class CeController {

    @Autowired
    private CeService ceService;

    // 1. VER TODOS
    @GetMapping
    public List<Ce> getAll() {
        return ceService.listarTodos();
    }

    // 2. VER CRITERIOS DE UN RA ESPECÍFICO 
    @GetMapping("/ra/{idRa}")
    public List<Ce> getByRa(@PathVariable Integer idRa) {
        return ceService.buscarPorRa(idRa);
    }

    // 3. CREAR
    @PostMapping
    public Ce create(@RequestBody Ce ce) {
        return ceService.guardar(ce);
    }

    // 4. BORRAR
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        if (ceService.buscarPorId(id).isPresent()) {
            ceService.eliminar(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}