package com.integrador.service.dto.parada;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.integrador.domain.GPS;

import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ParadaRequestDto {
	
	 private String nombre;
	 private GPS ubicacion;
	public String getNombre() {
		return nombre;
	}
	public GPS getUbicacion() {
		return ubicacion;
	}
	 
	 

}
