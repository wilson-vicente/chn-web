package com.examen.CHNExamen.controllers;

import com.examen.CHNExamen.model.SolicitudPrestamoModel;
import com.examen.CHNExamen.projections.SolicitudesPrestamoProjection;
import com.examen.CHNExamen.services.SolicitudPrestamoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping(path = "api/v1/solicitudPrestamo")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class SolicitudPrestamoController {

    @Autowired
    SolicitudPrestamoService solicitudPrestamoService;

    @GetMapping(path = "/getSolicitudesPrestamoAll")
    public List<SolicitudPrestamoModel> getSolicitudesPrestamoAll() {

        return solicitudPrestamoService.getSolicitudesPrestamoAll();
    }

    @GetMapping(path = "/getSolicitudPrestamo/{SolicitudPrestamoId}")
    public Optional<SolicitudPrestamoModel> getSolicitudPrestamo(@PathVariable("SolicitudPrestamoId")  Long SolicitudPrestamoId) {
        return solicitudPrestamoService.getSolicitudPrestamo(SolicitudPrestamoId);
    }

    @PostMapping(path = "/saveOrUpdateSolicitudPrestamo")
    public Map<String, String> saveOrUpdateSolicitudPrestamo(@RequestBody SolicitudPrestamoModel SolicitudPrestamoId) {

        Map<String, String> respuestaSolicitudPrestamo = new HashMap<>();

        try {
            respuestaSolicitudPrestamo.put("estado", "exito");
            solicitudPrestamoService.saveOrUpdateSolicitudPrestamo(SolicitudPrestamoId);
            return respuestaSolicitudPrestamo;
        } catch (Exception e) {
            respuestaSolicitudPrestamo.put("estado", "error");
            return respuestaSolicitudPrestamo;
        }

    }

    @DeleteMapping(path = "/deleteSolicitudPrestamo/{SolicitudPrestamoId}")
    public Map<String, String> deleteSolicitudPrestamo(@PathVariable("SolicitudPrestamoId")  Long SolicitudPrestamoId) {
        Map<String, String> respuestaSolicitudPrestamo = new HashMap<>();

        try {
            respuestaSolicitudPrestamo.put("estado", "exito");
            solicitudPrestamoService.deleteSolicitudPrestamo(SolicitudPrestamoId);
            return respuestaSolicitudPrestamo;
        } catch (Exception e) {
            respuestaSolicitudPrestamo.put("estado", "error");
            return respuestaSolicitudPrestamo;
        }
    }

    @GetMapping(path = "/getSolicitudesPrestamoAllTable")
    public Map<String, Object> getSolicitudesPrestamoAllTable() {

        Map<String, Object> respuestaListClienteAll = new HashMap<>();

        try {
            respuestaListClienteAll.put("estado", "exito");
            respuestaListClienteAll.put("data", solicitudPrestamoService.getSolicitudesPrestamoAllTable());
            return respuestaListClienteAll;
        } catch (Exception e) {
            respuestaListClienteAll.put("estado", "error");
            return respuestaListClienteAll;
        }
    }
}
