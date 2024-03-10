package com.examen.CHNExamen.repositories;

import com.examen.CHNExamen.model.SolicitudPrestamoModel;
import com.examen.CHNExamen.projections.SolicitudesPrestamoProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SolicitudPrestamoRepository extends JpaRepository<SolicitudPrestamoModel, Long> {

    @Query(
            value = "SELECT \n" +
                    "   a.id_solicitud_prestamo as idSolicitudPrestamo, \n" +
                    "   a.id_cliente as idCliente,  \n" +
                    "   b.nombre as nombre, \n" +
                    "   a.monto_solicitado as montoSolicitado,  \n" +
                    "   a.id_plazo_deseado as idPlazodeseado,   \n" +
                    "   a.estado as estado  \n" +
                    "FROM  " +
                    "   chn.solicitud_prestamo a \n" +
                    "INNER JOIN " +
                    "   chn.cliente b on b.id_cliente = a.id_cliente \n" +
                    "ORDER BY b.nombre",
            nativeQuery = true
    )
    List<SolicitudesPrestamoProjection> getSolicitudesAllTable();

}
