package com.bedu.inventario;

import jakarta.persistence.*;

@Entity
public class Marca {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    protected Marca() {}

    public Marca(String nombre) {
        this.nombre = nombre;
    }

    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }
}

