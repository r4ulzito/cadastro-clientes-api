package br.com.cadastro.cliente.api.domain.mapper;

import br.com.cadastro.cliente.api.domain.dto.CriaClienteRequest;
import br.com.cadastro.cliente.api.domain.model.Cliente;

public interface ClienteMapper {

    static Cliente buildCliente(CriaClienteRequest clienteDTO) {
        return Cliente.builder()
                .nome(clienteDTO.nome())
                .idade(clienteDTO.idade())
                .email(clienteDTO.email())
                .build();
    }

}
