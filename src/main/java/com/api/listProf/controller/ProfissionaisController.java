package com.api.listProf.controller;

import com.api.listProf.dtos.ProfissionaisDto;
import com.api.listProf.entity.Profissionais;
import com.api.listProf.service.ProfissionaisService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path = "/api")
public class ProfissionaisController {

    @Autowired
    private ProfissionaisService prof_serv;
    private ProfissionaisDto profissionaisDto;
    @Autowired
    private ModelMapper mapper;

    @GetMapping(path = "/profissionais")
    public ResponseEntity<List<ProfissionaisDto>> listarProfissionais(){
       List<Profissionais> list = prof_serv.listarProfissionais();
            return ResponseEntity.ok(list.stream().map(
                e->mapper.map(e,ProfissionaisDto.class)).collect(Collectors.toList()));
    }

    @GetMapping(path = "/profissionais/{id_prof}")
    public ResponseEntity consultarPorID(@PathVariable("id_prof") Integer id_prof){
           Optional<Profissionais> profissional = prof_serv.findById(id_prof);
            return ResponseEntity.ok(profissional.map(e->mapper.map(e,
                    ProfissionaisDto.class)).map(record -> ResponseEntity.ok().body(record))
                    .orElse(ResponseEntity.notFound().build()));
    }

    @PostMapping(path = "/profissionais")
    public ResponseEntity salvar(@RequestBody ProfissionaisDto profissionaisDto){
        prof_serv.save(mapper.map(profissionaisDto, Profissionais.class));
        Optional<Profissionais> profissionais = prof_serv.findById(profissionaisDto.getId_prof());
            return ResponseEntity.ok(profissionais.map(e->mapper.map(e,
                    ProfissionaisDto.class)).map(record -> ResponseEntity.ok().body(record))
                    .orElse(ResponseEntity.notFound().build()));
    }

    @PutMapping(path = "/profissionais")
    public ResponseEntity editar(@RequestBody ProfissionaisDto profissionaisDto){
        prof_serv.save(mapper.map(profissionaisDto, Profissionais.class));
        Optional<Profissionais> profissionais = prof_serv.findById(profissionaisDto.getId_prof());
        return ResponseEntity.ok(profissionais.map(e->mapper.map(e,
                ProfissionaisDto.class)).map(record -> ResponseEntity.ok().body(record))
                .orElse(ResponseEntity.notFound().build()));
    }

    @DeleteMapping(path = "/profissionais/{id_prof}")
    public ResponseEntity excluir(@PathVariable("id_prof") Integer id_prof){
        prof_serv.delete(id_prof);
        return ResponseEntity.noContent().build();
    }
	
}
