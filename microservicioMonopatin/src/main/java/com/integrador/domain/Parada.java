package com.integrador.domain;

import java.io.Serializable;

import com.integrador.service.dto.parada.ParadaRequestDto;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
public class Parada implements Serializable{
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	@Column
    private String nombre;
	
	@Embedded
    private GPS ubicacion;
	
	
	
	public Parada() {
	
	}

	public Parada(ParadaRequestDto request) {
		this.id = request.getId();
		this.nombre = request.getNombre();
		this.ubicacion = request.getUbicacion();
	}
	
	public Long getId() {
		return id;
	}
	public String getNombre() {
		return nombre;
	}
	public GPS getUbicacion() {
		return ubicacion;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public void setUbicacion(GPS ubicacion) {
		this.ubicacion = ubicacion;
	}
	
	

}
