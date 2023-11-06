package com.integrador.service.dto.viaje;

import java.sql.Timestamp;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.integrador.domain.Monopatin;
import com.integrador.domain.Parada;
import com.integrador.domain.clases.Cuenta;
import com.integrador.domain.clases.Usuario;

import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@JsonIgnoreProperties( ignoreUnknown = true )
public class ViajeRequestDto {
	
    private Long id;
    private Date inicioViaje;
    private Date finViaje;
    private double costo;
    private Long monopatinId;
    private Long cuentaId;
    private Long usuarioId;
    private Long paradaFinalId;
    private double kmsRecorridos;
    private int tiempoPausa; //en segundos
    private boolean pausaActiva;
    
    
    public ViajeRequestDto(Date inicioViaje, Date finViaje, double costo, Long monopatinId, Long cuentaId,
			Long usuarioId, Long paradaFinalId, double kmsRecorridos, int tiempoPausa, boolean pausaActiva) {
		this.inicioViaje = inicioViaje;
		this.finViaje = finViaje;
		this.costo = costo;
		this.monopatinId = monopatinId;
		this.cuentaId = cuentaId;
		this.usuarioId = usuarioId;
		this.paradaFinalId = paradaFinalId;
		this.kmsRecorridos = kmsRecorridos;
		this.tiempoPausa = tiempoPausa;
		this.pausaActiva = pausaActiva;
	}
    
	public double getKmsRecorridos() {
		return kmsRecorridos;
	}
	public double getTiempoPausa() {
		return tiempoPausa;
	}
	public boolean isPausaActiva() {
		return pausaActiva;
	} 
    
	public Long getId() {
		return id;
	}
	public Date getInicioViaje() {
		return inicioViaje;
	}
	public Date getFinViaje() {
		return finViaje;
	}
	public double getCosto() {
		return costo;
	}
	public Long getMonopatinId() {
		return monopatinId;
	}
	public Long getUsuarioId() {
		return usuarioId;
	}
	public Long getCuentaId() {
		return cuentaId;
	}
	public Long getParadaFinalId() {
		return paradaFinalId;
	}
   

    
    

}