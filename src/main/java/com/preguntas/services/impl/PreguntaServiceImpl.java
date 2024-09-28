package com.preguntas.services.impl;

import com.preguntas.repository.PreguntaRepository;
import com.preguntas.dto.request.PreguntaRequestDTO;
import com.preguntas.entity.Pregunta;
import com.preguntas.exceptions.custom.ResourceNotFoundException;
import com.preguntas.services.PreguntaService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class PreguntaServiceImpl implements PreguntaService {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private PreguntaRepository preguntaRepository;

    @Override
    public Pregunta create(PreguntaRequestDTO preguntaRequestDTO) {
        Pregunta preguntaACrear = mapPreguntaRequestDTOToPregunta(preguntaRequestDTO);
        Pregunta preguntaCreada = preguntaRepository.save(preguntaACrear);
        return preguntaCreada;
    }

    @Override
    public Pregunta getOne(Long id) {
        Pregunta pregunta = preguntaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Pregunta", "id", id));
        return pregunta;

    }

    @Override
    public Page<Pregunta> getAll(Pageable pageable) {
        return preguntaRepository.findAll(pageable);
    }

    @Override
    public Pregunta update(PreguntaRequestDTO preguntaRequestDTO, Long id) {
        Pregunta preguntaAActualizar = preguntaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Pregunta", "id", id));

        preguntaAActualizar.setEnunciado(preguntaRequestDTO.getEnunciado());

        Pregunta preguntaActualizada = preguntaRepository.save(preguntaAActualizar);
        return preguntaActualizada;

    }

    @Override
    public void delete(Long id) {
        Pregunta preguntaAEliminar = preguntaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Pregunta", "id", id));

        preguntaRepository.delete(preguntaAEliminar);

    }

    /**
     * Convierte DTO a entidad
     *
     * @param preguntaRequestDTO
     * @return
     */
    private Pregunta mapPreguntaRequestDTOToPregunta(PreguntaRequestDTO preguntaRequestDTO) {
        Pregunta pregunta = modelMapper.map(preguntaRequestDTO, Pregunta.class);
        return pregunta;
    }

}
