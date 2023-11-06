package com.integrador.service.dto.parada;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.integrador.domain.GPS;
import com.integrador.domain.Parada;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class ParadaResponseDto {
	
	private String nombre;
    private GPS ubicacion;

    public ParadaResponseDto(Parada p){
        this.nombre= p.getNombre();
        this.ubicacion=p.getUbicacion();
    }

}
