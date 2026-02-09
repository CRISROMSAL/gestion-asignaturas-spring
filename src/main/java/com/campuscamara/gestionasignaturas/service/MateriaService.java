package com.campuscamara.gestionasignaturas.service;

import com.campuscamara.gestionasignaturas.model.Materia;
import com.campuscamara.gestionasignaturas.repository.MateriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class MateriaService {

    @Autowired
    private MateriaRepository materiaRepository;

    // 1. Listar todas las asignaturas
    public List<Materia> listarTodas() {
        return materiaRepository.findAll();
    }

    // 2. Buscar una por ID
    public Optional<Materia> buscarPorId(Integer id) {
        return materiaRepository.findById(id);
    }

    // 3. Guardar (sirve para Crear y para Editar)
    public Materia guardar(Materia materia) {
        return materiaRepository.save(materia);
    }

    // 4. Eliminar
    public void eliminar(Integer id) {
        materiaRepository.deleteById(id);
    }
}