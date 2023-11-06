package com.integrador.service;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
//import org.springframework.http.HttpEntity;
//import org.springframework.http.HttpHeaders;
//import org.springframework.http.HttpMethod;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.MediaType;
//import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.integrador.domain.Cuenta;
import com.integrador.domain.Usuario;
import com.integrador.domain.clases.Monopatin;
import com.integrador.repository.CuentaRepository;
import com.integrador.repository.UsuarioRepository;
import com.integrador.service.dto.monopatin.MonopatinesCercaResponseDto;
import com.integrador.service.dto.usuario.UsuarioRequestDto;
import com.integrador.service.dto.usuario.UsuarioResponseDto;
import com.integrador.service.dto.usuarioCuenta.UsuarioCuentaRequestDto;
import com.integrador.service.dto.usuarioCuenta.UsuarioCuentaResponseDto;
import com.integrador.service.exception.NotFoundException;

import jakarta.transaction.Transactional;


@Service
public class UsuarioService {
		
	@Autowired
    private  RestTemplate restTemplate;
	
	 private  UsuarioRepository usuarioRepository;
	 private CuentaRepository cuentaRepository;
	 
	 public UsuarioService( UsuarioRepository usuarioRepository, CuentaRepository cuentaRepository ) { 
		 this.usuarioRepository = usuarioRepository;
		 this.cuentaRepository = cuentaRepository;
	 }
	
	 @Transactional
    public UsuarioResponseDto save(UsuarioRequestDto request ){
        Usuario usuario = new Usuario(request);
        Usuario result = this.usuarioRepository.save(usuario);
        return new UsuarioResponseDto(result);
    }
	    
    @Transactional
    public List<UsuarioResponseDto> findAll(){
    	List<Usuario> usuarios = this.usuarioRepository.findAll();
    	System.out.println(usuarios);
    	List<UsuarioResponseDto> response = new ArrayList<UsuarioResponseDto>();
    	
    	for(int i =0; i < usuarios.size(); i++) {
    		UsuarioResponseDto usuResponse = new UsuarioResponseDto(usuarios.get(i));
    		response.add(usuResponse);
    		
    	}
    	System.out.println(response);
        return response;
    }

    @Transactional
    public UsuarioResponseDto findById( Long id ){
        return this.usuarioRepository.findById( id )
                .map( UsuarioResponseDto::new )
                .orElseThrow( () -> new NotFoundException("Cuenta", id ) );
    }
    
    @Transactional
    public void delete(Long id) {
    	usuarioRepository.delete(this.usuarioRepository.findById(id).orElseThrow(
                () -> new NotFoundException("ID de usuario invalido:" + id)));
    }
    
    //chequear
    @Transactional
    public Usuario update(Long id, UsuarioRequestDto request) {
        Usuario usuario = this.usuarioRepository.findById(id).orElseThrow(
                () -> new NotFoundException("ID de usuario inválido: " + id));
        
        usuario.setNombre(request.getNombre());
        usuario.setApellido(request.getApellido());
        usuario.setEmail(request.getEmail());
        usuario.setCelular(request.getCelular());
        return this.usuarioRepository.save(usuario);
    }
    
    @Transactional
    public UsuarioCuentaResponseDto asociarCuenta(UsuarioCuentaRequestDto request){
		
    	Cuenta cuenta = cuentaRepository.findById(request.getIdCuenta())
							.orElseThrow( () -> new NotFoundException(String.format("No existe la cuenta con id %s", request.getIdCuenta() ) ) );
	
		Usuario usuario = usuarioRepository.findById(request.getIdUsuario())
				.orElseThrow( () -> new NotFoundException(String.format("No existe el usuario con id %s", request.getIdUsuario() ) ) );
		
		usuario.insertarCuenta(cuenta);
		
		return new UsuarioCuentaResponseDto(request.getIdUsuario(), request.getIdCuenta());
    }
    
    @Transactional
    public UsuarioCuentaResponseDto quitarCuenta(UsuarioCuentaRequestDto request){
		
    	Cuenta cuenta = cuentaRepository.findById(request.getIdCuenta())
							.orElseThrow( () -> new NotFoundException(String.format("No existe la cuenta con id %s", request.getIdCuenta() ) ) );
	
		Usuario usuario = usuarioRepository.findById(request.getIdUsuario())
				.orElseThrow( () -> new NotFoundException(String.format("No existe el usuario con id %s", request.getIdUsuario() ) ) );
		
		usuario.quitarCuenta(cuenta);
		
		return new UsuarioCuentaResponseDto(request.getIdUsuario(), request.getIdCuenta());
    }
 
    
    @Transactional
    public List<MonopatinesCercaResponseDto> obtenerMonopatinesCerca(double latitud, double longitud) {
    	HttpHeaders headers = new HttpHeaders();
    	HttpEntity<Void> requestEntity = new HttpEntity<>(headers);
    	ResponseEntity<List<MonopatinesCercaResponseDto>> response = restTemplate.exchange(
    			"http://localhost:8003/api/monopatines/obtenerMonopatinesCerca/" +latitud+"/"+longitud,
				HttpMethod.GET,
				requestEntity,
				new ParameterizedTypeReference<List<MonopatinesCercaResponseDto>>() {}
				);	
    	System.out.println(response);
    	headers.setContentType(MediaType.APPLICATION_JSON);
    	return response.getBody();
    }
    

	
}
