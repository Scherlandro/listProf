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
        private ContatosService cont_serv;
        private ContatosDto contatosDto;
        @Autowired
        private ModelMapper mapper;

        @GetMapping(path = "/contatos")
        public ResponseEntity<List<ContatosDto>> listarContatos(){
           List<Contatos> list = cont_serv.listarContatos();
           return ResponseEntity.ok(list.stream().map(
              e->mapper.map(e, ContatosDto.class)).collect(Collectors.toList()));
        }

        @GetMapping(path = "/contatos/{id}")
        public ResponseEntity consultarPorID(@PathVariable("id") Integer id){
           Optional<Contatos> contatos = cont_serv.findById(id);
            return ResponseEntity.ok(contatos.map(e->mapper.map(e,
                ContatosDto.class)).map(record -> ResponseEntity.ok().body(record))
                  .orElse(ResponseEntity.notFound().build()));
        }
    @PostMapping(path = "/contatos")
    public ResponseEntity salvar(@RequestBody ContatosDto contatosDto){
        cont_serv.save(mapper.map(contatosDto, Contatos.class));
        Optional<Contatos> contatos = cont_serv.findById(contatosDto.getId());
        return ResponseEntity.ok(contatos.map(e->mapper.map(e,
                ContatosDto.class)).map(record -> ResponseEntity.ok().body(record))
                .orElse(ResponseEntity.notFound().build()));
    }
    @PutMapping(path = "/contatos")
    public ResponseEntity editar(@RequestBody ContatosDto contatosDto){
        cont_serv.save(mapper.map(contatosDto, Contatos.class));
        Optional<Contatos> contatos = cont_serv.findById(contatosDto.getId());
        return ResponseEntity.ok(contatos.map(e->mapper.map(e,
                ContatosDto.class)).map(record -> ResponseEntity.ok().body(record))
                .orElse(ResponseEntity.notFound().build()));
    }

    @DeleteMapping(path = "/contatos/{id}")
    public ResponseEntity excluir(@PathVariable("id") Integer id){
        cont_serv.delete(id);
        return ResponseEntity.noContent().build();
    }


}
