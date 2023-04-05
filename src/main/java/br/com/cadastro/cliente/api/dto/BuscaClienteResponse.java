package br.com.cadastro.cliente.api.dto;

import br.com.cadastro.cliente.api.model.Cliente;
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
