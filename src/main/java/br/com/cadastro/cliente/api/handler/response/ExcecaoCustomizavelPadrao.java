package br.com.cadastro.cliente.api.handler.response;

import lombok.Builder;
import lombok.Data;

import java.time.Instant;

@Data
public class ExcecaoCustomizavelPadrao {

    private Instant timestamp;
    private Integer status;
    private String message;

    public ExcecaoCustomizavelPadrao(Instant timestamp, Integer status, String message) {
        this.timestamp = timestamp;
        this.status = status;
        this.message = message;
    }
}
