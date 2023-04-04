package br.com.cadastro.cliente.api.controller;

import br.com.cadastro.cliente.api.dto.CriaClienteRequest;
import br.com.cadastro.cliente.api.model.Cliente;
import br.com.cadastro.cliente.api.service.ClienteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    private final ClienteService clienteService;

    @Autowired
    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @PostMapping
    public ResponseEntity<Cliente> cadastraCliente(@Valid @RequestBody CriaClienteRequest data, UriComponentsBuilder uriBuilder) {

        Cliente clienteCadastrado = this.clienteService.criaCliente(data);
        URI uriNovoCliente = uriBuilder.path("clientes/{id}").buildAndExpand(clienteCadastrado.getId()).toUri();

        return ResponseEntity.created(uriNovoCliente).body(clienteCadastrado);
    }

}
