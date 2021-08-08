package com.tech4me.projetofinal.service.doce;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Optional;

import com.tech4me.projetofinal.model.doce.Doce;
import com.tech4me.projetofinal.repository.DoceRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DoceServiceImpl implements DoceService {

    @Autowired
    private DoceRepository doceRepository;

    @Override
    public List<Doce> obterTodos(){
        return doceRepository.findAll();
    }

    @Override
    public Optional<Doce> obterPorId(Long id){
        return doceRepository.findById(id);
    }

    @Override
    public Doce atualizar(Long id, Doce doce){
        doce.setId(id);
        doceRepository.save(doce);
        return doce;
    }

    @Override
    public Doce cadastrar(Doce doce){
        doce.setId(null);
        doceRepository.save(doce);
        return doce;
    }

    @Override
    public Doce deletar(Long id){
        Optional<Doce> doce = obterPorId(id);
        if(doce.isEmpty()){
            throw new InputMismatchException("Infelizmente o doce não encontrado.");
        }
        doceRepository.deleteById(id);
        return doce.get();
    }
}
