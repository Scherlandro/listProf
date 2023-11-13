package com.api.listProf.service;

import com.api.listProf.entity.Profissionais;

import java.util.List;
import java.util.Optional;

public interface ProfissionaisService {

    List<Profissionais> listarProfissionais();
    Profissionais save(Profissionais profissionais) ;
    Optional<Profissionais> findById(Integer id) ;
    void delete(Integer id);
}
