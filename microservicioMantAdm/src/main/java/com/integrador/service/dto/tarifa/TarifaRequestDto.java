package com.integrador.service.dto.tarifa;

import java.sql.Timestamp;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import lombok.Data;

@Data
@JsonIgnoreProperties( ignoreUnknown = true )
public class TarifaRequestDto {
	
	private Long id;

    private double tarifaEstandar;

    private double tarifaEspecial;

    private Date fechaEntradaVigencia;

	public TarifaRequestDto(double tarifaEstandar, double tarifaEspecial, Timestamp fechaEntradaVigencia) {
		this.tarifaEstandar = tarifaEstandar;
		this.tarifaEspecial = tarifaEspecial;
		this.fechaEntradaVigencia = fechaEntradaVigencia;
	}

	public Long getId() {
		return id;
	}

	public double getTarifaEstandar() {
		return tarifaEstandar;
	}

	public double getTarifaEspecial() {
		return tarifaEspecial;
	}

	public Date getFechaEntradaVigencia() {
		return fechaEntradaVigencia;
	}
    
    

}
