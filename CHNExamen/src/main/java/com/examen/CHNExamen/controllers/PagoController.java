package com.examen.CHNExamen.controllers;

import com.examen.CHNExamen.model.PagoModel;
import com.examen.CHNExamen.services.PagoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/v1/pago")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class PagoController {

    @Autowired
    PagoService pagoService;

    @GetMapping(path = "/getPagosAll")
    public List<PagoModel> getPagosAll() {
        return pagoService.getPagosAll();
    }

    @GetMapping(path = "/getPago/{pagoId}")
    public Optional<PagoModel> getPago(@PathVariable("pagoId") Long pagoId) {
        return pagoService.getPago(pagoId);
    }

    @PostMapping(path = "/saveOrUpdatePago")
    public Map<String, String> saveOrUpdatePago(@RequestBody PagoModel pago) {

        Map<String, String> respuestaPago = new HashMap<>();

        try {
            respuestaPago.put("estado", "exito");
            pagoService.saveOrUpdatePago(pago);
            return respuestaPago;

        } catch (Exception e) {
            respuestaPago.put("estado", "error");
            return respuestaPago;
        }

    }

    @DeleteMapping(path = "/deletePago/{pagoId}")
    public String deletePago(@PathVariable("pagoId") Long pagoId) {
        pagoService.deletePago(pagoId);
        return "Exito";
    }

    @GetMapping(path = "/getPagoPrestamosAllTable")
    public Map<String, Object> getPagoPrestamosAllTable() {

        Map<String, Object> pagoPrestamoListAll = new HashMap<>();

        try {
            pagoPrestamoListAll.put("estado", "exito");
            pagoPrestamoListAll.put("data", pagoService.getPagosClienteAllTable());
            return pagoPrestamoListAll;
        } catch (Exception e) {
            pagoPrestamoListAll.put("estado", "error");
            return pagoPrestamoListAll;
        }
    }

    @GetMapping(path = "/getPagoBySolicitudAprobada/{idSolicitudAprobada}")
    public Map<String, Object> getPagoBySolicitudAprobada(@PathVariable("idSolicitudAprobada") int idSolicitudAprobada) {

        Map<String, Object> listPagoBySoliAprobada = new HashMap<>();

        try {
            listPagoBySoliAprobada.put("estado", "exito");
            listPagoBySoliAprobada.put("data", pagoService.getPagoBySoliAprobada(idSolicitudAprobada));
            return listPagoBySoliAprobada;
        } catch (Exception e) {
            listPagoBySoliAprobada.put("estado", "error");
            return listPagoBySoliAprobada;
        }
    }

}
