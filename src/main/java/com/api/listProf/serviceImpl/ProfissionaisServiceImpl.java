package com.api.listProf.serviceImpl;

import com.api.listProf.entity.Profissionais;
import com.api.listProf.repository.ProfissionaisRepository;
import com.api.listProf.service.ProfissionaisService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

 @Service
public class ProfissionaisServiceImpl implements ProfissionaisService {

   final ProfissionaisRepository profissionaisRepository;

   public ProfissionaisServiceImpl(ProfissionaisRepository repository) {

        this.profissionaisRepository = repository;
    }
        @Override
    public Optional<Profissionais> findById(Integer id) {
        return profissionaisRepository.findById(id);
    }

     @Override
        public List<Profissionais> listarProfissionais() {
            return profissionaisRepository.findAll();
        }
        @Override
        public Profissionais save(Profissionais profissionais) {
        return profissionaisRepository.save(profissionais);
    }

     @Override
     public void delete(Integer id) {
          profissionaisRepository.deleteById(id);
     }


}
