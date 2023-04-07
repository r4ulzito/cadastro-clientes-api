package br.com.cadastro.cliente.api.controller;

import br.com.cadastro.cliente.api.dto.BuscaClienteResponse;
import br.com.cadastro.cliente.api.dto.CriaClienteRequest;
import br.com.cadastro.cliente.api.model.Cliente;
import br.com.cadastro.cliente.api.service.ClienteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

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

        Cliente clienteCadastrado = this.clienteService.criarCliente(data);
        URI uriNovoCliente = uriBuilder.path("clientes/{id}").buildAndExpand(clienteCadastrado.getId()).toUri();

        return ResponseEntity.created(uriNovoCliente).body(clienteCadastrado);
    }

    @GetMapping("/{clienteId}")
    public ResponseEntity<BuscaClienteResponse> buscaClientePorId(@PathVariable Long clienteId) {
        return ResponseEntity.ok().body(this.clienteService.buscarClientePorId(clienteId));
    }

    @GetMapping
    public ResponseEntity<List<BuscaClienteResponse>> buscaClientes() {
        return ResponseEntity.status(HttpStatus.OK).body(this.clienteService.buscarClientes());
    }

    @PutMapping("/{clienteId}")
    public ResponseEntity atualizaCliente(
            @PathVariable Long clienteId,
            @Valid @RequestBody CriaClienteRequest clienteAtualizado
    ) {

        this.clienteService.atualizarCliente(clienteId, clienteAtualizado);

        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{clienteId}")
    public ResponseEntity excluirCliente(@PathVariable Long clienteId) {

        this.clienteService.excluirCliente(clienteId);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();

    }

}
