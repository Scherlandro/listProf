package com.api.listProf.service;

import com.api.listProf.dtos.ProfissionaisDto;
import com.api.listProf.entity.Profissionais;
import com.api.listProf.repository.ProfissionaisRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.jdbc.DataJdbcTest;
import org.springframework.test.context.ActiveProfiles;

import javax.persistence.EntityManager;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DataJdbcTest
@ActiveProfiles("test")
class ProfissionaisServiceTest {
    @Autowired
    ProfissionaisRepository profRep;


    EntityManager entityManager;
    private Profissionais creater(ProfissionaisDto proDTO){
       Profissionais newprof = new Profissionais();
       this.entityManager.persist(newprof);
        return newprof;
    }

    @Test
    void listarProfissionais() {
    }

    @Test
    void save() {
        List<ProfissionaisDto> profList = new ArrayList<>();
        for (int i = 0; i < profList.size() ; i++) {
        ProfissionaisDto profDTO = new ProfissionaisDto();
        profDTO.setId_prof(1);
        profDTO.setNome("Zeca");
        profDTO.setCargo("Professor");
        profDTO.setNascimnento("2000-01-10 00:00:00.0");
        profDTO.setCreated_date(Timestamp.valueOf("2023-11-14T01:00:58.544+00:00"));
           this.creater(profDTO);
            this.findById(profDTO.getId_prof());
            Optional<Profissionais> result = this.findById(profDTO.getId_prof());
            assertThat(result.isPresent()).isTrue();
        }
    }

    @Test
    Optional<Profissionais> findById(Integer id) {
        return profRep.findById(id);
    }

    @Test
    void delete() {
    }
}