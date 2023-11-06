package com.integrador.service.dto.tarifa;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.integrador.domain.Tarifa;

import lombok.Data;

@Data
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class TarifaResponseDto {
	
	private final Long id;

    private final double tarifaEstandar;

    private final double tarifaEspecial;

    private final Date fechaEntradaVigencia;
    
    public TarifaResponseDto(Tarifa t) {
    	this.id = t.getId();
    	this.tarifaEstandar = t.getTarifaEstandar();
    	this.tarifaEspecial = t.getTarifaEspecial();
    	this.fechaEntradaVigencia = t.getFechaEntradaVigencia();
    }

}
