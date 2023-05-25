package com.example.demo.model;

import javax.persistence.*;

@Entity
@Table(name = "detallespedido")
public class DetallesPedido {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "idpedido")
    private Pedido pedido;

    @ManyToOne
    @JoinColumn(name = "idproducto")
    private Producto producto;

    private Integer cantidadproducto;

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

    public Producto getProducto() {
        return this.producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Integer getCantidadproducto() {
        return this.cantidadproducto;
    }

    public void setCantidadproducto(Integer cantidadproducto) {
        this.cantidadproducto = cantidadproducto;
    }

    @Override
    public String toString() {
        return "DetallesPedido{" +
                "id=" + id +
                ", pedido=" + pedido +
                ", producto=" + producto +
                ", cantidadProducto=" + cantidadproducto +
                '}';
    }
}
