package com.integrador.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.integrador.domain.Cuenta;
import com.integrador.domain.Usuario;

@Repository
public interface CuentaRepository extends JpaRepository<Cuenta, Long>{

}
