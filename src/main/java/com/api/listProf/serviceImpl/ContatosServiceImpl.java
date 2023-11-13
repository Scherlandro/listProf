package com.api.listProf.serviceImpl;

import com.api.listProf.entity.Contatos;
import com.api.listProf.repository.ContatosRepository;
import com.api.listProf.service.ContatosService;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class ContatosServiceImpl implements ContatosService {
    final ContatosRepository contatosRepository;

    public ContatosServiceImpl(ContatosRepository repository) {

        this.contatosRepository = repository;
    }
    @Override
    public Optional<Contatos> findById(Integer id) {
        return contatosRepository.findById(id);
    }

    @Override
    public Contatos findByContatos(Contatos contatos) {
        return contatosRepository.findByContato(contatos);
    }

    @Override
    public List<Contatos> listarContatos() {
        return contatosRepository.findAll();
    }

    @Override
    public Contatos save(Contatos contatos) {
        return contatosRepository.save(contatos);
    }

    @Override
    public void delete(Integer id) {
        contatosRepository.deleteById(id);
    }
	

}
