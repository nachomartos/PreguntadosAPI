package com.preguntas.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "pregunta", uniqueConstraints = { @UniqueConstraint(columnNames = { "enunciado" }) })
public class Pregunta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pregunta")
    private Long id;

    @Column(name ="enunciado", nullable = false)
    private String enunciado;

    public Pregunta() {

    }

    public Pregunta(Long id, String enunciado) {
        this.id = id;
        this.enunciado = enunciado;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id){
        this.id = id;
    }

    public String getEnunciado() {
        return enunciado;
    }

    public void setEnunciado(String enunciado){
        this.enunciado = enunciado;
    }

}
