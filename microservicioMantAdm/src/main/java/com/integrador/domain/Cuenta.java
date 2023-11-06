package com.integrador.domain;

import java.util.Date;

public class Cuenta {
	
	private Long id;
	
	private double saldo;

	private Date fechaAlta;

	private boolean disponible;
	
	

	public Cuenta() {
		super();
	}

	public Cuenta(Long id, double saldo, Date fechaAlta, boolean disponible) {
		this.id = id;
		this.saldo = saldo;
		this.fechaAlta = fechaAlta;
		this.disponible = disponible;
	}

	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public double getSaldo() {
		return saldo;
	}

	public Date getFechaAlta() {
		return fechaAlta;
	}

	public boolean isDisponible() {
		return disponible;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public void setFechaAlta(Date fechaAlta) {
		this.fechaAlta = fechaAlta;
	}

	public void setDisponible(boolean disponible) {
		this.disponible = disponible;
	}
	  
	  
	  
	  

}
