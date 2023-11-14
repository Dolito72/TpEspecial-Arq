package com.integrador.controller;


import lombok.RequiredArgsConstructor;
import lombok.var;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import com.integrador.domain.Monopatin;
import com.integrador.domain.Tarifa;
import com.integrador.service.*;
import com.integrador.service.dto.administrador.AdministradorRequestDto;
import com.integrador.service.dto.administrador.AdministradorResponseDto;
import com.integrador.service.dto.monopatin.MonopatinRequestDto;
import com.integrador.service.dto.monopatin.MonopatinesCantidadResponseDto;
import com.integrador.service.dto.monopatinConViajes.MonopatinConViajesResponseDto;
import com.integrador.service.dto.parada.ParadaRequestDto;
import com.integrador.service.dto.tarifa.TarifaRequestDto;
import com.integrador.service.dto.tarifa.TarifaResponseDto;
import io.swagger.v3.oas.annotations.Operation;
import com.integrador.domain.Administrador;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("api/administrador")
public class AdministradorController {
	
	@Autowired
    private AdministradorService administradorService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView method() {
	    return new ModelAndView("redirect:/swagger-ui.html");
	}
	
	@Operation(summary = "Obtiene un administrador por su ID", description = "Devuelve un administrador basado en su ID.")
    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(administradorService.findById(id));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error. Administrador inexistente");
        }

    }
	
	@Operation(summary = "Obtiene todos los administradores", description = "Devuelve todos los administradores.")
    @GetMapping("")
	public List<AdministradorResponseDto> findAll(){
        return this.administradorService.findAll();
    }
    
  
    @Operation(summary = "Alta administrador", description = "Da de alta un administrador.")
    @PostMapping("")
    public ResponseEntity<?> save (@RequestBody @Validated AdministradorRequestDto request) {
	    try {
	    	return ResponseEntity.status(HttpStatus.OK).body(administradorService.save(request));
	    }catch(Exception e) {
	    	return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body("Ocurrio un error, revise los campos ingresados");
	    } 
	}   
  
    @Operation(summary = "Update administrador", description = "Modifica un administrador.")
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody @Validated AdministradorRequestDto request) {
        try {
            Administrador adm = administradorService.update(id, request);
            AdministradorResponseDto response = new AdministradorResponseDto(adm);

            return ResponseEntity.status(HttpStatus.OK).body(response);
          
        } catch (Exception e) {
        	return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se encontró el administrador con el ID proporcionado.");
        }
    }
    

    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar administrador", description = "Elimina  un administrador por su Id.")
    public ResponseEntity<?> delete(@PathVariable Long id){
        try{
            this.administradorService.delete(id);
            return ResponseEntity.status(HttpStatus.OK).body("Se elimino correctamente administrador con el id: " + id);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error. No se pudo eliminar el administrador con id: " + id);
        }
    }
    
    //agregar monopatin
    @Operation(summary = "Da de alta un nuevo monopatin.", description = "Se comunica con el microservicios de monopatines para dar de alta un nuevo monopatin.")
    @PostMapping("/agregarMonopatin")
    public ResponseEntity<?> agregarMonopatin (@RequestBody @Validated Monopatin request) {
	    try {
	    	return ResponseEntity.status(HttpStatus.OK).body(administradorService.agregarMonopatin(request));
	    }catch(Exception e) {
	    	return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body("Ocurrio un error, revise los campos ingresados");
	    } 
	}  
    
    @Operation(summary = "Eliminar monopatin.", description = "Se comunica con el microservicios de monopatines para "
    		+ "eliminar un monopatin.")
    @DeleteMapping("/eliminarMonopatin/{idMonopatin}")
    public ResponseEntity<?> quitarMonopatin(@PathVariable Long idMonopatin){
        try{
            this.administradorService.quitarMonopatin(idMonopatin);
            return ResponseEntity.status(HttpStatus.OK).body("Se elimino correctamente monopatin con el id: " + idMonopatin);
        }catch (Exception e){
        	e.printStackTrace();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error. No se pudo eliminar el monopatin con id: " + idMonopatin);
        }
    }
    
    
    //trae los monopatines con mas de tantos km
    @Operation(summary = "Monopatines por Km.", description = "Se comunica con el microservicios de monopatines"
    		+ " para traerme los monopatines por Km.")
    @GetMapping("/monopatines/porKm/{cantKm}")
    public ResponseEntity<?> getMonopatinesPorKm(@PathVariable Long cantKm){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(administradorService.getMonopatinesPorKm(cantKm));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error. No se encontraron monopatines");
        }

    }
    
  //trae los monopatines con mas de tanto tiempo, sin contar pausas
    @Operation(summary = "Monopatines por cant. de Km sin pausa.", description = "Se comunica con el microservicios de monopatines para "
    		+ " traerme los monopatines por tiempo sin pausa.")
    @GetMapping("/monopatines/porTiempoSinPausa/{cantKm}")
    public ResponseEntity<?> getMonopatinesPorTiempoSinPausa(@PathVariable Long cantKm){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(administradorService.getMonopatinesPorTiempoSinPausa(cantKm));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error. No se encontraron monopatines");
        }

    }
    
  //trae los monopatines con mas de tanto tiempo, conn contar pausas
    @Operation(summary = "Monopatines por cant. de Km con pausa.", description = "Se comunica con el microservicios de monopatines para "
    		+ " traerme los monopatines por tiempo con pausa.")
    @GetMapping("/monopatines/porTiempoConPausa/{cantKm}")
    public ResponseEntity<?> getMonopatinesPorTiempoConPausa(@PathVariable Long cantKm){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(administradorService.getMonopatinesPorTiempoConPausa(cantKm));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error. No se encontraron monopatines");
        }

    }
    
  //consultar los monopatines con más de X viajes en un cierto año
    @Operation(summary = "Monopatines por cantidad de viajes de un determinado año.", description = "Se comunica "
    		+ "con el microservicios de monopatines para "
    		+ " traerme la cantidad de viajes de cada monopatín en un año determinado.")
    @GetMapping("/monopatines/conViajes/{cantViajes}/{anio}")
    public ResponseEntity<?> getMonopatinesConViajes(@PathVariable Long cantViajes, @PathVariable Integer anio){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(administradorService.getMonopatinesConViajes(cantViajes, anio));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error. No se encontraron monopatines");
        }

    }
    
    
    //consultar los monopatines en operacion y en mantenimiento
    @Operation(summary = "Monopatines en operación y en mantenimiento.", description = "Se comunica con el microservicios de monopatines para "
    		+ " traerme la cantidad de monopatines en operacion y los que estan en mantenimiento.")
    @GetMapping("/monopatines/enOperacionMantenimiento")
    public ResponseEntity<?> getMonopatinesOperacionMantenimiento(){
    	try{
            return ResponseEntity.status(HttpStatus.OK).body(administradorService.getMonopatinesOperacionMantenimiento());
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error. No se encontraron monopatines");
        }

    }
    
    //crear un parada
    @Operation(summary = "Alta parada.", description = "Se comunica con el microservicios de paradas para "
    		+ " dar de alta una parada.")
    @PostMapping("/paradas/agregarParada")
    public ResponseEntity<?> agregarParada (@RequestBody @Validated ParadaRequestDto request) {
	    try {
	    	return ResponseEntity.status(HttpStatus.OK).body(administradorService.agregarParada(request));
	    }catch(Exception e) {
	    	return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body("Ocurrio un error, revise los campos ingresados");
	    } 
	}  
    
    
    //quitar una parada
    @Operation(summary = "Eliminar parada.", description = "Se comunica con el microservicios de paradas para "
    		+ " eliminar una parada.")
    @DeleteMapping("/paradas/quitarParada/{idParada}")
    public ResponseEntity<?> eliminarParada (@PathVariable Long idParada){
        try{
            this.administradorService.eliminarParada(idParada);
            return ResponseEntity.status(HttpStatus.OK).body("Se elimino correctamente parada con el id: " + idParada);
        }catch (Exception e){
        	e.printStackTrace();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error. Ya se elimino la parada con id: " + idParada);
        }
    }
    
    //anular cuenta
    @Operation(summary = "Anular cuenta", description = "Se comunica con el microservicios de cuentas para "
    		+ " anularla.")
    @PutMapping("/cuentas/anularCuenta/{idCuenta}")
    public ResponseEntity<?> anularCuenta(@PathVariable Long idCuenta) {
        try {
        	System.out.println("hola controller");
            return ResponseEntity.status(HttpStatus.OK).body(administradorService.anularCuenta(idCuenta));
          
        } catch (Exception e) {
        	return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se encontró la cuenta con el ID proporcionado.");
        }
    }
    
    //modificar tarifa
    @Operation(summary = "Modificar tarifa.", description = " Se cambia el precio de las tarifas.")
    @PutMapping("/modificarTarifaEnFecha")
    public ResponseEntity<?> ModificarTarifaEnFecha (@RequestBody @Validated TarifaRequestDto request) {
        try {
            Tarifa tarifa = administradorService.updateTarifa(request);
            TarifaResponseDto response = new TarifaResponseDto(tarifa);

            return ResponseEntity.status(HttpStatus.OK).body(response);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Aun falta para la fecha de entrada en vigencia");

        }

    }
    
  //definir una tarifa, paso el id y precio que quiero definir
    @Operation(summary = "Definir tarifa camún.", description = " Se da de alta el precio de la tarifa común.")
  	@PutMapping("/definirTarifaComun/{id}/{precio}")
      public ResponseEntity<?> definirTarifaComun (@PathVariable Long id, @PathVariable double precio) {
  	    try {
  	    	return ResponseEntity.status(HttpStatus.OK).body(administradorService.definirTarifaComun(id, precio));
  	    }catch(Exception e) {
  	    	return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body("Ocurrio un error, revise los campos ingresados");
  	    } 
  	}   
  	
  	//definir una tarifa, paso el id y precio que quiero definir para la tarifa especial
    	@Operation(summary = "Definir tarifa especial.", description = " Se da de alta el precio de la tarifa especial.")
  		@PutMapping("/definirTarifaEspecial/{id}/{precio}")
  	    public ResponseEntity<?> definirTarifaEspecial (@PathVariable Long id, @PathVariable double precio) {
  		    try {
  		    	return ResponseEntity.status(HttpStatus.OK).body(administradorService.definirTarifaEspecial(id, precio));
  		    }catch(Exception e) {
  		    	return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body("Ocurrio un error, revise los campos ingresados");
  		    } 
  		}  
  		
  		//conocer la facturacion entre ciertos meses que vienen por parametro
    	  @Operation(summary = "Facturación en un período determinado.", description = " Se comunica con el microservicios viajes "
    	  		+ "para obtener un detalle de lo facturado en un período determinado que se solicita por parámetro.")
  		@GetMapping("/facturacion/{mesInicio}/{mesFin}")
 	   public ResponseEntity<?> facturacionEnMeses(@PathVariable Integer mesInicio, @PathVariable Integer mesFin){
 	        try{
 	            return ResponseEntity.status(HttpStatus.OK).body(this.administradorService.facturacionEnMeses(mesInicio, mesFin));
 	        }catch (Exception e){
 	            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error. Facturacioon inexistente");
 	        }
 	        
 	  }
}
