package com.integrador.service;



import java.util.Date;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.integrador.service.dto.monopatin.*;
import com.integrador.service.dto.monopatinConViajes.MonopatinConViajesResponseDto;
import com.integrador.domain.Monopatin;
import com.integrador.repository.MonopatinRepository;
import com.integrador.service.exception.*;



@Service
public class MonopatinService {
	
	 private  MonopatinRepository monopatinRepository;
	 
	 public MonopatinService( MonopatinRepository monopatinRepository) { 
		 this.monopatinRepository = monopatinRepository;
	 }
	 

	@Transactional
    public MonopatinResponseDto save(MonopatinRequestDto request ){
		 System.out.println(request);
        Monopatin monopatin = new Monopatin(request);
        Monopatin result = this.monopatinRepository.save(monopatin);
        return new MonopatinResponseDto(result);
    }
	    
    @Transactional
    public List<MonopatinResponseDto> findAll(){
        return this.monopatinRepository.findAll().stream().map( MonopatinResponseDto::new ).toList();
    }

    @Transactional
    public MonopatinResponseDto findById( Long id ){
        return this.monopatinRepository.findById( id )
                .map( MonopatinResponseDto::new )
                .orElseThrow( () -> new NotFoundException("Monopatin", id ) );
    }
    
    @Transactional
    public void delete(Long id) {
    	this.monopatinRepository.delete(this.monopatinRepository.findById(id).orElseThrow(
                () -> new NotFoundException("ID de monopatin invalido:" + id)));
    }

    @Transactional
    public Monopatin update(Long id, MonopatinRequestDto request) {
        Monopatin monopatin = this.monopatinRepository.findById(id).orElseThrow(
                () -> new NotFoundException("ID de monopatin inválido: " + id));
       
        monopatin.setCantidadViajes(request.getCantidadViajes());
        monopatin.setEstado(request.getEstado());
        monopatin.setDisponible(request.isDisponible());
        monopatin.setKmsMant(request.getKmsMantenimiento());
        monopatin.setKmsRecorridos(request.getKmsRecorridos());
        monopatin.setTiempoUsoParaMant(request.getTiempoUsoParaMant());
        monopatin.setTiempoPausado(request.getTiempoPausado());
        monopatin.setTiempoUsoTotal(request.getTiempoUsoTotal());
        monopatin.setUbicacion(request.getUbicacion());
        return this.monopatinRepository.save(monopatin);
    }
    
    @Transactional
    public List<MonopatinResponseDto>  getMonopatinesPorKm(Long cantKm){
    	return this.monopatinRepository.getMonopatinesPorKm(cantKm);
    }
    
    @Transactional
    public List<MonopatinResponseDto>  getMonopatinesPorTiempoSinPausa(Long cantTiempo){
    	return this.monopatinRepository.getMonopatinesPorTiempoSinPausa(cantTiempo);
    }
    
    @Transactional
    public List<MonopatinResponseDto>  getMonopatinesPorTiempoConPausa(Long cantTiempo){
    	return this.monopatinRepository.getMonopatinesPorTiempoConPausa(cantTiempo);
    }
    
    @Transactional
    public List<MonopatinConViajesResponseDto> getMonopatinesConViajes(Long cantViajes, Integer anio){
    	return this.monopatinRepository.getMonopatinesConViajes(cantViajes, anio);
    }
    @Transactional
    public MonopatinesCantidadResponseDto getMonopatinesEnOperacionMantenimiento(){
    	return this.monopatinRepository.getMonopatinesEnOperacionMantenimiento();

    }
    
    @Transactional
    public List<MonopatinesCercaResponseDto> getMonopatinesCerca(double latitud, double longitud){
         return this.monopatinRepository.getMonopatinesCerca(latitud, longitud);
    }
    

}
