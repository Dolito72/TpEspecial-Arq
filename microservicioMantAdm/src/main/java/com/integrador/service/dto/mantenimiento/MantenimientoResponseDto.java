package com.integrador.service.dto.mantenimiento;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.integrador.domain.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.sql.Timestamp;
import java.util.Date;

@Data
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class MantenimientoResponseDto {

    private final Long id;
	
	private final Long monopatinId;

    private final Date fechaHoraInicioMantenimiento;

    private final Date fechaHoraFinalizacionMantenimiento;

    private final boolean reparado;

    public MantenimientoResponseDto(Mantenimiento m ){
    	this.id = m.getIDMantenimiento();
        this.monopatinId= m.getMonopatinId();
        this.fechaHoraInicioMantenimiento=m.getFechaHoraInicioMantenimiento();
        this.fechaHoraFinalizacionMantenimiento=m.getFechaHoraFinalizacionMantenimiento();
        this.reparado=m.isReparado();
    }
}
