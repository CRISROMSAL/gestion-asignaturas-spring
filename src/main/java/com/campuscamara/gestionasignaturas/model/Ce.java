package com.campuscamara.gestionasignaturas.model;

import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "criterios_evaluacion") 
public class Ce {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String descripcion;

    // --- RELACIÓN CON RA (Muchos Criterios -> Un RA) ---
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ra_id") 
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) 
    private Ra ra;

    // --- CONSTRUCTORES ---
    public Ce() {
    }

    public Ce(Integer id, String descripcion, Ra ra) {
        this.id = id;
        this.descripcion = descripcion;
        this.ra = ra;
    }

    // --- GETTERS Y SETTERS ---
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }

    public Ra getRa() { return ra; }
    public void setRa(Ra ra) { this.ra = ra; }
}