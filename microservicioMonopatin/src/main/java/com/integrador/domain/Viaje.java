package com.integrador.domain;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

import com.integrador.domain.Parada;
import com.integrador.domain.clases.Usuario;
import com.integrador.service.dto.viaje.ViajeRequestDto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
public class Viaje implements Serializable{
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

	@Temporal(TemporalType.TIMESTAMP)
    @Column
    private Date inicioViaje;

	@Temporal(TemporalType.TIMESTAMP)
    @Column
    private Date finViaje;
    
    //necesita un atributo distancia recorrida?
    @Column 
    private double costo;
    
    @ManyToOne
    @JoinColumn(name = "id_monopatin") //chequear
    private Monopatin monopatin;
    
    //usuario q hizo el viaje
    @Column
    private Long  usuarioId;
    
    //cuenta con la que hioz el viaje
    @Column
    private Long  cuentaId;
    
    //ver
    @ManyToOne
    private Parada paradaFinal ;

    @Column 
    private double kmsRecorridos;
    
    @Column
    private double tiempoPausa; //en segundos
    
    @Column
    private boolean pausaActiva;
    
    
    
   public Viaje() {
	}



   public Viaje(Date inicioViaje, Date finViaje, double costo, Monopatin monopatin, Long usuarioId, Long cuentaId,
		Parada paradaFinal, double kmsRecorridos, double tiempoPausa, boolean pausaActiva) {
		this.inicioViaje = inicioViaje;
		this.finViaje = finViaje;
		this.costo = costo;
		this.monopatin = monopatin;
		this.usuarioId = usuarioId;
		this.cuentaId = cuentaId;
		this.paradaFinal = paradaFinal;
		this.kmsRecorridos = kmsRecorridos;
		this.tiempoPausa = tiempoPausa;
		this.pausaActiva = pausaActiva;
   }



   public Viaje(ViajeRequestDto request){
       this.inicioViaje = request.getInicioViaje();
       this.finViaje=request.getFinViaje();
       this.cuentaId = request.getCuentaId();
       this.usuarioId = request.getUsuarioId();
       this.costo = request.getCosto();
       this.kmsRecorridos = request.getKmsRecorridos();
       this.tiempoPausa = request.getTiempoPausa();
       this.pausaActiva = request.isPausaActiva();
    }

   

	public Long getId() {
		return id;
	}
	
	
	
	public Date getInicioViaje() {
		return inicioViaje;
	}
	
	
	public Date getFinViaje() {
		return finViaje;
	}
	
	
	public double getCosto() {
		return costo;
	}
	
	
	public Monopatin getMonopatin() {
		return monopatin;
	}
	
	
	public Long getUsuarioId() {
		return usuarioId;
	}
	
	
	public Long getCuentaId() {
		return cuentaId;
	}
	
	
	
	public Parada getParadaFinal() {
		return paradaFinal;
	}
	
	
	public double getKmsRecorridos() {
		return kmsRecorridos;
	}
	
	
	
	public double getTiempoPausa() {
		return tiempoPausa;
	}
	
	
	public boolean isPausaActiva() {
		return pausaActiva;
	}


	public void setId(Long id) {
		this.id = id;
	}
	
	
	public void setInicioViaje(Date inicioViaje) {
		this.inicioViaje = inicioViaje;
	}
	
	
	public void setFinViaje(Date finViaje) {
		this.finViaje = finViaje;
	}
	
	
	public void setCosto(double costo) {
		this.costo = costo;
	}
	
	
	public void setMonopatin(Monopatin monopatin) {
		this.monopatin = monopatin;
	}
	
	
	public void setUsuarioId(Long usuarioId) {
		this.usuarioId = usuarioId;
	}
	
	
	public void setCuentaId(Long cuentaId) {
		this.cuentaId = cuentaId;
	}
	
	
	public void setParadaFinal(Parada paradaFinal) {
		this.paradaFinal = paradaFinal;
	}
	
	
	public void setKmsRecorridos(double kmsRecorridos) {
		this.kmsRecorridos = kmsRecorridos;
	}
	
	
	public void setTiempoPausa(double tiempoPausa) {
		this.tiempoPausa = tiempoPausa;
	}
	
	
	public void setPausaActiva(boolean pausaActiva) {
		this.pausaActiva = pausaActiva;
	}

   

}