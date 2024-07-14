package com.example.ForumHub.dto;

import com.example.ForumHub.domain.topico.StatusTopico;
import com.example.ForumHub.domain.topico.Topico;

import java.time.LocalDateTime;

public record DetalhamentoTopicoDTO(Long id, String titulo, String mensagem, LocalDateTime dataCriacao, StatusTopico status, String autor, String curso) {
    public DetalhamentoTopicoDTO(Topico topico) {
        this(topico.getId(), topico.getTitulo(), topico.getMensagem(), topico.getDataCriacao(), topico.getStatus(), topico.getAutor(), topico.getCurso());
    }
}
