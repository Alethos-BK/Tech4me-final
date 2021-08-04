package com.tech4me.projetofinal.service;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Optional;

import com.tech4me.projetofinal.model.Doce;
import com.tech4me.projetofinal.repository.DoceRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DoceService {
    
    @Autowired
    private DoceRepository doceRepository;

    public List<Doce> obterTodos(){
        return doceRepository.findAll();
    }

    public Optional<Doce> obterPorId(Integer id){
        return doceRepository.findById(id);
    }

    public Doce atualizar(Integer id, Doce doce){
        doce.setId(id);
        doceRepository.save(doce);
        return doce;
    }

    public Doce cadastrar(Doce doce){
        doce.setId(null);
        doceRepository.save(doce);
        return doce;
    }

    public Doce deletar(Integer id){
        Optional<Doce> doce = obterPorId(id);
        if(doce.isEmpty()){
            throw new InputMismatchException("Infelizmente o doce não encontrado.");
        }
        doceRepository.deleteById(id);
        return doce.get();
    }
}
