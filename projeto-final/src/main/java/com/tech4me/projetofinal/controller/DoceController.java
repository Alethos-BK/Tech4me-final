package com.tech4me.projetofinal.controller;

import java.util.List;
import java.util.Optional;

import com.tech4me.projetofinal.model.Doce;
import com.tech4me.projetofinal.service.DoceService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/doces")
public class DoceController {
    
    @Autowired
    private DoceService doceService;

    @GetMapping()
    public List<Doce> obterTodos(){
        return doceService.obterTodos();
    }

    @GetMapping("/{id}")
    public Optional<Doce> obterPorId(Integer id){
        return doceService.obterPorId(id);
    }

    @PutMapping("/{id}")
    public Doce atualizar(@PathVariable Integer id, @RequestBody Doce doce){
        return doceService.atualizar(id, doce);
    }

    @PostMapping
    public ResponseEntity<Doce> cadastrar(@RequestBody Doce doce){
        return new ResponseEntity<> (doceService.cadastrar(doce), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public Doce deletar(Integer id){
        return doceService.deletar(id);
    }
}
