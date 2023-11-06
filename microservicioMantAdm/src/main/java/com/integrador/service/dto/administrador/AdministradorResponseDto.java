package com.integrador.service.dto.administrador;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.integrador.domain.Administrador;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class AdministradorResponseDto {
	
	private Long id;

    private String rol;

    private String nombreYApellido;

    public AdministradorResponseDto(Administrador a){
    	this.id = a.getIdAdministrador();
        this.rol= a.getRol() ;
        this.nombreYApellido=a.getNombreYApellido();
    }

	public String getRol() {
		return rol;
	}

	public String getNombreYApellido() {
		return nombreYApellido;
	}
    
    
}
