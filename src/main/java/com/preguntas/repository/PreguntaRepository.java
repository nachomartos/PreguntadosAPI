package com.preguntas.repository;

import com.preguntas.entity.Pregunta;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PreguntaRepository extends JpaRepository<Pregunta, Long> {

    List<Pregunta> findByEnunciado(String enunciado);

}
