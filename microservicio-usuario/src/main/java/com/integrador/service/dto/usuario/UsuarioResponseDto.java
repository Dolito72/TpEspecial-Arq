package com.integrador.service.dto.usuario;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.integrador.domain.Usuario;
import com.integrador.domain.Cuenta;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@NoArgsConstructor
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class UsuarioResponseDto implements Serializable{

	private  Long id;
    private  String nombre;
    private String apellido;
	private  String celular;
	private  String email;
	@JsonIgnore
	private  List<Cuenta> cuentas;
	
	
	
    
	public UsuarioResponseDto(Usuario u ) {
        this.id = u.getId();
        this.nombre = u.getNombre();
        this.apellido = u.getApellido();
        this.celular = u.getCelular();
        this.email = u.getEmail();
        
        
        this.cuentas = u.getCuentas();
	}

	public UsuarioResponseDto() {
			
	}

	@Override
	public String toString() {
		return "UsuarioResponseDto [apellido=" + apellido + ", cuentas=" + cuentas + "]";
	}
	
	
}
