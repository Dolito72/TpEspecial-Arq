package com.integrador.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.integrador.domain.Parada;

@Repository
public interface ParadaRepository extends JpaRepository<Parada, Long>{

}
