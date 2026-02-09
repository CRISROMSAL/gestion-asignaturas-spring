package com.campuscamara.gestionasignaturas.model;

import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "resultados_aprendizaje")
public class Ra {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String descripcion;

    // --- RELACIÓN CON MATERIA ---
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "asignatura_id") // <--- ¡CORREGIDO! Según tu captura es así.
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) 
    private Materia materia;

    // --- CONSTRUCTORES ---
    public Ra() {
    }

    public Ra(Integer id, String descripcion, Materia materia) {
        this.id = id;
        this.descripcion = descripcion;
        this.materia = materia;
    }

    // --- GETTERS Y SETTERS ---
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Materia getMateria() {
        return materia;
    }

    public void setMateria(Materia materia) {
        this.materia = materia;
    }
}