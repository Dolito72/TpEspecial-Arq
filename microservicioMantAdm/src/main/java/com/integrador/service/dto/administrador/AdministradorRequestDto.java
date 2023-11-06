package com.integrador.service.dto.administrador;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class AdministradorRequestDto {
	
	private Long id;

    private String rol;

    private String nombreYApellido;

	public AdministradorRequestDto(String rol, String nombreYApellido) {
		this.rol = rol;
		this.nombreYApellido = nombreYApellido;
	}

	public String getRol() {
		return rol;
	}

	public String getNombreYApellido() {
		return nombreYApellido;
	}

	public Long getId() {
		return id;
	}
	
	
    
    
    
}
