package br.com.cadastro.cliente.api.handler;

import br.com.cadastro.cliente.api.handler.response.BeanValidationResponseCustomizada;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
public class TratadorDeExcecoes {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<BeanValidationResponseCustomizada> methodArgumentNotValidException(MethodArgumentNotValidException ex) {

        List<FieldError> fieldErrors = ex.getBindingResult().getFieldErrors();
        String campos = fieldErrors.stream().map(FieldError::getField).collect(Collectors.joining(", "));
        String mensagens = fieldErrors.stream().map(FieldError::getDefaultMessage).collect(Collectors.joining(", "));

        BeanValidationResponseCustomizada error = new BeanValidationResponseCustomizada(
                Instant.now(),
                HttpStatus.BAD_REQUEST.value(),
                mensagens,
                campos
        );

        return ResponseEntity.badRequest().body(error);

    }

}
