package com.api.listProf.controller;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.sql.Timestamp;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@ContextConfiguration(classes = ProfissionaisControllerTest.class)
class ProfissionaisControllerTest {

    private MockMvc mvc;

    ProfissionaisControllerTest(MockMvc mvc) {
        this.mvc = mvc;
    }

    @Test
    void listarProfissionais() throws Exception {
        mvc.perform(
                get("/api/profissionais") )
                .andExpect(status().isCreated());
    }

    @Test
    void consultarPorID()  throws Exception {
        mvc.perform(
                get("/api/profissionais/{1}") )
                .andExpect(status().isCreated());
    }

    @Test
    void salvar()throws Exception {
        String dtCreated = (Timestamp.valueOf("2023-11-14T01:00:58.544+00:00")).toString();
            mvc.perform(
                    post("/api/profissionais")
                            .param("id_prof","1")
                            .param("nome", "Assis")
                            .param("Cargo", "professor")
                            .param("Nascimento", "2000-01-10 00:00:00.0")
                            .param("Created_date", dtCreated) )
                    .andExpect(status().isCreated());
    }

    @Test
    void editar()throws Exception {
        String dtCreated = (Timestamp.valueOf("2023-11-14T01:00:58.544+00:00")).toString();
        mvc.perform(
                put("/api/profissionais/{1}")
                        .param("nome", "Assis")
                        .param("Cargo", "diretor")
                        .param("Nascimento", "2000-01-10 00:00:00.0")
                        .param("Created_date", dtCreated) )
                .andExpect(status().isCreated());
    }

    @Test
    void excluir() throws Exception {
        mvc.perform(
                delete("/api/profissionais/{1}") )
                .andExpect(status().isCreated());
    }
}