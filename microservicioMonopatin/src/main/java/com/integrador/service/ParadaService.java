package com.integrador.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.integrador.domain.Parada;
import com.integrador.repository.ParadaRepository;
import com.integrador.service.dto.parada.*;
import com.integrador.service.exception.NotFoundException;

import jakarta.transaction.Transactional;

@Service
public class ParadaService {
	
	private ParadaRepository paradaRepository;
	
	public ParadaService(ParadaRepository paradaRepository) {
		this.paradaRepository = paradaRepository;
		
	}
	
	
	 @Transactional
   public ParadaResponseDto save(ParadaRequestDto request ){
       Parada parada= new Parada(request);
       Parada result = this.paradaRepository.save(parada);
       return new ParadaResponseDto(result);
   }
	    
	    
 

   @Transactional
   public List<ParadaResponseDto> findAll(){
       return this.paradaRepository.findAll().stream().map( ParadaResponseDto::new ).toList();
   }

   @Transactional
   public ParadaResponseDto findById( Long id ){
       return this.paradaRepository.findById( id )
               .map( ParadaResponseDto::new )
               .orElseThrow( () -> new NotFoundException("Cuenta", id ) );
   }
   
   @Transactional
   public void delete(Long id) {
   	this.paradaRepository.delete(this.paradaRepository.findById(id).orElseThrow(
               () -> new NotFoundException("ID de parada invalido:" + id)));
   }
   
//   chequear
   @Transactional
   public Parada update(Long id, ParadaRequestDto request) {
       Parada parada = this.paradaRepository.findById(id).orElseThrow(
               () -> new NotFoundException("ID de parada inválido: " + id));
      
       parada.setNombre(request.getNombre());
       parada.setUbicacion(request.getUbicacion());
       return this.paradaRepository.save(parada);
   }

}
