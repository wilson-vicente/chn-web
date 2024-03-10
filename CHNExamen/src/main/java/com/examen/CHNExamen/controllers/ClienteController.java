package com.examen.CHNExamen.controllers;

import com.examen.CHNExamen.model.ClienteModel;
import com.examen.CHNExamen.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/v1/cliente")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ClienteController {

    @Autowired
    ClienteService clienteService;

    @GetMapping(path = "/getClienteAll")
    public Map<String, Object> getClienteAll() {
        Map<String, Object> respuestaListCliente = new HashMap<>();

        try {
            respuestaListCliente.put("estado", "exito");
            respuestaListCliente.put("data", clienteService.getClientes());

            return respuestaListCliente;

        } catch (Exception e) {
            respuestaListCliente.put("estado", "error");
            return respuestaListCliente;
        }


    }

    @GetMapping(path = "/getCliente/{clienteId}")
    public Optional<ClienteModel> getCliente(@PathVariable("clienteId") Long clienteId) {
        return clienteService.getCliente(clienteId);
    }

    @PostMapping(path = "/saveOrUpdateCliente")
    public Map<String, String> saveOrUpdateCliente(@RequestBody ClienteModel cliente) {
        Map<String, String> respuestaCliente = new HashMap<>();

        try {
            respuestaCliente.put("estado", "exito");
            clienteService.saveOrUpdateCliente(cliente);
            return respuestaCliente;
        } catch (Exception e) {
            respuestaCliente.put("estado", "error");
            return respuestaCliente;
        }
    }

    @DeleteMapping(path = "/deleteCliente/{clienteId}")
    public  Map<String, String> deleteCliente(@PathVariable("clienteId") Long clienteId) {
        Map<String, String> eliminarCliente = new HashMap<>();

        try {

            eliminarCliente.put("estado", "exito");
            clienteService.deleteCliente(clienteId);
            return eliminarCliente;

        } catch (Exception e) {

            eliminarCliente.put("estado", "error");
            return eliminarCliente;

        }

    }

}
