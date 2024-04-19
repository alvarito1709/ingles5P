package com.agencia.inglesIT.repository;


import com.agencia.inglesIT.entities.Apartado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ApartadoRepository extends JpaRepository <Apartado, String> {

    List<Apartado> findByNivel(Integer nivel);


    @Query(value = "SELECT r " + "FROM Apartado r " +
            "WHERE r.nombreApartado  =" + " :apartado " + "AND r.nivel = " + ":nivel")
    Apartado findByApartadoYNivel(String apartado, Integer nivel);
}
