package com.integrador.utils;

import java.sql.Timestamp;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.integrador.domain.GPS;
import com.integrador.domain.Monopatin;
import com.integrador.domain.clases.Usuario;
import com.integrador.repository.MonopatinRepository;
import com.integrador.repository.ParadaRepository;
import com.integrador.repository.ViajeRepository;
import com.integrador.service.MonopatinService;
import com.integrador.service.ParadaService;
import com.integrador.service.ViajeService;
import com.integrador.service.dto.monopatin.MonopatinRequestDto;
import com.integrador.service.dto.parada.ParadaRequestDto;
import com.integrador.service.dto.viaje.ViajeRequestDto;

@Configuration
public class LoadDataBase {
	
	Logger log = LoggerFactory.getLogger(LoadDataBase.class);
	
	@Bean
	CommandLineRunner initDatabase(MonopatinRepository  monopatinRepository, ParadaRepository paradaRepository, ViajeRepository viajeRepository) {
		return args -> {
			
			GPS gps1 = new GPS(-37.327216,-59.130739);//parada
			GPS gps2 = new GPS(-37.327120,-59.141542);//parada
			GPS gps3 = new GPS(-37.327120,-59.146741);//parada
			GPS gps4 = new GPS(-37.327120,-59.146721);//parada
			GPS gps5 = new GPS(-37.326980,-59.134482);//disponible
			GPS gps6 = new GPS(-37.334679,-59.134704);//disponible
			GPS gps7 = new GPS(-37.334459,-59.134562);//mantenimiento
			
			//GPS ubicacion, String estado, boolean disponible, double kmsRecorridos, double kmsMantenimiento, Long tiempoUsoTotal, Long tiempoPausado, Long cantidadViajes
			MonopatinRequestDto mr1 = new MonopatinRequestDto(gps1, "disponible", true, 210.5, 70.3, 18000, 1800, 4);
			MonopatinRequestDto mr2 = new MonopatinRequestDto(gps5, "en uso", true, 180.5, 89, 25000, 2800, 5);
			MonopatinRequestDto mr3 = new MonopatinRequestDto(gps3, "disponible", true, 220, 50, 19000, 800, 2);
			MonopatinRequestDto mr4 = new MonopatinRequestDto(gps7, "en mantenimiento", false, 210.5, 70.3, 120000, 2700, 7);
			MonopatinRequestDto mr5 = new MonopatinRequestDto(gps6, "en uso", true, 142, 64, 18500, 600, 3);
			MonopatinRequestDto mr6 = new MonopatinRequestDto(gps3, "disponible", true, 263, 48, 15250, 1700, 4);
			MonopatinRequestDto mr7 = new MonopatinRequestDto(gps7, "en mantenimiento", false, 300, 20, 18000, 1800, 9);
			MonopatinRequestDto mr8 = new MonopatinRequestDto(gps1, "disponible", true, 189, 79, 70000, 4000, 6);
			MonopatinRequestDto mr9 = new MonopatinRequestDto(gps3, "disponible", true, 420, 91, 210000, 3521, 11);
			MonopatinRequestDto mr10 = new MonopatinRequestDto(gps3, "disponible", true, 189, 79, 189420, 2010, 8);
			
			MonopatinService ms = new MonopatinService (monopatinRepository);
			
//			ms.save(mr1);
//			ms.save(mr2);
//			ms.save(mr3);
//			ms.save(mr4);
//			ms.save(mr5);
//			ms.save(mr6);
//			ms.save(mr7);
//			ms.save(mr8);
//			ms.save(mr9);
//			ms.save(mr10);
			
			ParadaRequestDto pr1 = new ParadaRequestDto("parada 1", gps1);
			ParadaRequestDto pr2 = new ParadaRequestDto("parada 2", gps2);
			ParadaRequestDto pr3 = new ParadaRequestDto("parada 3", gps3);
			ParadaRequestDto pr4 = new ParadaRequestDto("parada 4", gps4);
			
			ParadaService ps = new ParadaService(paradaRepository);

//			ps.save(pr1);
//			ps.save(pr2);
//			ps.save(pr3);
//			ps.save(pr4);
			
			
			Timestamp fechaInicio1 = Timestamp.valueOf("2023-08-24 10:10:10.0");
			Timestamp fechaFin1 = Timestamp.valueOf("2023-08-24 12:07:10.0");
			Timestamp fechaInicio2 = Timestamp.valueOf("2023-07-24 10:10:10.0");
			Timestamp fechaFin2 = Timestamp.valueOf("2023-07-24 12:07:10.0");
			Timestamp fechaInicio3 = Timestamp.valueOf("2023-09-21 10:10:10.0");
			Timestamp fechaFin3 = Timestamp.valueOf("2023-09-21 12:07:10.0");
			Timestamp fechaInicio4 = Timestamp.valueOf("2023-10-05 10:10:10.0");
			Timestamp fechaFin4 = Timestamp.valueOf("2023-10-05 12:07:10.0");
			Timestamp fechaInicio5 = Timestamp.valueOf("2023-10-28 10:10:10.0");
			Timestamp fechaFin5 = Timestamp.valueOf("2023-10-28 19:07:10.0");
			Timestamp fechaInicio6 = Timestamp.valueOf("2023-10-27 09:10:10.0");
			Timestamp fechaFin6 = Timestamp.valueOf("2023-10-27 12:07:10.0");
			Timestamp fechaInicio7 = Timestamp.valueOf("2023-10-26 08:30:10.0");
			Timestamp fechaFin7 = Timestamp.valueOf("2023-10-26 17:15:10.0");
			Timestamp fechaInicio8 = Timestamp.valueOf("2023-10-28 08:15:10.0");
			Timestamp fechaFin8 = Timestamp.valueOf("2023-10-28 14:20:10.0");
			Timestamp fechaInicio9 = Timestamp.valueOf("2023-08-12 07:20:10.0");
			Timestamp fechaFin9 = Timestamp.valueOf("2023-08-12 12:30:10.0");
			Timestamp fechaInicio10 = Timestamp.valueOf("2023-10-13 09:20:10.0");
			Timestamp fechaFin10 = Timestamp.valueOf("2023-10-13 11:30:10.0");
			Timestamp fechaInicio11 = Timestamp.valueOf("2023-09-11 12:10:10.0");
			Timestamp fechaFin11 = Timestamp.valueOf("2023-09-11 16:07:10.0");
					
			

			//Date inicioViaje, Date finViaje, double costo, Long monopatinId, Long cuentaId, Long usuarioId, Long paradaFinalId, double kmsRecorridos, Long tiempoPausa, boolean pausaActiva
			ViajeRequestDto vr1 = new ViajeRequestDto(fechaInicio1, fechaFin1, 100, (long)1, (long)1, (long)1, (long)1, 10, 300, true);
			ViajeRequestDto vr2 = new ViajeRequestDto(fechaInicio2, fechaFin2, 120, (long)2, (long)2, (long)1, (long)2, 7, 400, true);
			ViajeRequestDto vr3 = new ViajeRequestDto(fechaInicio3, fechaFin3, 90, (long)3, (long)1, (long)2, (long)3, 12, 450, true);
			ViajeRequestDto vr4 = new ViajeRequestDto(fechaInicio4, fechaFin4, 135,(long)4, (long)3, (long)3, (long)4, 3, 550, false);
			ViajeRequestDto vr5 = new ViajeRequestDto(fechaInicio5, fechaFin5, 250, (long)5, (long)5, (long)4, (long)1, 8, 520, true);
			ViajeRequestDto vr6 = new ViajeRequestDto(fechaInicio6, fechaFin6, 240, (long)6, (long)5, (long)5, (long)2, 5, 600, false);
			ViajeRequestDto vr7 = new ViajeRequestDto(fechaInicio7, fechaFin7, 168, (long)7, (long)6, (long)6, (long)3, 9, 730, true);
			ViajeRequestDto vr8 = new ViajeRequestDto(fechaInicio8, fechaFin8, 462, (long)8, (long)4, (long)3, (long)4, 4, 420, false);
			ViajeRequestDto vr9 = new ViajeRequestDto(fechaInicio9, fechaFin9, 264, (long)9, (long)1, (long)1, (long)1, 7, 620, true);
			ViajeRequestDto vr10 = new ViajeRequestDto(fechaInicio10, fechaFin10, 320, (long)10, (long)2, (long)1, (long)2, 13, 420, true);
	
			ViajeService vs = new ViajeService(viajeRepository, monopatinRepository, paradaRepository);
			
//			vs.save(vr1);
//			vs.save(vr2);
//			vs.save(vr3);
//			vs.save(vr4);
//			vs.save(vr5);
//			vs.save(vr6);
//			vs.save(vr7);
//			vs.save(vr8);
//			vs.save(vr9);
//			vs.save(vr10);
			
			
		};
	}
}
