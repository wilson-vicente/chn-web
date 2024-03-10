package com.examen.CHNExamen.services;

import com.examen.CHNExamen.model.ClienteModel;
import com.examen.CHNExamen.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    ClienteRepository clienteRepository;

    public List<ClienteModel> getClientes() {
        return clienteRepository.findAll();
    };

    public Optional<ClienteModel> getCliente(long id) {
        return clienteRepository.findById(id);
    }

    public void saveOrUpdateCliente(ClienteModel cliente) {
        clienteRepository.save(cliente);
    }

    public void deleteCliente(long id) {
        clienteRepository.deleteById(id);
    }

}
