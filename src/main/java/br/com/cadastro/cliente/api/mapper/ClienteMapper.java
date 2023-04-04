package br.com.cadastro.cliente.api.mapper;

import br.com.cadastro.cliente.api.dto.CriaClienteRequest;
import br.com.cadastro.cliente.api.model.Cliente;

public interface ClienteMapper {

    static Cliente buildCliente(CriaClienteRequest clienteDTO) {
        return Cliente.builder()
                .nome(clienteDTO.nome())
                .idade(clienteDTO.idade())
                .email(clienteDTO.email())
                .build();
    }

}
