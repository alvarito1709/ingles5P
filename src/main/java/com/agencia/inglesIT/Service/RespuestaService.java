package com.agencia.inglesIT.Service;

import com.agencia.inglesIT.entities.Pregunta;
import com.agencia.inglesIT.entities.Respuesta;
import com.agencia.inglesIT.repository.PreguntaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.agencia.inglesIT.repository.RespuestaRepository;

import javax.transaction.Transactional;
import java.util.List;



@Service
@Transactional
public class RespuestaService {

    @Autowired
    private PreguntaRepository preguntaRepository;

    private final RespuestaRepository respuestaRepository;
    @Autowired
    public RespuestaService(RespuestaRepository respuestaRepository) {
        this.respuestaRepository = respuestaRepository;
    }

   public Respuesta buscarRespuestaPorId(Long id){return respuestaRepository.findRespuestaById(id);}

    public Respuesta crearRespuesta(Respuesta respuesta){return respuestaRepository.save(respuesta);}

    public List<Respuesta> buscarRespuestasPorPregunta(Long id){return respuestaRepository.findRespuestaByPreguntaId(id);}

    public Respuesta editarRespuesta(Respuesta respuesta){
       return respuestaRepository.save(respuesta);
    }

    public void borrarRespuesta(Long id){
        respuestaRepository.deleteById(id);
    }

    public Pregunta buscarPreguntaPorRespuestaId(Long id){
        Pregunta pregunta = buscarRespuestaPorId(id).getPregunta();
        return pregunta;
    }

}
