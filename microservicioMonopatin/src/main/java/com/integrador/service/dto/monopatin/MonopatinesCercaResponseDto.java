package com.integrador.service.dto.monopatin;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class MonopatinesCercaResponseDto {
    private final Long idMonopatin;
    private final double latitud;
    private final double longitud;
    
    public MonopatinesCercaResponseDto(Long id, double latitud, double longitud ){
        this.latitud = latitud;
        this.longitud = longitud;
        this.idMonopatin=id;
    }
}