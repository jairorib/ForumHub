package com.example.ForumHub.controller;

import com.example.ForumHub.dto.AtualizaTopicoDTO;
import com.example.ForumHub.dto.DetalhamentoTopicoDTO;
import com.example.ForumHub.dto.ListagemTopicoDTO;
import com.example.ForumHub.dto.TopicoDTO;
import com.example.ForumHub.repository.TopicoRepository;
import com.example.ForumHub.domain.topico.Topico;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Optional;

@RestController
@RequestMapping("topicos")
public class TopicoController {

    @Autowired
    private TopicoRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid TopicoDTO dados, UriComponentsBuilder uriBuilder) {
        var topico = new Topico(dados);
        repository.save(topico);

        var uri = uriBuilder.path("/topicos/{id}").buildAndExpand(topico.getId()).toUri();

        return ResponseEntity.created(uri).body(new DetalhamentoTopicoDTO(topico));

    }

    @GetMapping
    public ResponseEntity<Page<ListagemTopicoDTO>> listarTopicos(@PageableDefault(size=10, sort={"curso","dataCriacao"}) Pageable pagenation) {
        var page = repository.findAll(pagenation).map(ListagemTopicoDTO::new);
        return ResponseEntity.ok(page);
    }

    @PutMapping
    @Transactional
    public ResponseEntity atualizar(@RequestBody @Valid AtualizaTopicoDTO dados) {
        var topico = repository.getReferenceById(dados.id());
        topico.atualizarInformacoes(dados);

        return ResponseEntity.ok(new DetalhamentoTopicoDTO(topico));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity excluir(@PathVariable Long id) {
        Optional<Topico> topico = repository.findById(id);
        //var topico = repository.getReferenceById(id);
        if (topico.isPresent()) {
            repository.deleteById(id);
        }
        //topico.excluir();
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity detalhar(@PathVariable Long id) {
        var topico = repository.getReferenceById(id);
        return ResponseEntity.ok(new DetalhamentoTopicoDTO(topico));
    }

}
