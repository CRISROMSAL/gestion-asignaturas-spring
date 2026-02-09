package com.campuscamara.gestionasignaturas.service;

import com.campuscamara.gestionasignaturas.model.Ra;
import com.campuscamara.gestionasignaturas.repository.RaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class RaService {

    @Autowired
    private RaRepository raRepository;

    public List<Ra> listarTodos() {
        return raRepository.findAll();
    }

    // Nuevo: Buscar RAs de una asignatura concreta
    public List<Ra> buscarPorMateria(Integer idMateria) {
        return raRepository.findByMateria_Id(idMateria);
    }

    public Optional<Ra> buscarPorId(Integer id) {
        return raRepository.findById(id);
    }

    public Ra guardar(Ra ra) {
        return raRepository.save(ra);
    }

    public void eliminar(Integer id) {
        raRepository.deleteById(id);
    }
}