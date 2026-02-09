package com.campuscamara.gestionasignaturas.repository;

import com.campuscamara.gestionasignaturas.model.Ra;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface RaRepository extends JpaRepository<Ra, Integer> {
    
    // Busca todos los RAs de una asignatura concreta
    List<Ra> findByMateria_Id(Integer idMateria);
}