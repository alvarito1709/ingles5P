package com.agencia.inglesIT.entities;


import javax.persistence.*;

@Entity
public class Apartado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombreApartado;

    private Integer nivel;

    private String video;

    private String texto;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombreApartado() {
        return nombreApartado;
    }

    public void setNombreApartado(String nombreApartado) {
        this.nombreApartado = nombreApartado;
    }

    public Integer getNivel() {
        return nivel;
    }

    public void setNivel(Integer nivel) {
        this.nivel = nivel;
    }

    public String getVideo() {
        return video;
    }

    public void setVideo(String video) {
        this.video = video;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

}


