package com.integrador.service.dto.monopatin;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.integrador.domain.GPS;

import lombok.Data;

@Data
@JsonIgnoreProperties( ignoreUnknown = true )
public class MonopatinRequestDto {
	//private Long id;
    private GPS ubicacion;
    private String estado;
    private boolean disponible;
    private double kmsRecorridos;
    private double kmsMantenimiento;
    private double tiempoUsoParaMant;
    private Long tiempoUsoTotal;
    private Long tiempoPausado;
    private Long cantidadViajes;
    

//
//	public Long getId() {
//		return id;
//	}


	public double getKmsMantenimiento() {
		return kmsMantenimiento;
	}


	public double getTiempoUsoParaMant() {
		return tiempoUsoParaMant;
	}


	public double getkmsMantenimiento() {
		return kmsMantenimiento;
	}


	public Long getCantidadViajes() {
		return cantidadViajes;
	}
    
    
    public boolean isDisponible() {
		return disponible;
	}


	public Long getTiempoPausado() {
		return tiempoPausado;
	}
	
	
	public GPS getUbicacion() {
		return ubicacion;
	}
	public String getEstado() {
		return estado;
	}
	public double getKmsRecorridos() {
		return kmsRecorridos;
	}
	public Long getTiempoUsoTotal() {
		return tiempoUsoTotal;
	}
}
