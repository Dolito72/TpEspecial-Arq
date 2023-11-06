package com.integrador.domain.clases;

import java.io.Serializable;
import java.util.List;


import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToMany;
import lombok.Data;

@Data
public class Usuario implements Serializable{

    private String nombre;
    private String apellido;
    private String celular;
    private String email;
    private List<Cuenta> cuentas;
	public Usuario(String nombre, String apellido, String celular, String email, List<Cuenta> cuentas) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.celular = celular;
		this.email = email;
		this.cuentas = cuentas;
	}
	public Usuario() {
		
	}
	public String getNombre() {
		return nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public String getCelular() {
		return celular;
	}
	public String getEmail() {
		return email;
	}
	public List<Cuenta> getCuentas() {
		return cuentas;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public void setCelular(String celular) {
		this.celular = celular;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setCuentas(List<Cuenta> cuentas) {
		this.cuentas = cuentas;
	}
	
	
    
    
    
    
}
