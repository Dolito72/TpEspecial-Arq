package com.integrador.service.dto.monopatin;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.integrador.domain.GPS;
import com.integrador.domain.Monopatin;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
@Data
@RequiredArgsConstructor
@NoArgsConstructor
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class MonopatinResponseDto {
	//private final Long id;
    private final GPS ubicacion;
	private final String estado;
	private final boolean disponible;
	private final double kmsRecorridos;
	private final double kmsMantenimiento;
	private final double tiempoUsoParaMant;
	private final Long tiempoUsoTotal;
    private final Long tiempoPausado;
    private final Long cantidadViajes;
	
    
	public MonopatinResponseDto(Monopatin m ) {
	//	this.id = m.getId();
        this.ubicacion = m.getUbicacion();
        this.estado = m.getEstado();
        this.disponible = m.isDisponible();
        this.kmsRecorridos = m.getKmsRecorridos();
        this.kmsMantenimiento = m.getKmsMantenimiento();
        this.tiempoUsoParaMant = m.getTiempoUsoParaMant();
        this.tiempoUsoTotal = m.getTiempoUsoTotal();
        this.tiempoPausado = m.getTiempoPausado();
        this.cantidadViajes = m.getCantidadViajes();
	}

}
