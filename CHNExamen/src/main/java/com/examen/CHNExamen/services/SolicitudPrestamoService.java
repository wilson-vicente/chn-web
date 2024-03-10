package com.examen.CHNExamen.services;

import com.examen.CHNExamen.model.PrestamosAprobadosModel;
import com.examen.CHNExamen.model.SolicitudPrestamoModel;
import com.examen.CHNExamen.projections.SolicitudesPrestamoProjection;
import com.examen.CHNExamen.repositories.SolicitudPrestamoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SolicitudPrestamoService {

    @Autowired
    SolicitudPrestamoRepository solicitudPrestamoRepository;

    @Autowired
    PrestamoAprobadoService prestamoAprobadoService;

    public List<SolicitudPrestamoModel> getSolicitudesPrestamoAll() {
        return solicitudPrestamoRepository.findAll();
    }

    public Optional<SolicitudPrestamoModel> getSolicitudPrestamo(long id) {
        return solicitudPrestamoRepository.findById(id);
    }

    public void saveOrUpdateSolicitudPrestamo(SolicitudPrestamoModel solicitudPrestamo) {

        try {

            // Guardar Solicitud Prestamo
            solicitudPrestamoRepository.save(solicitudPrestamo);

            // Si la solicitud de prestamo fue aprobado, se genera la aprobación del prestamo
            if (solicitudPrestamo.getEstado() == 3) {

                // id_cliente, estado, saldo_pendiente, fecha_aprobacion

                PrestamosAprobadosModel prestamosAprobadosModel = new PrestamosAprobadosModel();
                prestamosAprobadosModel.setIdCliente(solicitudPrestamo.getIdCliente());
                prestamosAprobadosModel.setEstado(1);
                prestamosAprobadosModel.setSaldoPendiente(solicitudPrestamo.getMontoSolicitado());

                prestamoAprobadoService.saveOrUpdatePrestamoAprobado(prestamosAprobadosModel);
                System.out.println("Transacción guardada con exito");
            }

        } catch (Exception e) {
            System.out.println("Error al realizar la transaccion");
        }
    }

    public void deleteSolicitudPrestamo(long id) {
        solicitudPrestamoRepository.deleteById(id);
    }

    public List<SolicitudesPrestamoProjection> getSolicitudesPrestamoAllTable() {
        return solicitudPrestamoRepository.getSolicitudesAllTable();
    }

}
