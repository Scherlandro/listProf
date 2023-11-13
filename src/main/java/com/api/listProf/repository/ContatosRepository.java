package com.api.listProf.repository;

import com.api.listProf.entity.Contatos;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ContatosRepository extends JpaRepository<Contatos, Integer > {

     Contatos findByContato(Contatos contatos);

}
