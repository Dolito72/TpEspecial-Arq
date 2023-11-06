package com.integrador.service.dto.cuenta;

import java.sql.Timestamp;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import lombok.Data;

@Data
@JsonIgnoreProperties( ignoreUnknown = true )
public class CuentaRequestDto {

	private Long id;
	private double saldo;
    private Timestamp fechaAlta;
    private boolean disponible;
    
    
    public CuentaRequestDto(double saldo, Timestamp fechaAlta, boolean disponible) {
    	this.saldo = saldo;
    	this.fechaAlta = fechaAlta;
    	this.disponible = disponible;
		
	}

	public Long getId() {
    	return id;
    }
    
    public boolean isDisponible() {
    	return disponible;
    }
    
	public double getSaldo() {
		return saldo;
	}
	public Timestamp getFechaAlta() {
		return fechaAlta;
	}
    
}
