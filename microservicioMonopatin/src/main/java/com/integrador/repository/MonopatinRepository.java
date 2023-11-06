package com.integrador.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import com.integrador.domain.GPS;
import com.integrador.domain.Monopatin;
import com.integrador.service.dto.monopatin.MonopatinResponseDto;
import com.integrador.service.dto.monopatin.MonopatinesCantidadResponseDto;
import com.integrador.service.dto.monopatin.MonopatinesCercaResponseDto;
import com.integrador.service.dto.monopatinConViajes.MonopatinConViajesResponseDto;

	@Repository
	public interface MonopatinRepository extends JpaRepository<Monopatin, Long>{
		
		
		@Query("SELECT m FROM Monopatin m WHERE m.kmsRecorridos >= :cantKm ORDER BY m.kmsRecorridos DESC")
		public List<MonopatinResponseDto> getMonopatinesPorKm(Long cantKm);
		
		@Query("SELECT m FROM Monopatin m WHERE m.tiempoUsoTotal >= :cantTiempo ORDER BY m.tiempoUsoTotal DESC")
		public List<MonopatinResponseDto> getMonopatinesPorTiempoSinPausa(Long cantTiempo);
		
		
		@Query("SELECT m FROM Monopatin m GROUP BY m.id HAVING SUM(m.tiempoUsoTotal + m.tiempoPausado) >= :cantTiempo ORDER BY m.kmsRecorridos DESC")
		public List<MonopatinResponseDto> getMonopatinesPorTiempoConPausa(Long cantTiempo);
		
		                                                                                       //Long id, GPS ubicacion, String estado, boolean disponible,double kmsRecorridos, double kmsMant, Long cantidadViajes, Date finViaje
		@Query("SELECT new com.integrador.service.dto.monopatinConViajes.MonopatinConViajesResponseDto(m.id, m.ubicacion, m.estado, m.disponible, m.kmsRecorridos, m.kmsMant, m.cantidadViajes, v.finViaje) FROM Viaje v JOIN Monopatin m ON v.monopatin.id = m.id WHERE EXTRACT(YEAR FROM v.finViaje) = :anio AND m.cantidadViajes > :cantViajes ORDER BY m.cantidadViajes ASC")	
		public List<MonopatinConViajesResponseDto> getMonopatinesConViajes(Long cantViajes, Integer anio);

		
		@Query("SELECT new com.integrador.service.dto.monopatin.MonopatinesCantidadResponseDto(SUM(CASE WHEN m.disponible = true THEN 1 ELSE 0 END) AS cantEnOperacion, SUM(CASE WHEN m.disponible = false THEN 1 ELSE 0 END) AS cantEnMantenimiento) FROM Monopatin m")
		public MonopatinesCantidadResponseDto getMonopatinesEnOperacionMantenimiento();
		
		@Query("SELECT new com.integrador.service.dto.monopatin.MonopatinesCercaResponseDto (m.id, m.ubicacion.latitud, m.ubicacion.longitud) FROM Monopatin m WHERE ST_DISTANCE( POINT(:latitud, :longitud), POINT(m.ubicacion.latitud, m.ubicacion.longitud) ) <= 50")
		public List<MonopatinesCercaResponseDto> getMonopatinesCerca(double latitud, double longitud);
		
	}
	
	