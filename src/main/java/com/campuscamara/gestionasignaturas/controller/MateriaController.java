package com.campuscamara.gestionasignaturas.controller;

import com.campuscamara.gestionasignaturas.model.Materia;
import com.campuscamara.gestionasignaturas.service.MateriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/materias") // <--- Esta será la URL base
public class MateriaController {

    @Autowired
    private MateriaService materiaService;

    // 1. OBTENER TODAS (GET)
    @GetMapping
    public List<Materia> getAll() {
        return materiaService.listarTodas();
    }

    // 2. OBTENER UNA POR ID (GET)
    @GetMapping("/{id}")
    public ResponseEntity<Materia> getById(@PathVariable Integer id) {
        return materiaService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // 3. CREAR NUEVA (POST)
    @PostMapping
    public Materia create(@RequestBody Materia materia) {
        return materiaService.guardar(materia);
    }

    // 4. ACTUALIZAR (PUT)
    @PutMapping("/{id}")
    public ResponseEntity<Materia> update(@PathVariable Integer id, @RequestBody Materia materiaDetails) {
        return materiaService.buscarPorId(id)
                .map(materia -> {
                    materia.setNombre(materiaDetails.getNombre());
                    materia.setCodigo(materiaDetails.getCodigo());
                    return ResponseEntity.ok(materiaService.guardar(materia));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    // 5. BORRAR (DELETE)
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        if (materiaService.buscarPorId(id).isPresent()) {
            materiaService.eliminar(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}