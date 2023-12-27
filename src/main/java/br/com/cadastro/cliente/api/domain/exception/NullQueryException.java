package br.com.cadastro.cliente.api.domain.exception;

public class NullQueryException extends RuntimeException {

    public NullQueryException(String message) {
        super(message);
    }
}
