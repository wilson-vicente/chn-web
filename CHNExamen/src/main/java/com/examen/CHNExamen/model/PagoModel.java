package com.examen.CHNExamen.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "pago")
public class PagoModel {

    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_pago")
    private long idPago;

    @Column(name = "id_prestamos_aprobados")
    private int idPrestamosAprobados;

    @Column(name = "monto_pago")
    private BigDecimal montoPago;

    @Column(name = "fecha_pago")
    private Date fechaPago;

    public long getIdPago() {
        return idPago;
    }

    public void setIdPago(long idPago) {
        this.idPago = idPago;
    }

    public int getIdPrestamosAprobados() {
        return idPrestamosAprobados;
    }

    public void setIdPrestamosAprobados(int idPrestamosAprobados) {
        this.idPrestamosAprobados = idPrestamosAprobados;
    }

    public BigDecimal getMontoPago() {
        return montoPago;
    }

    public void setMontoPago(BigDecimal montoPago) {
        this.montoPago = montoPago;
    }

    public Date getFechaPago() {
        return fechaPago;
    }

    public void setFechaPago(Date fechaPago) {
        this.fechaPago = fechaPago;
    }
}
