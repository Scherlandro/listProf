package com.api.listProf.service;


import com.api.listProf.entity.Contatos;

import java.util.List;
import java.util.Optional;

public interface ContatosService {

    List<Contatos> listarContatos();
    Contatos save(Contatos contatos) ;
    Optional<Contatos> findById(Integer id) ;
    Contatos findByContatos(Contatos contatos) ;
    void delete(Integer id);
	
}
