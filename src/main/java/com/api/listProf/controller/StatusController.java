package com.api.listProf.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api")
public class StatusController {

    @GetMapping(path = "/status")
    public String check(){
        return "Teste de retorno da API";
    }
}
