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
import com.integrador.service.ViajeService;
import com.integrador.domain.Viaje;
import com.integrador.service.dto.viaje.ViajeRequestDto;
import com.integrador.service.dto.viaje.ViajeResponseDto;

import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("api/viajes")
@RequiredArgsConstructor
public class ViajeController {
	
	@Autowired
	private ViajeService viajeService;
	
	  @Operation(summary = "Viajes find All.", description = " Lista todos los viajes "
		  		+ "en un determinado período")
	@GetMapping("")
    public List<ViajeResponseDto> findAll(){
        return this.viajeService.findAll();
    }

	  @Operation(summary = "Viaje por Id.", description = " Devuelve un viaje de acuerdo a su Id "
		  		+ "en un determinado período")
	 @GetMapping("/{id}")
	   public ResponseEntity<?> getById(@PathVariable Long id){
	        try{
	            return ResponseEntity.status(HttpStatus.OK).body(this.viajeService.findById(id));
	        }catch (Exception e){
	            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error. Viaje inexistente");
	        }
	        
	  }
	 
	 @Operation(summary = "Conectar usuario.", description = " Conecta un usuario a un viaje "
		  		+ "en un determinado período")
	 @GetMapping("/usuarios/{id}")
	   public ResponseEntity<?> conectarUsuario(@PathVariable Long id){
	        try{
	            return ResponseEntity.status(HttpStatus.OK).body(this.viajeService.conectarUsuario(id));
	        }catch (Exception e){
	            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error. Usuario inexistente");
	        }
	        
	  }

	  @Operation(summary = "Alta viaje.", description = " Da de alta un viaje ")
    @PostMapping("")
    public ResponseEntity<?> save( @RequestBody @Validated ViajeRequestDto request ){
        try {
        	return ResponseEntity.status(HttpStatus.OK).body(this.viajeService.save(request));
        }catch(Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body("Ocurrio un error, revise los campos ingresados");
        }
    }
  
	@Operation(summary = "Eliminar viaje.", description = " Elimina un viaje de acuerdo a su Id")
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        try{
            this.viajeService.delete(id);
            return ResponseEntity.status(HttpStatus.OK).body("Se elimino correctamente el viaje con el id: " + id);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error. No se pudo eliminar el viaje con id: " + id);
        }
    }
    
	 @Operation(summary = "Update viaje.", description = " Modifica  un viaje ")
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody @Validated ViajeRequestDto request) {
        try {
            Viaje viaje = this.viajeService.update(id, request);
            ViajeResponseDto response = new ViajeResponseDto(viaje);
         
            return ResponseEntity.status(HttpStatus.OK).body(response);
          
        } catch (Exception e) {
        	return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se encontró el viaje con el ID proporcionado.");
        }
    }
    
	 @Operation(summary = "Facturación por período.", description = " Detalle de facturación en un período determinado que se pasa "
	 		+ "por parámetros ")
    @GetMapping("/facturacion/{mesInicio}/{mesFin}")
	   public ResponseEntity<?> facturacionEnMeses(@PathVariable Integer mesInicio, @PathVariable Integer mesFin){
	        try{
	            return ResponseEntity.status(HttpStatus.OK).body(this.viajeService.facturacionEnMeses(mesInicio, mesFin));
	        }catch (Exception e){
	            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error. Facturacioon inexistente");
	        }
	        
	  }
	

}
