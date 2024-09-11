package com.preguntas.services;

import com.preguntas.dto.request.PreguntaRequestDTO;
import com.preguntas.entity.Pregunta;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface PreguntaService {
    public Pregunta create(PreguntaRequestDTO preguntaRequestDTO);


    public Pregunta getOne(Long id);


    public Page<Pregunta> getAll(Pageable pageable);


    public Pregunta update(PreguntaRequestDTO preguntaRequestDTO, Long id);


    public void delete(Long id);

}
