package com.examen.CHNExamen.model;

import jakarta.persistence.*;


@Entity
@Table(name = "cliente")
public class ClienteModel {


    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_cliente")
    private long idCliente;

    @Column(name = "nombre", length = 15)
    private String nombre;

    @Column(name = "apellido", length = 15)
    private String apellido;

    @Column(name = "numero_identificacion", length = 15)
    private String numeroIdentificacion;

    @Column(name = "direccion", length = 150)
    private String direccion;

    @Column(name = "correo", length = 50)
    private String correo;

    @Column(name = "telefono", length = 8)
    private String telefono;


    public long getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(long idCliente) {
        this.idCliente = idCliente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNumeroIdentificacion() {
        return numeroIdentificacion;
    }

    public void setNumeroIdentificacion(String numeroIdentificacion) {
        this.numeroIdentificacion = numeroIdentificacion;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

}
