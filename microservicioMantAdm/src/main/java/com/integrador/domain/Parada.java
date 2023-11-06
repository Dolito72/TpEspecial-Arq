package com.integrador.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

import com.integrador.service.dto.parada.ParadaRequestDto;
@Data
public class Parada implements Serializable {

    private String nombre;

    private GPS ubicacion;
    
    public Parada(ParadaRequestDto request) {
    	this.nombre = request.getNombre();
    	this.ubicacion = request.getUbicacion();
    }

    public Parada(String nombre, GPS ubicacion) {
        this.nombre = nombre;
        this.ubicacion = ubicacion;
    }

	public String getNombre() {
		return nombre;
	}

	public GPS getUbicacion() {
		return ubicacion;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setUbicacion(GPS ubicacion) {
		this.ubicacion = ubicacion;
	}
    
    
}
