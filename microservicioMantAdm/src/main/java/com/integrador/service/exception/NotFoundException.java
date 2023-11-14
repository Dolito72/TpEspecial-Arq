package com.integrador.service.exception;



import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@Data
public class NotFoundException extends RuntimeException {

    private final String message;

    public NotFoundException(String entity, Long id ){
        this.message = String.format( "La entidad %s con id %s no existe.", entity, id );
    }
    
    public NotFoundException(String message ) {
		this.message = message;
		// TODO Auto-generated constructor stub
	}

}
