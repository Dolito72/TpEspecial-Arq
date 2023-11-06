package com.integrador.service.dto.mantenimiento;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.sql.Timestamp;
import java.util.Date;
@Data
@JsonIgnoreProperties( ignoreUnknown = true )
public class MantenimientoRequestDto {
	
	private Long id;

    private Long idMonopatin;

    private Date fechaHoraInicioMantenimiento;

    private Date fechaHoraFinalizacionMantenimiento;

    private boolean reparado;
    
    
	public MantenimientoRequestDto(Long idMonopatin, Timestamp fechaHoraInicioMantenimiento,
			Timestamp fechaHoraFinalizacionMantenimiento, boolean reparado) {
		this.idMonopatin = idMonopatin;
		this.fechaHoraInicioMantenimiento = fechaHoraInicioMantenimiento;
		this.fechaHoraFinalizacionMantenimiento = fechaHoraFinalizacionMantenimiento;
		this.reparado = reparado;
	}



	public Long getId() {
		return id;
	}

	

	public Long getIdMonopatin() {
		return idMonopatin;
	}



	public Date getFechaHoraInicioMantenimiento() {
		return fechaHoraInicioMantenimiento;
	}

	public Date getFechaHoraFinalizacionMantenimiento() {
		return fechaHoraFinalizacionMantenimiento;
	}

	public boolean isReparado() {
		return reparado;
	}
    
}
