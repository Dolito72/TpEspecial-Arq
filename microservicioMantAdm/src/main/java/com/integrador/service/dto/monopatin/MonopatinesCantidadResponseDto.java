package com.integrador.service.dto.monopatin;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class MonopatinesCantidadResponseDto {
	private Long cantidadMonopatinesOperacion;
	private Long cantidadMonopatinesMantenimiento;
	
	public MonopatinesCantidadResponseDto(Long cantidadMonopatinesOperacion, Long cantidadMonopatinesMantenimiento) {
		this.cantidadMonopatinesOperacion = cantidadMonopatinesOperacion;
		this.cantidadMonopatinesMantenimiento = cantidadMonopatinesMantenimiento;
	}
	
	public MonopatinesCantidadResponseDto() {
	
	}

	@Override
	public String toString() {
		return "MonopatinesCantidadResponseDto [cantidadMonopatinesOperacion=" + cantidadMonopatinesOperacion
				+ ", cantidadMonopatinesMantenimiento=" + cantidadMonopatinesMantenimiento + "]";
	}
	
	
	
}
