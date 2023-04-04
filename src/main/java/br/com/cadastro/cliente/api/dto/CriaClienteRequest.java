package br.com.cadastro.cliente.api.dto;

import jakarta.validation.constraints.*;

public record CriaClienteRequest(

        @NotBlank
        @Size(max = 32)
        String nome,

        @NotNull
        Integer idade,

        @NotBlank
        @Size(max = 64)
        @Email
        String email
) {
}
