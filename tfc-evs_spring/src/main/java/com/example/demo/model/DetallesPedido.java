package com.example.demo.model;

import javax.persistence.*;

@Entity
@Table(name = "detallesPedido")
public class DetallesPedido {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "idpedido")
    private Pedido pedido;

    @ManyToOne
    @JoinColumn(name = "idusuario")
    private Usuario usuario;

    private Integer cantidadProducto;

    public DetallesPedido() {}

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Pedido getPedido() {
        return this.pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public Usuario getUsuario() {
        return this.usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Integer getCantidadProducto() {
        return this.cantidadProducto;
    }

    public void setCantidadProducto(Integer cantidadProducto) {
        this.cantidadProducto = cantidadProducto;
    }

    @Override
    public String toString() {
        return "DetallesPedido{" +
                "id=" + id +
                ", pedido=" + pedido +
                ", usuario=" + usuario +
                ", cantidadProducto=" + cantidadProducto +
                '}';
    }
}
