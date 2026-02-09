package com.campuscamara.gestionasignaturas.repository;

import com.campuscamara.gestionasignaturas.model.Ce;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface CeRepository extends JpaRepository<Ce, Integer> {
    
    // Buscar criterios por el ID del Resultado de Aprendizaje
    List<Ce> findByRa_Id(Integer idRa);
}