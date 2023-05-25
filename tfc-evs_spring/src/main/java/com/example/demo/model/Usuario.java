package com.example.demo.model;

import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;

@Entity
@Table(name = "usuarios")
public class Usuario {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nombre;
    private String apellidos;
    private String nombreusuario;
    private String email;
    private String contrasena;
    private String direccion;
    private String fechanacimiento;
    private Boolean activo;
    @ManyToMany
    @JoinTable(
            name = "usuariosxrol",
            joinColumns = @JoinColumn(name = "idusuario"),
            inverseJoinColumns = @JoinColumn(name="idrol")
    )
    private List<Rol> roles;

    public Usuario() {}

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

    public String getApellidos() {
        return this.apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getNombreusuario() {
        return this.nombreusuario;
    }

    public void setNombreusuario(String nombreUsuario) {
        this.nombreusuario = nombreUsuario;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContrasena() {
        return this.contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getDireccion() {
        return this.direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getFechanacimiento() {
        return this.fechanacimiento;
    }

    public void setFechanacimiento(String fechaNacimiento) {
        this.fechanacimiento = fechaNacimiento;
    }

    public Boolean getActivo() {
        return this.activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }

    public List<Rol> getRoles() {
        return this.roles;
    }

    public void setRoles(List<Rol> roles) {
        this.roles = roles;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", nombreUsuario='" + nombreusuario + '\'' +
                ", email='" + email + '\'' +
                ", contrasena='" + contrasena + '\'' +
                ", direccion='" + direccion + '\'' +
                ", fechaNacimiento='" + fechanacimiento + '\'' +
                ", activo=" + activo +
                ", roles=" + roles +
                '}';
    }

    public void addRol(Rol r){
        if(this.roles == null){
            this.roles = new LinkedList<>();
        }
        this.roles.add(r);
    }
}
