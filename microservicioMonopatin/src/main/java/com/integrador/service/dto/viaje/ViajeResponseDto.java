package com.integrador.service.dto.viaje;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.integrador.domain.Monopatin;
import com.integrador.domain.Parada;
import com.integrador.domain.Viaje;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@NoArgsConstructor
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class ViajeResponseDto {
	
	private final Long id;
    private final Date inicioViaje;
    private final Date finViaje;
    private final double costo;
    private final Monopatin monopatin;
    private final Long cuentaId;
    private final Long usuarioId;
    private final Parada paradaFinal;
    private final double kmsRecorridos;
    private final double tiempoPausa; //en segundos
    private final boolean pausaActiva;
    
    
    public ViajeResponseDto(Viaje v) {
    	this.id = v.getId();
    	this.inicioViaje = v.getInicioViaje();
    	this.finViaje = v.getFinViaje();
    	this.costo = v.getCosto();
    	this.monopatin = v.getMonopatin();
    	this.cuentaId = v.getCuentaId();
    	this.usuarioId = v.getUsuarioId();
    	this.paradaFinal = v.getParadaFinal();
    	this.kmsRecorridos = v.getKmsRecorridos();
    	this.tiempoPausa = v.getTiempoPausa();
    	this.pausaActiva = v.isPausaActiva();
    }

}
