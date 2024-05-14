package com.agencia.inglesIT.controller;

import com.agencia.inglesIT.entities.Apartado;
import com.agencia.inglesIT.entities.Pregunta;
import com.agencia.inglesIT.entities.Respuesta;
import com.agencia.inglesIT.repository.ApartadoRepository;
import com.agencia.inglesIT.repository.PreguntaRepository;
import com.agencia.inglesIT.repository.RespuestaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/test")
public class testController {

    @Autowired
    PreguntaRepository preguntaRepo;

    @Autowired
    ApartadoRepository apartadoRepository;

    @Autowired
    RespuestaRepository respuestaRepository;

    @GetMapping("/level1")
    String level1(){
        return "testDisplay";
    }

    @PostMapping("/level")
    ModelAndView level( Model model,
            @RequestParam(value = "prueba") String prueba,
                        @RequestParam(value = "level", required = false) Integer level,
                        @RequestParam(value = "apartado", required = false) String apartado
    ){
        model.addAttribute("prueba", prueba);


        model.addAttribute("apartadoUsado", apartado);

        //List<Pregunta> preguntas = preguntaRepo.findPreguntaByApartadoYNivel(level, apartadoUsado.getId());

        //model.addAttribute("preguntas", preguntas);

        //List<Respuesta> respuestas = respuestaRepository.findRespuestaByNivel(level);

       // model.addAttribute("respuestas" , respuestas);



    return new ModelAndView("testDisplay :: test");
    }

    @GetMapping("/init")
    public void projectInit(){



    }
}
