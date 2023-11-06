package com.integrador.utils;

import java.sql.Timestamp;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.integrador.repository.AdministradorRepository;
import com.integrador.repository.MantenimientoRepository;
import com.integrador.repository.TarifaRepository;
import com.integrador.service.AdministradorService;
import com.integrador.service.MantenimientoService;
import com.integrador.service.TarifaService;
import com.integrador.service.dto.administrador.AdministradorRequestDto;
import com.integrador.service.dto.mantenimiento.MantenimientoRequestDto;
import com.integrador.service.dto.tarifa.TarifaRequestDto;

@Configuration
public class LoadDataBase {
	

	Logger log = LoggerFactory.getLogger(LoadDataBase.class);

	@Bean
	CommandLineRunner initDatabase(AdministradorRepository  administradorRepository, MantenimientoRepository mantenimientoRepository, TarifaRepository tarifaRepository) {
		return args -> {
			
			AdministradorRequestDto adm1 = new AdministradorRequestDto("administrador", "Nicolas Gomez");
			AdministradorRequestDto adm2 = new AdministradorRequestDto("encargado de mantenimiento", "Gabriel Gonzalez");

			AdministradorService as = new AdministradorService(administradorRepository, tarifaRepository);
		
	//		as.save(adm1);
	//		as.save(adm2);
			
			Timestamp fecha1 = Timestamp.valueOf("2023-06-24 10:10:10.0");
			Timestamp fecha2 = Timestamp.valueOf("2023-10-16 12:07:10.0");
		
			TarifaRequestDto tr1 = new TarifaRequestDto(45.25, 60, fecha1);
			TarifaRequestDto tr2 = new TarifaRequestDto(53, 70, fecha2);
			
			TarifaService ts = new TarifaService(tarifaRepository);
//			
//			ts.save(tr1);
//			ts.save(tr2);
//			
			
			Timestamp fechaInicio1 = Timestamp.valueOf("2023-08-24 10:10:10.0");
			Timestamp fechaFin1 = Timestamp.valueOf("2023-08-30 12:07:10.0");
			Timestamp fechaInicio2 = Timestamp.valueOf("2023-07-24 10:10:10.0");
			Timestamp fechaFin2 = Timestamp.valueOf("2023-07-27 12:07:10.0");
			Timestamp fechaInicio3 = Timestamp.valueOf("2023-09-21 10:10:10.0");
			Timestamp fechaFin3 = Timestamp.valueOf("2023-09-30 12:07:10.0");
			Timestamp fechaInicio4 = Timestamp.valueOf("2023-10-05 10:10:10.0");
			Timestamp fechaFin4 = Timestamp.valueOf("2023-10-17 12:07:10.0");
			Timestamp fechaInicio5 = Timestamp.valueOf("2023-10-28 15:10:10.0");
			Timestamp fechaInicio6 = Timestamp.valueOf("2023-10-26 15:10:10.0");
			Timestamp fechaInicio7 = Timestamp.valueOf("2023-10-26 15:10:10.0");
			Timestamp fechaFin7 = Timestamp.valueOf("2023-08-30 12:07:10.0");
			Timestamp fechaInicio8 = Timestamp.valueOf("2023-10-26 15:10:10.0");
			Timestamp fechaFin8 = Timestamp.valueOf("2023-08-30 12:07:10.0");
			Timestamp fechaInicio9 = Timestamp.valueOf("2023-08-12 15:10:10.0");
			Timestamp fechaFin9 = Timestamp.valueOf("2023-08-17 12:07:10.0");
			Timestamp fechaInicio10 = Timestamp.valueOf("2023-10-13 15:10:10.0");
			Timestamp fechaFin10 = Timestamp.valueOf("2023-10-25 12:07:10.0");
			Timestamp fechaInicio11 = Timestamp.valueOf("2023-09-11 15:10:10.0");
			Timestamp fechaFin11 = Timestamp.valueOf("2023-09-14 12:07:10.0");
			
			
			
			//Long idMonopatin, Date fechaHoraInicioMantenimiento, Date fechaHoraFinalizacionMantenimiento, boolean reparado
			MantenimientoRequestDto mr1 = new MantenimientoRequestDto((long) 1, fechaInicio1, fechaFin1, true);
			MantenimientoRequestDto mr2 = new MantenimientoRequestDto((long) 2, fechaInicio3, fechaFin3, true);
			MantenimientoRequestDto mr3 = new MantenimientoRequestDto((long) 3, fechaInicio4, fechaFin4, true);
			MantenimientoRequestDto mr4 = new MantenimientoRequestDto((long) 4, fechaInicio6, null, false);
			MantenimientoRequestDto mr5 = new MantenimientoRequestDto((long) 5, fechaInicio7, fechaFin7, true);
			MantenimientoRequestDto mr6 = new MantenimientoRequestDto((long) 6, fechaInicio8, fechaFin8, true);
			MantenimientoRequestDto mr7 = new MantenimientoRequestDto((long) 7, fechaInicio5, null, false);
			MantenimientoRequestDto mr8 = new MantenimientoRequestDto((long) 8, fechaInicio9, fechaFin9, true);
			MantenimientoRequestDto mr9 = new MantenimientoRequestDto((long) 9, fechaInicio10, fechaFin10, true);
			MantenimientoRequestDto mr10 = new MantenimientoRequestDto((long) 10, fechaInicio11, fechaFin11, true);
			MantenimientoRequestDto mr11 = new MantenimientoRequestDto((long) 7, fechaInicio2, fechaFin2, true);
			
			MantenimientoService ms = new MantenimientoService(mantenimientoRepository);
			
//			ms.save(mr1);
//	    	ms.save(mr2);
//			ms.save(mr3);
//		ms.save(mr4);
//			ms.save(mr5);
//		ms.save(mr6);
//			ms.save(mr7);
//		ms.save(mr8);
//		ms.save(mr9);
//			ms.save(mr10);
//		ms.save(mr11);
//			
			
		};
	}

	
}