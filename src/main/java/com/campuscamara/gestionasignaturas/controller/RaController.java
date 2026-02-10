package com.campuscamara.gestionasignaturas.controller;

import com.campuscamara.gestionasignaturas.model.Ra;
import com.campuscamara.gestionasignaturas.service.RaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ras") //URL Base para los RAs
public class RaController {

    @Autowired
    private RaService raService;

    // 1. OBTENER TODOS
    @GetMapping
    public List<Ra> getAll() {
        return raService.listarTodos();
    }

    // 2. OBTENER POR ID
    @GetMapping("/{id}")
    public ResponseEntity<Ra> getById(@PathVariable Integer id) {
        return raService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // 3. OBTENER RAs DE UNA ASIGNATURA 
    @GetMapping("/materia/{idMateria}")
    public List<Ra> getByMateria(@PathVariable Integer idMateria) {
        return raService.buscarPorMateria(idMateria);
    }

    // 4. CREAR (Hay que pasarle la materia en el JSON)
    @PostMapping
    public Ra create(@RequestBody Ra ra) {
        return raService.guardar(ra);
    }

    // 5. ACTUALIZAR
    @PutMapping("/{id}")
    public ResponseEntity<Ra> update(@PathVariable Integer id, @RequestBody Ra raDetails) {
        return raService.buscarPorId(id)
                .map(ra -> {
                    ra.setDescripcion(raDetails.getDescripcion());
                    ra.setMateria(raDetails.getMateria()); // Importante si cambiamos el RA de asignatura
                    return ResponseEntity.ok(raService.guardar(ra));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    // 6. BORRAR
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        if (raService.buscarPorId(id).isPresent()) {
            raService.eliminar(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}