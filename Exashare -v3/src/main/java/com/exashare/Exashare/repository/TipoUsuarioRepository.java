package com.exashare.Exashare.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.exashare.Exashare.model.TipoUsuario;

@Repository
public interface TipoUsuarioRepository extends JpaRepository<TipoUsuario, Long> {
 
}
