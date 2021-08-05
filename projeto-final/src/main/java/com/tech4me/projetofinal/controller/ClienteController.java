package com.tech4me.projetofinal.controller;

import java.util.List;
import java.util.Optional;

import com.tech4me.projetofinal.model.cliente.Cliente;
import com.tech4me.projetofinal.service.cliente.ClienteService;

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
@RequestMapping("/api/clientes")
public class ClienteController {
        
    @Autowired
    private ClienteService _clienteService;

    @GetMapping()
    public ResponseEntity<List<Cliente>> obterTodos(){
        return new ResponseEntity<>(_clienteService.obterTodos(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public Optional<Cliente> obterPorId(Long id){
        return _clienteService.obterPorId(id);
    }

    @PutMapping("/{id}")
    public Cliente atualizar(@PathVariable Long id, @RequestBody Cliente cliente){
        return _clienteService.atualizar(id, cliente);
    }

    @PostMapping
    public ResponseEntity<Cliente> cadastrar(@RequestBody Cliente cliente){
        return new ResponseEntity<> (_clienteService.cadastrar(cliente), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public Cliente deletar(Long id){
        return _clienteService.deletar(id);
    }
}
