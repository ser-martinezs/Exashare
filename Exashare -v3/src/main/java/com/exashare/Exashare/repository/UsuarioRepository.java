package com.exashare.Exashare.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.exashare.Exashare.model.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long>{


}
