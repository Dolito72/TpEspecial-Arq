package com.integrador.service.dto.monopatin;

import java.time.Duration;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.integrador.domain.GPS;
import com.integrador.domain.Viaje;

import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Data
@JsonIgnoreProperties( ignoreUnknown = true )
public class MonopatinRequestDto {
	private Long idMonopatin;
    private GPS ubicacion;
    private String estado;
    private boolean disponible;
    private double kmsRecorridos;
    private double kmsMantenimiento;
    private double tiempoUsoParaMant;
    private int tiempoUsoTotal;
    private int tiempoPausado;
    private int cantidadViajes;
    
    
    

    public MonopatinRequestDto(GPS ubicacion, String estado, boolean disponible, double kmsRecorridos, double kmsMantenimiento, int tiempoUsoTotal, int tiempoPausado, int cantidadViajes) {
		this.ubicacion = ubicacion;
		this.estado = estado;
		this.disponible = disponible;
		this.kmsRecorridos = kmsRecorridos;
		this.kmsMantenimiento = kmsMantenimiento;
		this.tiempoUsoTotal = tiempoUsoTotal;
		this.tiempoPausado = tiempoPausado;
		this.cantidadViajes = cantidadViajes;
	}


	public double getTiempoUsoParaMant() {
		return tiempoUsoParaMant;
	}


	public double getKmsMantenimiento() {
		return kmsMantenimiento;
	}


	public int getCantidadViajes() {
		return cantidadViajes;
	}
    
    public boolean isDisponible() {
		return disponible;
	}

	public int getTiempoPausado() {
		return tiempoPausado;
	}
	
    public Long getIdMonopatin() {
		return idMonopatin;
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
	
	public int getTiempoUsoTotal() {
		return tiempoUsoTotal;
	}
    
    
}
