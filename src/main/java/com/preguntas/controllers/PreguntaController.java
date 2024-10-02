package com.preguntas.controllers;

import com.preguntas.dto.request.PreguntaRequestDTO;
import com.preguntas.entity.Pregunta;
import com.preguntas.services.PreguntaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@CrossOrigin(origins = "http://localhost:8080")
@RequestMapping("api/v1/preguntas")
public class PreguntaController {

    @Autowired
    private PreguntaService preguntaService;

    /**
     *
     * @param preguntaRequestDTO
     * @return
     */
    @Operation(summary = "Crear una pregunta")
    @PostMapping
    public ResponseEntity<?> create(@Valid @RequestBody PreguntaRequestDTO preguntaRequestDTO) {
        Pregunta preguntaCreada = preguntaService.create(preguntaRequestDTO);
        return new ResponseEntity<>(preguntaCreada, HttpStatus.CREATED);
    }

    /**
     *
     * @param idPregunta
     * @return
     */
    @Operation(summary = "Obtener una pregunta")
    @GetMapping("/{id}")
    public ResponseEntity<?> getOne(@PathVariable(name = "id") Long idPregunta) {
        Pregunta pregunta = preguntaService.getOne(idPregunta);
        return new ResponseEntity<>(pregunta, HttpStatus.OK);
    }

    /**
     *
     * @param preguntaRequestDTO
     * @param idPregunta
     * @return
     */
    @Operation(summary = "Actualizar una pregunta")
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@Valid @RequestBody PreguntaRequestDTO preguntaRequestDTO,
                                    @PathVariable(name = "id") Long idPregunta) {
        Pregunta res = preguntaService.update(preguntaRequestDTO, idPregunta);
        return new ResponseEntity<>(res, HttpStatus.OK);


    }

    /**
     *
     * @param idPregunta
     * @return
     */
    @Operation(summary = "Eliminar una pregunta")
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable(name = "id") Long idPregunta) {
        preguntaService.delete(idPregunta);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    /**
     *
     *
     * @PageableDefault(page = 1, size = 4, sort = "enunciado", direction =
     *                       Sort.Direction.DESC)
     *
     * @return
     */

    @Operation(summary = "Obtener todas las preguntas existentes al momento")
    @GetMapping()
    public ResponseEntity<?> getAll(Pageable pageable) {
        Page<Pregunta> res = preguntaService.getAll(pageable);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }

}
