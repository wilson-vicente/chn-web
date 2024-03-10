package com.examen.CHNExamen.projections;

import java.math.BigDecimal;
import java.util.Date;

public interface PagoPrestamoProjection {
    int getIdPrestamosAprobados();

    int getIdCliente();

    String getNombre();

    int getEstado();

    BigDecimal getMontoSolicitado();

    Date getFechaAprobacion();
    BigDecimal getMontoPago();
    BigDecimal getSaldo();

}
