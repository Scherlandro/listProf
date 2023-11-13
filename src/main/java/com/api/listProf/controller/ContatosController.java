package com.api.listProf.controller;

import com.api.listProf.dtos.ContatosDto;
import com.api.listProf.entity.Contatos;
import com.api.listProf.service.ContatosService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path = "/api")
    public class ContatosController {
        @Autowired
        private ContatosService contatosService;

        private ContatosDto contatosDto;
        @Autowired
        private ModelMapper mapper;

        @GetMapping(path = "/contatos")
        public ResponseEntity<List<ContatosDto>> listarContatos(){
                    List<Contatos> list = contatosService.listarContatos();
           return ResponseEntity.ok(
                   list.stream().map(e->mapper.map(e,
                           ContatosDto.class))
                   .collect(Collectors.toList()));
        }

        @GetMapping(path = "/contatos/{id}")
        public ResponseEntity consultar(@PathVariable("id") Integer id){
               Optional<Contatos> contatos = contatosService.findById(id);
            return ResponseEntity.ok(contatos.map(e->mapper.map(e,
                    ContatosDto.class)).map(record ->
                    ResponseEntity.ok().body(record))
                    .orElse(ResponseEntity.notFound().build()));
        }
        @PostMapping(path = "/contatos")
        public ResponseEntity salvar(@RequestBody ContatosDto contatosDto){
             contatosService.save(mapper.map(contatosDto, Contatos.class));
             Contatos contatos = contatosService
                     .findByContatos(mapper.map(contatosDto, Contatos.class));
            return ResponseEntity.ok(contatos);
        }

        @PutMapping(path = "/contatos")
        public ContatosDto editar(@RequestBody ContatosDto contatosDto){
            contatosService.save(mapper.map(contatosDto, Contatos.class));
            Contatos contatos = contatosService
                    .findByContatos(mapper.map(contatosDto, Contatos.class));
            return mapper.map(contatos,ContatosDto.class);
        }

        @DeleteMapping(path = "/delete/{id}")
        public void excluir(@PathVariable("id") Integer id){
            contatosService.delete(id);
        }

    }
