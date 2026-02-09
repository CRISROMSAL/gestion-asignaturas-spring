package com.campuscamara.gestionasignaturas.service;

import com.campuscamara.gestionasignaturas.model.Ce;
import com.campuscamara.gestionasignaturas.repository.CeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class CeService {

    @Autowired
    private CeRepository ceRepository;

    public List<Ce> listarTodos() {
        return ceRepository.findAll();
    }

    public List<Ce> buscarPorRa(Integer idRa) {
        return ceRepository.findByRa_Id(idRa);
    }

    public Optional<Ce> buscarPorId(Integer id) {
        return ceRepository.findById(id);
    }

    public Ce guardar(Ce ce) {
        return ceRepository.save(ce);
    }

    public void eliminar(Integer id) {
        ceRepository.deleteById(id);
    }
}