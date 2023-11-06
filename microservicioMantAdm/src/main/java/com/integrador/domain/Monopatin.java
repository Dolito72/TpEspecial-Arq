package com.integrador.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.io.Serializable;
import java.time.Duration;
import java.util.Date;

import com.integrador.service.dto.monopatin.MonopatinRequestDto;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Transient;
@Data
public class Monopatin implements Serializable {
	private Long id;
	
    private GPS ubicacion;

    private String estado;

    private boolean disponible;
 
    private double kmsRecorridos;
   
    private double kmsMantenimiento;

    private double cantKmParaMant = 100;
    
    private double cantTiempoUsoParaMant = 10000;

    private double tiempoUsoParaMant;//aumenta a cada viaje, vuelve a cero con hace mant

    private Long tiempoUsoTotal; //en segundos
    
    private Long tiempoPausado; //en segundos
    
   
    private Long cantidadViajes;
    
    private Date fechaViaje;


	public Monopatin() {
	
	}
	
	public Monopatin(Monopatin request) {
		this.id = request.getId();
        this.ubicacion = request.getUbicacion();
        this.estado = request.getEstado();
        this.disponible = request.isDisponible();
        this.kmsRecorridos = request.getKmsRecorridos();
        this.kmsMantenimiento = request.getKmsMantenimiento();
        this.tiempoUsoParaMant = request.getTiempoUsoParaMant();
        this.tiempoUsoTotal = request.getTiempoUsoTotal();
        this.tiempoPausado = request.getTiempoPausado();
        this.cantidadViajes = request.getCantidadViajes();
        this.fechaViaje = request.getFechaViaje();
    }


	public Long getId() {
		return id;
	}

	public Date getFechaViaje() {
		return fechaViaje;
	}

	public boolean estaEnMantenimiento() {
		return (!disponible && this.estado.equalsIgnoreCase("en mantenimiento"));
	}
    
    public boolean necesitaMantenimiento() {
    	return (this.cantKmParaMant <= this.kmsMantenimiento || 
    			this.cantTiempoUsoParaMant <= this.tiempoUsoParaMant);
    }
    
    

	public double getKmsMantenimiento() {
		return kmsMantenimiento;
	}

	public double getTiempoUsoParaMant() {
		return tiempoUsoParaMant;
	}

	public void setCantKmParaMant(double cantKmParaMant) {
		this.cantKmParaMant = cantKmParaMant;
	}

	public void setTiempoUsoParaMant(double tiempoUsoParaMant) {
		this.tiempoUsoParaMant = tiempoUsoParaMant;
	}

	public double getCantKmParaMant() {
		return cantKmParaMant;
	}



	public void setKmsMantenimiento(double kmsMant) {
		this.kmsMantenimiento = kmsMant;
	}





	 public boolean isDisponible() {
			return disponible;
		}



	public void setDisponible(boolean disponible) {
		this.disponible = disponible;
	}




	public void setUbicacion(GPS ubicacion) {
		this.ubicacion = ubicacion;
	}



	public void setEstado(String estado) {
		this.estado = estado;
	}



	public void setKmsRecorridos(double kmsRecorridos) {
		this.kmsRecorridos = kmsRecorridos;
	}



	public void setTiempoUsoTotal(Long tiempoUsoTotal) {
		this.tiempoUsoTotal = tiempoUsoTotal;
	}



	public void setTiempoPausado(Long tiempoPausado) {
		this.tiempoPausado = tiempoPausado;
	}



	public void setCantidadViajes(Long cantidadViajes) {
		this.cantidadViajes = cantidadViajes;
	}



	
	
	public Long getTiempoPausado() {
		return tiempoPausado;
	}

	public Long getCantidadViajes() {
		return cantidadViajes;
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

	public Long getTiempoUsoTotal() {
		return tiempoUsoTotal;
	}


	@Override
	public String toString() {
		return "Monopatin [ubicacion=" + ubicacion + ", estado=" + estado + ", disponible=" + disponible
				+ ", kmsRecorridos=" + kmsRecorridos + ", kmsMant=" + kmsMantenimiento + ", cantKmParaMant=" + cantKmParaMant
				+ ", tiempoUsoTotal=" + tiempoUsoTotal + ", tiempoPausado=" + tiempoPausado + ", cantidadViajes="
				+ cantidadViajes + "]";
	}
}
