package com.suprab.modules.corpoFilosofico.repository;

import com.suprab.modules.corpoFilosofico.entity.CorpoFilosofico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CorpoFilosoficoRepository extends JpaRepository<CorpoFilosofico, Long> {
}
