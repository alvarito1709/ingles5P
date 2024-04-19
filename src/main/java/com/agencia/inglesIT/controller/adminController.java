package com.agencia.inglesIT.controller;


import com.agencia.inglesIT.Service.RespuestaService;
import com.agencia.inglesIT.entities.Apartado;
import com.agencia.inglesIT.entities.Pregunta;
import com.agencia.inglesIT.entities.Respuesta;
import com.agencia.inglesIT.repository.ApartadoRepository;
import com.agencia.inglesIT.repository.PreguntaRepository;

import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.swing.text.html.Option;
import javax.transaction.Transactional;
import java.net.URI;
import java.util.List;
import java.util.Optional;
import java.util.regex.Pattern;

import static org.springframework.core.io.buffer.DataBufferUtils.matcher;

@Controller
@RequestMapping("/admin")
public class adminController {

    @Autowired
    PreguntaRepository preguntaRepo;

    @Autowired
    ApartadoRepository apartadoRepo;

    @Autowired
    RespuestaService respuestaService;

    @GetMapping("/agregarRespuesta")
    String agregarRespuesta(){
        return "crearRespuestas";
    }

    @PostMapping("/filtrarPreguntas")
    ModelAndView filtrarPreguntas(@RequestParam(value = "level") Integer level,
                                  @RequestParam(value = "apartado") String apartado,
                                  @RequestParam(value = "modelo") String modelo,
                                  Model model){

       try {
            Apartado getApartado = apartadoRepo.findByApartadoYNivel(apartado, level);

            List<Pregunta> listaPreguntas = preguntaRepo.findPreguntaByApartadoYNivel(level, getApartado.getId());

             model.addAttribute("preguntas", listaPreguntas);
        } catch (Exception e){
           System.out.print("Error" + e);
       }

        return new ModelAndView("crearRespuestas ::"+modelo);

    }

    @PostMapping("/filtrarRespuestas")
    ModelAndView filtrarRespuestas(@RequestParam(value = "dato") Long pregunta,
                                  @RequestParam(value = "modelo") String modelo,
                                  Model model){

        try {
           List<Respuesta> respuestas = respuestaService.buscarRespuestasPorPregunta(pregunta);
           model.addAttribute("respuestas", respuestas);
        } catch (Exception e){
            System.out.print("Error" + e);
        }

        return new ModelAndView("crearRespuestas ::"+modelo);

    }

    @PostMapping("/buscarRespuesta")
    ModelAndView buscarRespuesta(@RequestParam(value = "dato") Long respuestaId, Model model) {

        ModelAndView modelAndView = null;
        try {
            Respuesta cuerpoRespuesta = respuestaService.buscarRespuestaPorId(respuestaId);
            modelAndView = new ModelAndView("crearRespuestas:: datosDinamicos");
            modelAndView.addObject("respuestaEdit", cuerpoRespuesta);

        } catch (Exception e) {
            System.out.print("Error" + e);
        }

        return modelAndView;
    }


    @PostMapping("/submitRespuesta")
   public ResponseEntity<Respuesta> submitRespuesta( @RequestBody Respuesta respuesta){

        Optional<Pregunta> preguntaOptional = Optional.ofNullable(preguntaRepo.findById(respuesta.getPregunta().getId()));

        if (!preguntaOptional.isPresent()){
            return ResponseEntity.unprocessableEntity().build();
        }

       respuesta.setPregunta(preguntaOptional.get());
        Respuesta respuestaGuardada = respuestaService.crearRespuesta(respuesta);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("{/id}").buildAndExpand(respuestaGuardada.getId()).toUri();

        return ResponseEntity.created(uri).body(respuestaGuardada);
    }


    @PutMapping("/editarRespuesta/{id}")
    @Transactional
    public ResponseEntity<Respuesta> editAnswer(@PathVariable Long id ,@RequestBody Respuesta respuesta){

        Optional<Pregunta> preguntaOptional = Optional.ofNullable(respuestaService.buscarPreguntaPorRespuestaId(id));

        if (!preguntaOptional.isPresent()){
            return ResponseEntity.unprocessableEntity().build();
        }

        Optional<Respuesta> respuestaOptional = Optional.ofNullable(respuestaService.buscarRespuestaPorId(id));

        if (!respuestaOptional.isPresent()){
            return ResponseEntity.unprocessableEntity().build();
        }

        respuesta.setPregunta(preguntaOptional.get());
        respuesta.setId(respuestaOptional.get().getId());
        respuestaService.editarRespuesta(respuesta);
        return ResponseEntity.noContent().build();
    }


    @DeleteMapping("/borrarRespuesta/{id}")
    @Transactional
    public ResponseEntity borrarRespuesta(@PathVariable Long id){

        try{
            respuestaService.borrarRespuesta(id);
            return ResponseEntity.noContent().build();
        }catch (Exception e ){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("ERROR AL ELIMINAR LA RESPUESTA");
        }

    }
}
