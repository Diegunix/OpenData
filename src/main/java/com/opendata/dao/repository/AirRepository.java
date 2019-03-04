package com.opendata.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.opendata.dao.domain.Air;

public interface AirRepository extends JpaRepository<Air, Long> {
}
