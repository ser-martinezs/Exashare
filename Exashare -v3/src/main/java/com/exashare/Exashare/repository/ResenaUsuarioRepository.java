package com.exashare.Exashare.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.exashare.Exashare.model.ResenaUsuario;

@Repository
public interface ResenaUsuarioRepository extends JpaRepository<ResenaUsuario, Long>{

}
