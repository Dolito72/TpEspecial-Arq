package com.integrador.domain;

import java.io.Serializable;

import com.integrador.service.dto.monopatin.MonopatinRequestDto;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Entity
public class Monopatin implements Serializable{

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_monopatin")
    private Long id;

	@Embedded
    private GPS ubicacion;

    //esta en uso-disponible-enMantenimiento
    @Column
    private String estado;
    
    //no esta en mantenimiento
    @Column
    private boolean disponible;
    
    @Column 
    private double kmsRecorridos;
    
    //va aumentando a cada viaje, cuando entra a ment se setea a cero
    
    @Column 
    private double kmsMant;
//definimos q a los 100km se le haga mant
    @Transient
    private double cantKmParaMant = 100;
    
  //definimos q a los 10000segundos se le haga mannt
    @Transient
    private double cantTiempoUsoParaMant = 10000;

    @Column
    private double tiempoUsoParaMant;
    //va aumentando a cada viaje
    @Column
    private int tiempoUsoTotal; //en segundos
    
    //iria un tiempo pausado???
    @Column
    private int tiempoPausado; //en segundos
    
    @Column
    private Long cantidadViajes;
    
  //  private double longitud; 


	public Monopatin() {
	
	}
    
    
    public Monopatin(MonopatinRequestDto request) {
        this.ubicacion = request.getUbicacion();
        this.estado = request.getEstado();
        this.disponible = request.isDisponible();
        this.kmsRecorridos = request.getKmsRecorridos();
        this.kmsMant = request.getKmsMantenimiento();
        this.tiempoUsoParaMant = request.getTiempoUsoParaMant();
        this.tiempoUsoTotal = request.getTiempoUsoTotal();
        this.tiempoPausado = request.getTiempoPausado();
        this.cantidadViajes = (long) request.getCantidadViajes();
     //   this.longitud = request.getUbicacion().getLongitud();
    }
    
    
    
    public double getCantTiempoUsoParaMant() {
		return cantTiempoUsoParaMant;
	}


	public void setCantTiempoUsoParaMant(double cantTiempoUsoParaMant) {
		this.cantTiempoUsoParaMant = cantTiempoUsoParaMant;
	}


	public boolean necesitaMantenimiento() {
    	return (this.cantKmParaMant <= this.kmsMant || 
    			this.cantTiempoUsoParaMant <= this.tiempoUsoParaMant);
    }
    
	public double getKmsMant() {
		return kmsMant;
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



	public void setKmsMant(double kmsMant) {
		this.kmsMant = kmsMant;
	}

	 public boolean isDisponible() {
			return disponible;
		}



	public void setDisponible(boolean disponible) {
		this.disponible = disponible;
	}
	public void setId(Long id) {
		this.id = id;
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



	public void setTiempoUsoTotal(int tiempoUsoTotal) {
		this.tiempoUsoTotal = tiempoUsoTotal;
	}



	public void setTiempoPausado(int tiempoPausado) {
		this.tiempoPausado = tiempoPausado;
	}



	public void setCantidadViajes(long cantidadViajes) {
		this.cantidadViajes = cantidadViajes;
	}



	public Long getId() {
		return id;
	}
	
	public int getTiempoPausado() {
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

	public int getTiempoUsoTotal() {
		return tiempoUsoTotal;
	}


	@Override
	public String toString() {
		return "Monopatin [id=" + id + ", ubicacion=" + ubicacion + ", estado=" + estado + ", disponible=" + disponible
				+ ", kmsRecorridos=" + kmsRecorridos + ", kmsMant=" + kmsMant + ", cantKmParaMant=" + cantKmParaMant
				+ ", tiempoUsoTotal=" + tiempoUsoTotal + ", tiempoPausado=" + tiempoPausado + ", cantidadViajes="
				+ cantidadViajes + "]";
	}
	
    
}
