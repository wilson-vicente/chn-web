package com.examen.CHNExamen.services;

import com.examen.CHNExamen.model.ClienteModel;
import com.examen.CHNExamen.model.PrestamosAprobadosModel;
import com.examen.CHNExamen.repositories.ClienteRepository;
import com.examen.CHNExamen.repositories.PrestamosAprobadosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PrestamoAprobadoService {

    @Autowired
    PrestamosAprobadosRepository prestamosAprobadosRepository;

    public List<PrestamosAprobadosModel> getPrestamosAprobadosAll() {
        return prestamosAprobadosRepository.findAll();
    };

    public Optional<PrestamosAprobadosModel> getPrestamoAprobado(long id) {
        return prestamosAprobadosRepository.findById(id);
    }

    public void saveOrUpdatePrestamoAprobado(PrestamosAprobadosModel prestamoAprobado) {
        prestamosAprobadosRepository.save(prestamoAprobado);
    }

    public void deletePrestamoAprobado(long id) {
        prestamosAprobadosRepository.deleteById(id);
    }

}
