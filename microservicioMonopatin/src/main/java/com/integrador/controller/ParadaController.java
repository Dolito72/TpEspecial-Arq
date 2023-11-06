package com.integrador.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.integrador.service.ParadaService;
import com.integrador.domain.Parada;
import com.integrador.service.dto.parada.ParadaRequestDto;
import com.integrador.service.dto.parada.ParadaResponseDto;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("api/paradas")
@RequiredArgsConstructor
public class ParadaController {
	
	@Autowired
	private  ParadaService paradaService;
	

	@GetMapping("")
    public List<ParadaResponseDto> findAll(){
        return this.paradaService.findAll();
    }

	
	 @GetMapping("/{id}")
	   public ResponseEntity<?> getById(@PathVariable Long id){
	        try{
	            return ResponseEntity.status(HttpStatus.OK).body(paradaService.findById(id));
	        }catch (Exception e){
	            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error. Parada inexistente");
	        }
	        
	  }

    //ver si funciona
    @PostMapping("")
    public ResponseEntity<?> save( @RequestBody @Validated ParadaRequestDto request ){
        try {
        	return ResponseEntity.status(HttpStatus.OK).body(paradaService.save(request));
        }catch(Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body("Ocurrio un error, revise los campos ingresados");
        }
    }
     

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        try{
            this.paradaService.delete(id);
            return ResponseEntity.status(HttpStatus.OK).body("Se elimino correctamente la parada con el id: " + id);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error. No se pudo eliminar la parada con id: " + id);
        }
    }
    
    //chequear
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody @Validated ParadaRequestDto request) {
        try {
            Parada parada = paradaService.update(id, request);
            ParadaResponseDto response = new ParadaResponseDto(parada);

            return ResponseEntity.status(HttpStatus.OK).body(response);
          
        } catch (Exception e) {
        	return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se encontró la parada con el ID proporcionado.");
        }
    }
	

}
