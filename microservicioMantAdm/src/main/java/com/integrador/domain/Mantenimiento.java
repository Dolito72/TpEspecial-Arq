package com.integrador.domain;

import com.integrador.service.dto.mantenimiento.*;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;


@Data
@Entity
public class Mantenimiento implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long IDMantenimiento;
   
    @Column
    private Long monopatinId;
   
    @Temporal(TemporalType.TIMESTAMP)
    @Column
    private Date fechaHoraInicioMantenimiento;
    @Temporal(TemporalType.TIMESTAMP)
    @Column
    private Date fechaHoraFinalizacionMantenimiento;
    @Column
    private boolean reparado;

    public Mantenimiento(MantenimientoRequestDto request){
    	this.monopatinId = (long) request.getIdMonopatin();
    	this.fechaHoraInicioMantenimiento= request.getFechaHoraInicioMantenimiento();
    	this.fechaHoraFinalizacionMantenimiento= request.getFechaHoraFinalizacionMantenimiento();
    	this.reparado= request.isReparado();
    }
    
    public void finalizar() {
    	this.setReparado(true);
    	this.setFechaHoraFinalizacionMantenimiento(new Date());
    }
    
	public Long getMonopatinId() {
		return monopatinId;
	}


	public void setMonopatinId(Long monopatinId) {
		this.monopatinId = monopatinId;
	}


	public Mantenimiento() {
		
	}


	public Long getIDMantenimiento() {
		return IDMantenimiento;
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

	public void setIDMantenimiento(Long iDMantenimiento) {
		IDMantenimiento = iDMantenimiento;
	}

	public void setFechaHoraInicioMantenimiento(Date fechaHoraInicioMantenimiento) {
		this.fechaHoraInicioMantenimiento = fechaHoraInicioMantenimiento;
	}

	public void setFechaHoraFinalizacionMantenimiento(Date fechaHoraFinalizacionMantenimiento) {
		this.fechaHoraFinalizacionMantenimiento = fechaHoraFinalizacionMantenimiento;
	}

	public void setReparado(boolean reparado) {
		this.reparado = reparado;
	}


	@Override
	public String toString() {
		return "Mantenimiento [IDMantenimiento=" + IDMantenimiento + ", IDmonopatin=" + monopatinId
				+ ", fechaHoraInicioMantenimiento=" + fechaHoraInicioMantenimiento
				+ ", fechaHoraFinalizacionMantenimiento=" + fechaHoraFinalizacionMantenimiento + ", reparado="
				+ reparado + "]";
	}
    
    

}
