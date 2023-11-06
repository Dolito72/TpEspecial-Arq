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

import com.integrador.domain.Mantenimiento;
import com.integrador.service.MantenimientoService;
import com.integrador.service.dto.mantenimiento.MantenimientoRequestDto;
import com.integrador.service.dto.mantenimiento.MantenimientoResponseDto;


import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
@RestController
@RequestMapping("api/mantenimiento")
public class MantenimientoController {
	
	@Autowired
	private MantenimientoService mantenimientoService;
	
	@GetMapping("")
    public List<MantenimientoResponseDto> findAll(){
        return this.mantenimientoService.findAll();
    }
	
	@GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(mantenimientoService.findById(id));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error. Mantenimiento inexistente");
        }

    }
	//este va? o solo dejamos el agregar mantenimiento?
	@PostMapping("")
    public ResponseEntity<?> save (@RequestBody @Validated MantenimientoRequestDto request) {
	    try {
	    	return ResponseEntity.status(HttpStatus.OK).body(mantenimientoService.save(request));
	    }catch(Exception e) {
	    	return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body("Ocurrio un error, revise los campos ingresados");
	    } 
	}   
	
	@DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        try{
            this.mantenimientoService.delete(id);
            return ResponseEntity.status(HttpStatus.OK).body("Se elimino correctamente mantenimiento con el id: " + id);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error. No se pudo eliminar el mantenimiento con id: " + id);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody @Validated MantenimientoRequestDto request) {
        try {
            Mantenimiento mant = mantenimientoService.update(id, request);
            MantenimientoResponseDto response = new MantenimientoResponseDto(mant);

            return ResponseEntity.status(HttpStatus.OK).body(response);
          
        } catch (Exception e) {
        	return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se encontró el mantenimiento con el ID proporcionado.");
        }
    }
    
  //agregar un mantenimiento, a la tabla y setea el monopatin al q se le hace el mantenimientno
  	@PostMapping("/agregarMonopatinAMantenimiento/{idMonopatin}")
      public ResponseEntity<?> agregarMantenimiento (@PathVariable Long idMonopatin) {
  	    try {
  	    	return ResponseEntity.status(HttpStatus.OK).body(mantenimientoService.agregarMonopatinAMantenimiento(idMonopatin));
  	    }catch(Exception e) {
  	    	return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body("Ocurrio un error, id de monopatin inexistente");
  	    } 
  	}   
  	
  //setea un mantenimiento como terminado y setea el monopatin como disponible
  	@PostMapping("/finalizarMantenimiento/{idMantenimiento}")
      public ResponseEntity<?> finalizarMantenimiento (@PathVariable Long idMantenimiento) {
  	    try {	    
  	    	return ResponseEntity.status(HttpStatus.OK).body(mantenimientoService.finalizarMantenimiento(idMantenimiento));
  	    }catch(Exception e) {
  	    	return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body("Ocurrio un error, id de mantenimiento inexistente");
  	    } 
  	}   
	
}
