package com.examen.CHNExamen.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "prestamos_aprobados")
public class PrestamosAprobadosModel {

    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_prestamos_aprobados")
    private long idPrestamosAprobados;

    @Column(name = "id_cliente")
    private int idCliente;

    @Column(name = "estado")
    private int estado;

    @Column(name = "saldo_pendiente")
    private BigDecimal saldoPendiente;

    @Column(name = "fecha_aprobacion")
    private Date fechaAprobacion;

    public long getIdPrestamosAprobados() {
        return idPrestamosAprobados;
    }

    public void setIdPrestamosAprobados(long idPrestamosAprobados) {
        this.idPrestamosAprobados = idPrestamosAprobados;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public BigDecimal getSaldoPendiente() {
        return saldoPendiente;
    }

    public void setSaldoPendiente(BigDecimal saldoPendiente) {
        this.saldoPendiente = saldoPendiente;
    }
    public Date getFechaAprobacion() {
        return fechaAprobacion;
    }

    public void setFechaAprobacion(Date fechaAprobacion) {
        this.fechaAprobacion = fechaAprobacion;
    }
}
