package com.integrador.domain.clases;

import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.Column;

public class Cuenta implements Serializable{

   
    private double saldo;
    
    private Date fechaAlta;

	public Cuenta(double saldo, Date fechaAlta) {
		this.saldo = saldo;
		this.fechaAlta = fechaAlta;
	}

	public Cuenta() {
		super();
	}

	
	public double getSaldo() {
		return saldo;
	}

	public Date getFechaAlta() {
		return fechaAlta;
	}


	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public void setFechaAlta(Date fechaAlta) {
		this.fechaAlta = fechaAlta;
	}
    
    
    
}
