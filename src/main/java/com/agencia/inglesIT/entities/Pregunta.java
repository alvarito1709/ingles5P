package com.agencia.inglesIT.entities;


import javax.persistence.*;

@Entity
public class Pregunta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String enunciado;

    private String tipo;

    private Long respuesta;

    private Integer nivel;

    @ManyToOne
    private Apartado apartado;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEnunciado() {
        return enunciado;
    }

    public void setEnunciado(String enunciado) {
        this.enunciado = enunciado;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Long getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(Long respuesta) {
        this.respuesta = respuesta;
    }

    public Integer getNivel() {
        return nivel;
    }

    public void setNivel(Integer nivel) {
        this.nivel = nivel;
    }

    public Apartado getApartado() {
        return apartado;
    }

    public void setApartado(Apartado apartado) {
        this.apartado = apartado;
    }
}
