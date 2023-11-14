package com.integrador.repository;

import com.integrador.domain.Administrador;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;


@Repository

public interface AdministradorRepository extends JpaRepository<Administrador,Long> {

}
