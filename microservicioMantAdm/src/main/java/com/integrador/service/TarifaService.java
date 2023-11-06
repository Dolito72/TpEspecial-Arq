package com.integrador.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.integrador.domain.Tarifa;
import com.integrador.repository.TarifaRepository;
import com.integrador.service.dto.tarifa.TarifaRequestDto;
import com.integrador.service.dto.tarifa.TarifaResponseDto;
import com.integrador.service.exception.NotFoundException;

import jakarta.transaction.Transactional;

@Service
public class TarifaService {
	@Autowired
	private TarifaRepository tarifaRepository;

	public TarifaService(TarifaRepository tarifaRepository) {
		this.tarifaRepository = tarifaRepository;
	}
	
	
	@Transactional
    public TarifaResponseDto save(TarifaRequestDto request){
		System.out.println(request);
        Tarifa tarifa = new Tarifa(request);
        Tarifa result = this.tarifaRepository.save(tarifa);
        return new TarifaResponseDto(result);
    } 
	
	
	@Transactional
	public List<TarifaResponseDto> findAll(){
		List<Tarifa> tarifas = this.tarifaRepository.findAll();
		System.out.println(tarifas);
		List<TarifaResponseDto> response = new ArrayList<TarifaResponseDto>();
		
		for(int i =0; i < tarifas.size(); i++) {
			TarifaResponseDto tarResponse = new TarifaResponseDto(tarifas.get(i));
			response.add(tarResponse);
			
		}
		System.out.println(response);
	    return response;
	}
	 
	@Transactional
	public TarifaResponseDto findById( Long id ){
	    return this.tarifaRepository.findById( id )
	            .map( TarifaResponseDto::new )
	            .orElseThrow( () -> new NotFoundException("Tarifa", id ) );
	}
	    
    @Transactional
    public void delete(Long id) {
    	tarifaRepository.delete(this.tarifaRepository.findById(id).orElseThrow(
                () -> new NotFoundException("ID de tarifa invalido:" + id)));
    }


    @Transactional
    public Tarifa update(Long id, TarifaRequestDto request) {
    	Tarifa tarifa = this.tarifaRepository.findById(id).orElseThrow(
                () -> new NotFoundException("ID de tarifa inválido: " + id));
        
        tarifa.setTarifaEstandar(request.getTarifaEstandar());
        tarifa.setTarifaEspecial(request.getTarifaEspecial());
        tarifa.setFechaEntradaVigencia(request.getFechaEntradaVigencia());
        return this.tarifaRepository.save(tarifa);
    }
	
	 
	 
}
