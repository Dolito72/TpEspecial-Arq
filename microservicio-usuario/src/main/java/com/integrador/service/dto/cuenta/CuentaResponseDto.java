package com.integrador.service.dto.cuenta;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.integrador.domain.Cuenta;
import com.integrador.domain.Usuario;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@NoArgsConstructor
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class CuentaResponseDto {
	
	private final Long id;
    private final double saldo;
    private final Date fechaAlta;
    private final boolean disponible;
    
    public CuentaResponseDto(Cuenta c ) {
        this.id = c.getId();
        this.saldo = c.getSaldo();
        this.fechaAlta = c.getFechaAlta();
        this.disponible = c.isDisponible();
	}
	

}
