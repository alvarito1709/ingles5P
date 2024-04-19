package com.agencia.inglesIT.repository;


import com.agencia.inglesIT.entities.Respuesta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RespuestaRepository extends JpaRepository <Respuesta, String> {
    List<Respuesta> findRespuestaByNivel(Integer nivel);

    @Query(value = "SELECT r " + "FROM Respuesta r " +
            "WHERE r.pregunta.id = " + ":pregunta")
    List<Respuesta> findRespuestaByPreguntaId(Long pregunta);

    Respuesta findRespuestaById(Long id);

    void deleteById(Long id);


}
