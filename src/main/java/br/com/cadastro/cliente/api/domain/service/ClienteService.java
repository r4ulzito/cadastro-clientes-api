package br.com.cadastro.cliente.api.domain.service;

import br.com.cadastro.cliente.api.domain.dto.BuscaClienteResponse;
import br.com.cadastro.cliente.api.domain.dto.CriaClienteRequest;
import br.com.cadastro.cliente.api.domain.model.Cliente;

import java.util.List;

public interface ClienteService {

    Cliente criarCliente(CriaClienteRequest clienteDTO);

    BuscaClienteResponse buscarClientePorId(Long clienteId);

    List<BuscaClienteResponse> buscarClientes();

    void atualizarCliente(Long clienteId, CriaClienteRequest dadosClienteAtualizado);

    void excluirCliente(Long clienteId);

}
