package br.com.cadastro.cliente.api.domain.handler.response;

import lombok.Data;

import java.time.Instant;

@Data
public class ExceptionResponsePadrao {

    private Instant timestamp;
    private Integer status;
    private String message;

    public ExceptionResponsePadrao(Instant timestamp, Integer status, String message) {
        this.timestamp = timestamp;
        this.status = status;
        this.message = message;
    }
}
