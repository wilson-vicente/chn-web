package com.examen.CHNExamen.projections;

import java.math.BigDecimal;

public interface SolicitudesPrestamoProjection {

    int getIdSolicitudPrestamo();
    int getIdCliente();
    String getNombre();
    BigDecimal getMontoSolicitado();
    int getIdPlazodeseado();
    int getEstado();

}
