package cibertec.edu.api_rest_ventas.exception;

import cibertec.edu.api_rest_ventas.model.dto.MensajeErrorDTo;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;

@RestControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public MensajeErrorDTo resourceNotFoundException(
            ResourceNotFoundException ex,
            WebRequest request
    ){
        return MensajeErrorDTo.builder()
                .mensaje(ex.getMessage())
                .codigoEstado(HttpStatus.NOT_FOUND.value())
                .fechaError(new Date())
                .description(request.getDescription(true)).build();
    }
}
