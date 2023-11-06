package com.integrador.service.dto.parada;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.integrador.domain.GPS;
import com.integrador.domain.Parada;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@NoArgsConstructor
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class ParadaResponseDto {
	
	private final Long id;
	private final String nombre;
	private final GPS ubicacion;
	
	public ParadaResponseDto(Parada p) {
		this.id = p.getId();
		this.nombre = p.getNombre();
		this.ubicacion = p.getUbicacion();
	}

}
