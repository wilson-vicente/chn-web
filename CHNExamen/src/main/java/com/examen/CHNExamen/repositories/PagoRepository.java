package com.examen.CHNExamen.repositories;

import com.examen.CHNExamen.model.PagoModel;
import com.examen.CHNExamen.projections.PagoBySoliAprobadaProjection;
import com.examen.CHNExamen.projections.PagoPrestamoProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PagoRepository extends JpaRepository<PagoModel, Long>{

    @Query(
            value = "SELECT \n" +
                    "    a.id_prestamos_aprobados AS idPrestamosAprobados, \n" +
                    "    a.id_cliente AS idCliente, \n" +
                    "    b.nombre, \n" +
                    "    a.estado, \n" +
                    "    a.saldo_pendiente AS montoSolicitado, \n" +
                    "    a.fecha_aprobacion AS fechaAprobacion, \n" +
                    "    SUM(c.monto_pago) as montoPago, \n" +
                    "    (a.saldo_pendiente - SUM(c.monto_pago)) as saldo \n" +
                    "FROM " +
                    "   chn.prestamos_aprobados a \n" +
                    "INNER JOIN " +
                    "   chn.cliente b ON b.id_cliente = a.id_cliente \n" +
                    "LEFT JOIN " +
                    "   chn.pago c ON c.id_prestamos_aprobados = a.id_prestamos_aprobados \n" +
                    "GROUP BY " +
                    "   a.id_prestamos_aprobados \n" +
                    "ORDER BY " +
                    "   b.nombre",
            nativeQuery = true
    )
    List<PagoPrestamoProjection> getPagosAllCliente();

    @Query(
            value = "SELECT \n" +
                    "   id_pago AS idPago, " +
                    "   id_prestamos_aprobados AS idPrestamosAprobados, " +
                    "   fecha_pago AS fechaPago, "+
                    "   monto_pago AS montoPago \n" +
                    "FROM \n" +
                    "   chn.pago \n" +
                    "WHERE id_prestamos_aprobados = :idSolicitudAprobada",
            nativeQuery = true
    )
    List<PagoBySoliAprobadaProjection> getPagosAllByPrestamoAprobado(@Param("idSolicitudAprobada") int idSolicitudAprobada);
}
