package com.example.demo.model;

import javax.persistence.*;

@Entity
@Table(name = "categorias")
public class Categoria {

    // ATRIBUTOS
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nombre;

    // CONSTRUCTOR
    public Categoria() {}

    // GETTERS - SETTERS
    public Integer getId() {
        return this.id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getNombre() {
        return this.nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    // toString
    @Override
    public String toString() {
        return "Categoria{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}
