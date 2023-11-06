package com.integrador.service.dto.usuarioCuenta;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
@JsonIgnoreProperties( ignoreUnknown = true )

public class UsuarioCuentaRequestDto {
	
	private Long idUsuario;
	private Long idCuenta;
	
	public UsuarioCuentaRequestDto(Long idUsuario, Long idCuenta) {
		this.idUsuario = idUsuario;
		this.idCuenta = idCuenta;
	}


	public Long getIdUsuario() {
		return idUsuario;
	}

	public Long getIdCuenta() {
		return idCuenta;
	}
	
	
}
