package com.example.ForumHub.dto;

import com.example.ForumHub.domain.topico.StatusTopico;
import jakarta.validation.constraints.NotNull;

public record AtualizaTopicoDTO(@NotNull Long id, StatusTopico status) {
}
