package com.integrador.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.integrador.domain.Viaje;

@Repository
public interface ViajeRepository extends JpaRepository<Viaje, Long>{
	
	@Query(value = "SELECT SUM(v.costo) FROM viaje v WHERE v.fin_viaje BETWEEN CONCAT('2023-', :mesInicio, '-01') AND CONCAT('2023-', :mesFin, '-31')", nativeQuery = true)
	public double facturacion(@Param("mesInicio") Integer mesInicio, @Param("mesFin") Integer mesFin);


}
