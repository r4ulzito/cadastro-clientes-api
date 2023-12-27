package br.com.cadastro.cliente.api.domain.service;

import br.com.cadastro.cliente.api.domain.dto.BuscaClienteResponse;
import br.com.cadastro.cliente.api.domain.dto.CriaClienteRequest;
import br.com.cadastro.cliente.api.domain.mapper.ClienteMapper;
import br.com.cadastro.cliente.api.domain.model.Cliente;
import br.com.cadastro.cliente.api.domain.exception.NullQueryException;
import br.com.cadastro.cliente.api.infrastructure.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteServiceImplements implements ClienteService {

    private final ClienteRepository clienteRepository;

    @Autowired
    public ClienteServiceImplements(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @Override
    public Cliente criarCliente(CriaClienteRequest clienteDTO) {
        return this.clienteRepository.save(ClienteMapper.buildCliente(clienteDTO));
    }

    @Override
    public BuscaClienteResponse buscarClientePorId(Long clienteId) {
        Cliente clienteEncontrado = this.clienteRepository.findById(clienteId)
                .orElseThrow(() -> new NullQueryException("Cliente não encontrado!"));

        return new BuscaClienteResponse(clienteEncontrado);

    }

    @Override
    public List<BuscaClienteResponse> buscarClientes() {
        return this.clienteRepository.findAll().stream()
                .map(BuscaClienteResponse::new).toList();
    }

    @Override
    public void atualizarCliente(Long clienteId, CriaClienteRequest dadosClienteAtualizado) {
        Cliente clienteEncontrado = this.clienteRepository.findById(clienteId)
                .orElseThrow(() -> new NullQueryException("Cliente não encontrado!"));

        clienteEncontrado.atualizaDados(dadosClienteAtualizado);
        this.clienteRepository.save(clienteEncontrado);
    }

    @Override
    public void excluirCliente(Long clienteId) {

        Cliente clienteEncontrado = this.clienteRepository.getReferenceById(clienteId);

        System.out.println(clienteEncontrado);

        this.clienteRepository.delete(clienteEncontrado);

    }
}
