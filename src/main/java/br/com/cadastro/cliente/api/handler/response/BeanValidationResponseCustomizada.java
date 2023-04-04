package br.com.cadastro.cliente.api.handler.response;

import lombok.Data;
import lombok.Getter;

import java.time.Instant;

@Getter
public class BeanValidationResponseCustomizada extends ExcecaoCustomizavelPadrao {

    private final String fields;

    public BeanValidationResponseCustomizada(Instant timestamp, Integer status, String message, String fields) {
        super(timestamp, status, message);
        this.fields = fields;
    }
}
