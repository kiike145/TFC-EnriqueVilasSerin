package com.example.demo.model;

import javax.persistence.*;



@Entity
@Table(name = "rol")
public class Rol {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nombrerol;

    public Rol() {}

    public Integer getId() {
        return this.id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getNombreRol() {
        return this.nombrerol;
    }
    public void setNombreRol(String nombreRol) {
        this.nombrerol = nombreRol;
    }

    @Override
    public String toString() {
        return "Rol{" +
                "id=" + id +
                ", nombreRol='" + nombrerol + '\'' +
                '}';
    }
}
