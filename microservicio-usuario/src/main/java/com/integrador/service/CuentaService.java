package com.integrador.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.integrador.domain.Cuenta;
import com.integrador.domain.Usuario;
import com.integrador.repository.CuentaRepository;
import com.integrador.repository.UsuarioRepository;
import com.integrador.service.dto.cuenta.CuentaRequestDto;
import com.integrador.service.dto.cuenta.CuentaResponseDto;
import com.integrador.service.dto.usuario.UsuarioRequestDto;
import com.integrador.service.dto.usuario.UsuarioResponseDto;
import com.integrador.service.exception.NotFoundException;

@Service
public class CuentaService {

	private  CuentaRepository cuentaRepository;
	 
	 public CuentaService( CuentaRepository cuentaRepository ) { 
		 this.cuentaRepository = cuentaRepository;
	 }
	
	 @Transactional
	 public CuentaResponseDto save(CuentaRequestDto request ){
       Cuenta cuenta = new Cuenta(request);
       Cuenta result = this.cuentaRepository.save(cuenta);
       return new CuentaResponseDto(result);
	 }
	    
	    
 

   @Transactional
   public List<CuentaResponseDto> findAll(){
       return this.cuentaRepository.findAll().stream().map( CuentaResponseDto::new ).toList();
   }

   @Transactional
   public CuentaResponseDto findById( Long id ){
       return this.cuentaRepository.findById( id )
               .map( CuentaResponseDto::new )
               .orElseThrow( () -> new NotFoundException("Cuenta", id ) );
   }
   
   @Transactional
   public void delete(Long id) {
	   cuentaRepository.delete(this.cuentaRepository.findById(id).orElseThrow(
               () -> new NotFoundException("ID de cuenta invalido:" + id)));
   }
   
   //chequear
   @Transactional
   public Cuenta update(Long id, CuentaRequestDto request) {
       Cuenta cuenta = this.cuentaRepository.findById(id).orElseThrow(
               () -> new NotFoundException("ID de cuenta inválido: " + id));
       cuenta.setSaldo(request.getSaldo());
       cuenta.setFechaAlta(request.getFechaAlta());
       cuenta.setDisponible(request.isDisponible());
    
       return this.cuentaRepository.save(cuenta);
   }
   
	
	
}
