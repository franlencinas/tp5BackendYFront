package com.utn.main.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.utn.main.entidades.Instrumentos;

public interface InstrumentoRepository extends JpaRepository<Instrumentos, Integer> {

}
