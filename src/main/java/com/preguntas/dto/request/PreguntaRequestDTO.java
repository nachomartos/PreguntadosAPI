package com.preguntas.dto.request;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class PreguntaRequestDTO {
    @NotEmpty
    private String enunciado;

    public PreguntaRequestDTO() {
    }

    public PreguntaRequestDTO(String enunciado) {
        this.enunciado = enunciado;
    }
}
