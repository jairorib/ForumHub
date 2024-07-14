package com.example.ForumHub.domain.topico;

import jakarta.persistence.PrePersist;

import java.time.LocalDateTime;

public class TopicoListener {

    @PrePersist
    public void prePersist(Topico topico) {
        if (topico.getDataCriacao() == null) {
            topico.setDataCriacao(LocalDateTime.now());
        }
        if (topico.getStatus() == null) {
            topico.setStatus(Enum.valueOf(StatusTopico.class, "ABERTA"));
        }
    }
}
