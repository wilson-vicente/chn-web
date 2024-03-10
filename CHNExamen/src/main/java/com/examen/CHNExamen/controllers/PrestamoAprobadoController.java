package com.examen.CHNExamen.controllers;

import com.examen.CHNExamen.model.ClienteModel;
import com.examen.CHNExamen.model.PrestamosAprobadosModel;
import com.examen.CHNExamen.services.PrestamoAprobadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/v1/prestamosAprobados")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class PrestamoAprobadoController {

    @Autowired
    PrestamoAprobadoService prestamoAprobadoService;

    @GetMapping(path = "/getPrestamosAprobadosAll")
    public List<PrestamosAprobadosModel> getPrestamosAprobadosAll() {
        return prestamoAprobadoService.getPrestamosAprobadosAll();
    }

    @GetMapping(path ="/getPrestamoAprobado/{prestamoAprobadoId}")
    public Optional<PrestamosAprobadosModel> getPrestamoAprobado(@PathVariable("prestamoAprobadoId") Long prestamoAprobadoId) {
        return prestamoAprobadoService.getPrestamoAprobado(prestamoAprobadoId);
    }

    @PostMapping(path = "/saveOrUpdatePrestamoAprobado")
    public String saveOrUpdateCliente(@RequestBody PrestamosAprobadosModel prestamoAprobadoId) {
        prestamoAprobadoService.saveOrUpdatePrestamoAprobado (prestamoAprobadoId);
        return "Exito";
    }

    @DeleteMapping(path = "/deletePrestamoAprobado/{clienteId}")
    public String deleteCliente(@PathVariable("clienteId") Long prestamoAprobadoId) {
        prestamoAprobadoService.deletePrestamoAprobado (prestamoAprobadoId);
        return "Exito";
    }



}
