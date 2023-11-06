package com.integrador.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.integrador.service.dto.cuenta.CuentaRequestDto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
public class Cuenta implements Serializable{
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private double saldo;
    @Column
    private Date fechaAlta;
    @Column 
    private boolean disponible;

//    @Column
//    private MP cuentaMP;

    //en la entidad usuario el campo cuentas es el q administra la relacion
    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "cuentas")
    private List<Usuario> usuarios;

    
    
    public Cuenta() {
	
    }


	public Cuenta(CuentaRequestDto request) {
    	this.saldo = request.getSaldo();
    	this.fechaAlta = request.getFechaAlta();
    	this.disponible = request.isDisponible();
    }
	
	
    
    
    public boolean isDisponible() {
		return disponible;
	}


	public void setDisponible(boolean disponible) {
		this.disponible = disponible;
	}


	public void cargarSaldo(double saldo){
        this.saldo += saldo;
    }

    public void descontarSaldo(double saldo){
        this.saldo -= saldo;
    }

	public Long getId() {
		return id;
	}

	public double getSaldo() {
		return saldo;
	}

	public Date getFechaAlta() {
		return fechaAlta;
	}

	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public void setFechaAlta(Date fechaAlta) {
		this.fechaAlta = fechaAlta;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}


	@Override
	public String toString() {
		return "Cuenta [id=" + id + ", saldo=" + saldo + ", fechaAlta=" + fechaAlta + "]";
	}


	
    
	
}
