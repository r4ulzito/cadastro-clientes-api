package br.com.cadastro.cliente.api.domain.dto;

import br.com.cadastro.cliente.api.domain.model.Cliente;
import lombok.Builder;

@Builder
public record BuscaClienteResponse(
        Long id,
        String nome,
        Integer idade,
        String email
) {
    public BuscaClienteResponse(Cliente cliente) {

        this(cliente.getId(), cliente.getNome(), cliente.getIdade(), cliente.getEmail());

    }
}
