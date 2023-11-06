package com.integrador.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.integrador.domain.Tarifa;

public interface TarifaRepository extends JpaRepository<Tarifa, Long> {
	

}
