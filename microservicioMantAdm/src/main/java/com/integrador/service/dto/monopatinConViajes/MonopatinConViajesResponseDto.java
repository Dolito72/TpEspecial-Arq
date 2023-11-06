package com.integrador.service.dto.monopatinConViajes;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.integrador.domain.GPS;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;


@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class MonopatinConViajesResponseDto implements Serializable{
	
	private Long id;

    private GPS ubicacion;

    private String estado;
  
    private boolean disponible;
  
    private double kmsRecorridos;

    private double kmsMant;

    private Long cantidadViajes;
    
    private Date finViaje;

	public MonopatinConViajesResponseDto(Long id, GPS ubicacion, String estado, boolean disponible,
			double kmsRecorridos, double kmsMant, Long cantidadViajes, Date finViaje) {
	this.id = id;
		this.ubicacion = ubicacion;
		this.estado = estado;
		this.disponible = disponible;
		this.kmsRecorridos = kmsRecorridos;
		this.kmsMant = kmsMant;
		this.cantidadViajes = cantidadViajes;
		this.finViaje = finViaje;
	}
    

}
