package com.integrador.service.dto.monopatin;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class MonopatinesCercaResponseDto {
    private Long idMonopatin;
    private double latitud;
    private double longitud;
    
    public MonopatinesCercaResponseDto(Long id, double latitud, double longitud ){
        this.latitud = latitud;
        this.longitud = longitud;
        this.idMonopatin=id;
    }

	public MonopatinesCercaResponseDto() {
		super();
	}
    
    
}
