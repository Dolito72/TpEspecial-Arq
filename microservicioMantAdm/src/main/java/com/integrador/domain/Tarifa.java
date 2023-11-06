package com.integrador.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

import com.integrador.service.dto.tarifa.TarifaRequestDto;

@Data
@Entity
public class Tarifa {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private double tarifaEstandar;

    @Column
    private double tarifaEspecial;

    @Temporal(TemporalType.TIMESTAMP)
    @Column
    private Date fechaEntradaVigencia;
    
    
    public Tarifa(TarifaRequestDto request) {
    	this.tarifaEspecial = request.getTarifaEspecial();
    	this.tarifaEstandar = request.getTarifaEstandar();
    	this.fechaEntradaVigencia = request.getFechaEntradaVigencia();
    }

	public Tarifa(double tarifaEstandar, double tarifaEspecial, Date fechaEntradaVigencia) {
		this.tarifaEstandar = tarifaEstandar;
		this.tarifaEspecial = tarifaEspecial;
		this.fechaEntradaVigencia = fechaEntradaVigencia;
	}

	public Tarifa() {
		super();
	}

	public Long getId() {
		return id;
	}

	public double getTarifaEstandar() {
		return tarifaEstandar;
	}

	public double getTarifaEspecial() {
		return tarifaEspecial;
	}

	public Date getFechaEntradaVigencia() {
		return fechaEntradaVigencia;
	}

	public void setId(Long iDTarifa) {
		id = iDTarifa;
	}

	public void setTarifaEstandar(double tarifaEstandar) {
		this.tarifaEstandar = tarifaEstandar;
	}

	public void setTarifaEspecial(double tarifaEspecial) {
		this.tarifaEspecial = tarifaEspecial;
	}

	public void setFechaEntradaVigencia(Date fechaEntradaVigencia) {
		this.fechaEntradaVigencia = fechaEntradaVigencia;
	}

}
