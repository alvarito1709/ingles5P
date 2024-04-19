package com.agencia.inglesIT.entities;


import javax.persistence.*;

@Entity
public class Respuesta {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer nivel;

    private String cuerpoRespuesta;

    private String tipo;

    private Boolean respuestaCorrecta;

    @ManyToOne
    @JoinColumn(name = "pregunta_id")
   private Pregunta pregunta;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getNivel() {
        return nivel;
    }

    public void setNivel(Integer nivel) {
        this.nivel = nivel;
    }

    public String getCuerpoRespuesta() {
        return cuerpoRespuesta;
    }

    public void setCuerpoRespuesta(String cuerpoRespuesta) {
        this.cuerpoRespuesta = cuerpoRespuesta;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Boolean getRespuestaCorrecta() {
        return respuestaCorrecta;
    }

    public void setRespuestaCorrecta(Boolean respuestaCorrecta) {
        this.respuestaCorrecta = respuestaCorrecta;
    }

    public Pregunta getPregunta() {
        return pregunta;
    }

    public Long getPreguntaId(){return pregunta.getId();}

    public void setPregunta(Pregunta pregunta) {this.pregunta = pregunta;}

    public void setPreguntaPorId(Long id){ this.pregunta.setId(id);}
}
