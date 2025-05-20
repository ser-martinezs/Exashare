package com.exashare.Exashare.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.exashare.Exashare.model.Arriendo;
import com.exashare.Exashare.model.Usuario;

import java.util.List;

@Repository
public interface ArriendoRepository extends JpaRepository<Arriendo, Long> {
//Primera consulta para buscar todos los arriendos
    @Query
    (value=" SELECT * FROM ARRIENDO",nativeQuery =  true)
    List<Object[]> findallarriendos();

    //Para buscar por id
    @Query(value = "SELECT * FROM arriendo WHERE idArriendo = :idArriendo", nativeQuery = true)
    List<Usuario> findByidArriendo(@Param("idArriendo") Integer idArriendo);
    
}
