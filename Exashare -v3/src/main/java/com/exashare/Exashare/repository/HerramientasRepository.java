package com.exashare.Exashare.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.exashare.Exashare.model.Herramientas;
import org.springframework.stereotype.Repository;

@Repository
public interface HerramientasRepository extends JpaRepository<Herramientas, Long>{

    
}
