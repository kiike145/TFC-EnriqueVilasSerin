package com.example.demo.model;

import javax.persistence.*;

@Entity
@Table(name = "pedidos")
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer estado;
    private Float preciototal;
    private Boolean activo;
    @ManyToOne
    @JoinColumn(name = "idusuario")
    private Usuario usuario;

    public Pedido() {}

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getEstado() {
        return this.estado;
    }

    public void setEstado(Integer estado) {
        this.estado = estado;
    }

    public Float getPreciototal() {
        return this.preciototal;
    }

    public void setPreciototal(Float precioTotal) {
        this.preciototal = precioTotal;
    }

    public Boolean getActivo() {
        return this.activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }

    public Usuario getUsuario() {
        return this.usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public String toString() {
        return "Pedido{" +
                "id=" + id +
                ", estado=" + estado +
                ", precioTotal=" + preciototal +
                ", activo=" + activo +
                ", usuario=" + usuario +
                '}';
    }
}
