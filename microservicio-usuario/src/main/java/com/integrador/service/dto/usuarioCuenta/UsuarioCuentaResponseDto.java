package com.integrador.service.dto.usuarioCuenta;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@NoArgsConstructor
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class UsuarioCuentaResponseDto {
	
	private Long idUsuario;
	private Long idCuenta;
	
	public UsuarioCuentaResponseDto(Long idUsuario, Long idCuenta) {
		this.idUsuario = idUsuario;
		this.idCuenta = idCuenta;
	}


}
