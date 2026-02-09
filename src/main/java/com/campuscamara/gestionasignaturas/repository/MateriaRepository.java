package com.campuscamara.gestionasignaturas.repository;

import com.campuscamara.gestionasignaturas.model.Materia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MateriaRepository extends JpaRepository<Materia, Integer> {
    // No hace falta escribir nada más.
    // Al extender de JpaRepository, ya tienes:
    // .findAll() -> SELECT *
    // .findById() -> SELECT WHERE ID
    // .save() -> INSERT / UPDATE
    // .delete() -> DELETE
}
