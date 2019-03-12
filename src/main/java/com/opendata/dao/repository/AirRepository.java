package com.opendata.dao.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.opendata.dao.domain.Air;
import com.opendata.dao.domain.Estacion;

public interface AirRepository extends JpaRepository<Air, Long> {
    
    List<Air> findAllByEstacionAndAnoAndMesAndDia(Estacion estacion, int ano, int mes , int dia);
    
    List<Air> findAllByAnoAndMesAndDia(int ano, int mes , int dia);
    
}