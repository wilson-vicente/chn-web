package com.examen.CHNExamen.services;

import com.examen.CHNExamen.model.ClienteModel;
import com.examen.CHNExamen.model.PagoModel;
import com.examen.CHNExamen.projections.PagoBySoliAprobadaProjection;
import com.examen.CHNExamen.projections.PagoPrestamoProjection;
import com.examen.CHNExamen.repositories.PagoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PagoService {

    @Autowired
    PagoRepository pagoRepository;

    public List<PagoModel> getPagosAll() {
        return pagoRepository.findAll();
    };

    public Optional<PagoModel> getPago(long id) {
        return pagoRepository.findById(id);
    }

    public void saveOrUpdatePago(PagoModel pago) {
        pagoRepository.save(pago);
    }

    public void deletePago(long id) {
        pagoRepository.deleteById(id);
    }

    public List<PagoPrestamoProjection> getPagosClienteAllTable() {
        return pagoRepository.getPagosAllCliente();
    }

    public List<PagoBySoliAprobadaProjection> getPagoBySoliAprobada(int idSolicitudAprobada) {
        System.out.println("idSolicitudAprobada " + idSolicitudAprobada);
        return pagoRepository.getPagosAllByPrestamoAprobado(idSolicitudAprobada);
    }

}
