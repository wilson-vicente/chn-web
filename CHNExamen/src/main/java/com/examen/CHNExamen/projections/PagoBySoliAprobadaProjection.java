package com.examen.CHNExamen.projections;

import java.math.BigDecimal;
import java.util.Date;

public interface PagoBySoliAprobadaProjection {

    int getIdPago();
    int getIdPrestamosAprobados();

    Date getFechaPago();

    BigDecimal getMontoPago();

}
