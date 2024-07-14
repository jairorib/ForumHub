package com.example.ForumHub.dto;

import com.example.ForumHub.domain.topico.StatusTopico;
import com.example.ForumHub.domain.topico.Topico;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDateTime;

public record TopicoDTO(
                        @NotBlank
                        String titulo,
                        @NotBlank
                        String mensagem,
                        LocalDateTime dataCriacao,
                        StatusTopico status,
                        @NotBlank
                        String autor,
                        @NotBlank
                        String curso) {

    public TopicoDTO(Topico topico) {
        this(topico.getTitulo(), topico.getMensagem(), topico.getDataCriacao(), topico.getStatus(), topico.getAutor(), topico.getCurso());
    }
}
