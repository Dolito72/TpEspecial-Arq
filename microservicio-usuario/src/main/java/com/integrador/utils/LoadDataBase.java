package com.integrador.utils;

import java.sql.Timestamp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.integrador.domain.Cuenta;
import com.integrador.domain.Usuario;
import com.integrador.repository.CuentaRepository;
import com.integrador.repository.UsuarioRepository;
import com.integrador.service.CuentaService;
import com.integrador.service.UsuarioService;
import com.integrador.service.dto.cuenta.CuentaRequestDto;
import com.integrador.service.dto.usuario.UsuarioRequestDto;
import com.integrador.service.dto.usuarioCuenta.UsuarioCuentaRequestDto;

@Configuration
public class LoadDataBase {
	

	Logger log = LoggerFactory.getLogger(LoadDataBase.class);

	@Bean
	CommandLineRunner initDatabase(UsuarioRepository usuarioRepository, CuentaRepository cuentaRepository) {
		return args -> {
			
			UsuarioRequestDto ur1 = new UsuarioRequestDto("Gustavo", "Lopez", "2494352789", "gustavolopez@gmail.com");
			UsuarioRequestDto ur2 = new UsuarioRequestDto("Pedro", "Perez", "2494271078", "pedroperez@gmail.com");
			UsuarioRequestDto ur3 = new UsuarioRequestDto("Marcelo", "Rodriguez", "2494247492", "marcelorodriguez@gmail.com");
			UsuarioRequestDto ur4 = new UsuarioRequestDto("Julieta", "Martinez", "2494964521", "julietamartinez@gmail.com");
			UsuarioRequestDto ur5 = new UsuarioRequestDto("Pamela", "Benitez", "2494957934", "pamelabenitez@gmail.com");
			UsuarioRequestDto ur6 = new UsuarioRequestDto("Tomás", "Rupero", "2494957934", "tomasrupero@gmail.com");
			UsuarioRequestDto ur7 = new UsuarioRequestDto("Lucia", "Torino", "2494957934", "luciatorino@gmail.com");
			
			UsuarioService us = new UsuarioService (usuarioRepository, cuentaRepository);
			
			us.save(ur1);
			us.save(ur2);
			us.save(ur3);
			us.save(ur4);
			us.save(ur5);
			us.save(ur6);
			us.save(ur7);
			
			Timestamp fecha1 = Timestamp.valueOf("2023-04-24 10:10:10.0");
			Timestamp fecha2 = Timestamp.valueOf("2023-05-30 10:10:10.0");
			Timestamp fecha3 = Timestamp.valueOf("2023-06-12 10:10:10.0");
			Timestamp fecha4 = Timestamp.valueOf("2023-06-13 10:10:10.0");
			Timestamp fecha5 = Timestamp.valueOf("2023-09-21 10:10:10.0");
			Timestamp fecha6 = Timestamp.valueOf("2023-10-19 10:10:10.0");
			
			CuentaRequestDto cr1 = new CuentaRequestDto(510, fecha1, true);
			CuentaRequestDto cr2 = new CuentaRequestDto(246, fecha2, false);
			CuentaRequestDto cr3 = new CuentaRequestDto(432, fecha3, true);
			CuentaRequestDto cr4 = new CuentaRequestDto(1245, fecha4, false);
			CuentaRequestDto cr5 = new CuentaRequestDto(2465, fecha5, true);
			CuentaRequestDto cr6 = new CuentaRequestDto(7821, fecha6, true);
			
			CuentaService cs = new CuentaService (cuentaRepository);

			cs.save(cr1);
			cs.save(cr2);
			cs.save(cr3);
			cs.save(cr4);
			cs.save(cr5);
			cs.save(cr6);
			
			
			Usuario usuario1 = new Usuario(ur1);
			Usuario usuario2 = new Usuario(ur2);
			Usuario usuario3 = new Usuario(ur3);
			Usuario usuario4 = new Usuario(ur4);
			Usuario usuario5 = new Usuario(ur5);
			Usuario usuario6 = new Usuario(ur6);
			Usuario usuario7 = new Usuario(ur7);
			
			Cuenta cuenta1 = new Cuenta(cr1);
			Cuenta cuenta2 = new Cuenta(cr2);
			Cuenta cuenta3 = new Cuenta(cr3);
			Cuenta cuenta4 = new Cuenta(cr4);
			Cuenta cuenta5 = new Cuenta(cr5);
			Cuenta cuenta6 = new Cuenta(cr6);
			
			
			
			usuario1.insertarCuenta(cuenta1);
			usuario1.insertarCuenta(cuenta2);
			usuario2.insertarCuenta(cuenta2);
			usuario3.insertarCuenta(cuenta3);
			usuario4.insertarCuenta(cuenta5);
			usuario5.insertarCuenta(cuenta5);
			usuario6.insertarCuenta(cuenta6);
			usuario3.insertarCuenta(cuenta4);
			usuario7.insertarCuenta(cuenta6);
			
			

			
		};
	
	}
}
