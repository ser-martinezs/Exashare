package com.exashare.Exashare.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.exashare.Exashare.model.Herramienta;

@Repository
public interface HerramientaRepository extends JpaRepository<Herramienta,Long> {
    
}
