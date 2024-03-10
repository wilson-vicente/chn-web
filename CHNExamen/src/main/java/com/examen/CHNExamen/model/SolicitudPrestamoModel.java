package com.examen.CHNExamen.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.math.BigDecimal;

@Entity
@Table(name = "solicitud_prestamo")
public class SolicitudPrestamoModel {

    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_solicitud_prestamo")
    private long idSolicitudPrestamo;

    @Column(name = "id_cliente")
    private int idCliente;

    @Column(name = "id_plazo_deseado")
    private int idPlazoDeseado;

    @Column(name = "monto_solicitado")
    private BigDecimal montoSolicitado;

    @Column(name = "estado")
    private int estado;

    public long getIdSolicitudPrestamo() {
        return idSolicitudPrestamo;
    }

    public void setIdSolicitudPrestamo(long idSolicitudPrestamo) {
        this.idSolicitudPrestamo = idSolicitudPrestamo;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public int getIdPlazoDeseado() {
        return idPlazoDeseado;
    }

    public void setIdPlazoDeseado(int idPlazoDeseado) {
        this.idPlazoDeseado = idPlazoDeseado;
    }

    public BigDecimal getMontoSolicitado() {
        return montoSolicitado;
    }

    public void setMontoSolicitado(BigDecimal montoSolicitado) {
        this.montoSolicitado = montoSolicitado;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }
}
