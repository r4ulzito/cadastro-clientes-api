package br.com.cadastro.cliente.api.service;

import br.com.cadastro.cliente.api.dto.BuscaClienteResponse;
import br.com.cadastro.cliente.api.dto.CriaClienteRequest;
import br.com.cadastro.cliente.api.model.Cliente;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface ClienteService {

    Cliente criarCliente(CriaClienteRequest clienteDTO);

    BuscaClienteResponse buscarClientePorId(Long clienteId);

    List<BuscaClienteResponse> buscarClientes();

    void atualizarCliente(Long clienteId, CriaClienteRequest dadosClienteAtualizado);

    void excluirCliente(Long clienteId);

}
