package br.com.cadastro.cliente.api.handler.response;

import lombok.Builder;
import lombok.Data;

import java.time.Instant;

@Builder
@Data
public class DefaultCustomExceptionResponse {

    private Instant timestamp;
    private Integer status;
    private String message;

}
