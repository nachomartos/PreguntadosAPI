package com.preguntas.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
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

}
