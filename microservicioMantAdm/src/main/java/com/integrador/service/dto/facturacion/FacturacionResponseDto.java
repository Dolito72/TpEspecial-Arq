package com.integrador.service.dto.facturacion;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

import lombok.Data;

@Data
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class FacturacionResponseDto {
	private String descripcion;
	private double facturacionAcumulada;
	public FacturacionResponseDto(String descripcion, double facturacion) {
		super();
		this.descripcion = descripcion;
		this.facturacionAcumulada = facturacion;
	}
	public FacturacionResponseDto() {
		super();
	}
	
	

}
