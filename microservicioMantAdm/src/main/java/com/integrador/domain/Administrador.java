package com.integrador.domain;

import com.integrador.service.dto.administrador.AdministradorRequestDto;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
public class Administrador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long IdAdministrador;
    @Column
    private String rol;
    @Column
    private String nombreYApellido;
    
    

    public Administrador() {
		super();
	}

	public Administrador(AdministradorRequestDto request){
		this.IdAdministrador = request.getId();
        this.rol= request.getRol();
        this.nombreYApellido= request.getNombreYApellido();
    }

	public Long getIdAdministrador() {
		return IdAdministrador;
	}

	public String getRol() {
		return rol;
	}

	public String getNombreYApellido() {
		return nombreYApellido;
	}

	public void setIdAdministrador(Long idAdministrador) {
		IdAdministrador = idAdministrador;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}

	public void setNombreYApellido(String nombreYApellido) {
		this.nombreYApellido = nombreYApellido;
	}

    
}
