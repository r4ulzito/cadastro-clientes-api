package br.com.cadastro.cliente.api.dto;

import jakarta.validation.constraints.*;

public record CriaClienteRequest(

        @NotBlank(message = "O campo nome é obrigatório!") @Size(max = 32, message = "Nome deve conter no máximo 32 caracteres!") String nome,

        @NotNull(message = "O campo idade é obrigatório!") @Min(value = 1, message = "Idade inválida!") @Max(value = 200, message = "Idade inválida!") Integer idade,

        @NotBlank(message = "O campo email é obrigatório!") @Email(message = "Email inválido!") String email) {
}
